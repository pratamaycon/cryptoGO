package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.exception.EntidadeNaoEncontradaException;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoThresholdUsuario;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.CryptoThresholdRepository;

@Service
public class CryptoThresholdService {
	
	@Autowired
	private CryptoThresholdRepository repository;
	
	private static final String MSG_ENTIDADE_NAO_ENCONTRADA 
	= "A entidade CryptoThresholdUsuario de código %d não foi encontrada";
	
	/**
	 * Lista todas as entidades CryptoThreshold com paginação *
	 * 
	 * @param page
	 * @param size
	 * @return retorna uma lista de entidades com paginação
	 */
	public Page<CryptoThresholdUsuario> paginacao(int page, int size) {
		return repository.findAll(PageRequest.of(page, size));
	}
	

	@Transactional
	public CryptoThresholdUsuario salvarCryptoThreshold(CryptoThresholdUsuario cryptoThreshold) {
		return repository.save(cryptoThreshold);
	}

	@Transactional
	public CryptoThresholdUsuario atualizarCryptoThreshold(CryptoThresholdUsuario cryptoThreshold, Long codigo) {
		CryptoThresholdUsuario cryptoThresholdBuscada = buscarOuFalhar(codigo);
		
		cryptoThresholdBuscada.getCriptoTipos().getCriptoTransactions().clear();
		cryptoThresholdBuscada.getCriptoTipos().getCriptoTransactions().addAll(cryptoThreshold.getCriptoTipos().getCriptoTransactions());
		cryptoThresholdBuscada.getCriptoTipos().getCriptoTransactions().forEach( 
				criptoTransactions -> criptoTransactions.setCriptoTipos(cryptoThreshold.getCriptoTipos()));
		
		BeanUtils.copyProperties(cryptoThreshold, cryptoThresholdBuscada, "codigo", "senha");
		System.out.println(cryptoThresholdBuscada);
		return repository.save(cryptoThresholdBuscada);
	}
	
	@Transactional
	public void deletarCryptoThreshold(Long codigo) {
		CryptoThresholdUsuario cryptoThresholdBuscada = buscarOuFalhar(codigo);
		repository.delete(cryptoThresholdBuscada);
	}
	
	public CryptoThresholdUsuario buscarOuFalhar(Long codigo) {
		return Optional.ofNullable(repository.findByCodigo(codigo))
				.orElseThrow(() -> 
				new EntidadeNaoEncontradaException(String.format(MSG_ENTIDADE_NAO_ENCONTRADA, codigo)));
	}
}
