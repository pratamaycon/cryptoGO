package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.exception.EntidadeNaoEncontradaException;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoTipos;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.CryptoTiposRepository;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.recomendacoes.CryptoTransactionsRepository;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.recomendacoes.RecomendacaoThresholdDTO;

@Service
public class CryptoTipoService {

	@Autowired
	private CryptoTiposRepository repository;
	
	@Autowired
	private CryptoTransactionsRepository transactionsRepository;
	
	private static final String MSG_ENTIDADE_NAO_ENCONTRADA 
	= "A entidade Crypto de código %d não foi encontrada";

	/**
	 * Lista todas as entidades CryptoTipos com paginação *
	 * 
	 * @param page
	 * @param size
	 * @return retorna uma lista de entidades com paginação
	 */
	public Page<CryptoTipos> paginacao(int page, int size) {
		return repository.findAll(PageRequest.of(page, size));
	}
	
	public List<RecomendacaoThresholdDTO> recomendacaoThresholdAposDia(LocalDate data) {
		return transactionsRepository.findByDataAfter(data);
	}
	
	public List<RecomendacaoThresholdDTO> recomendacaoThresholdAntesDia(LocalDate data) {
		return transactionsRepository.findByDataBefore(data);
	}
	
	@Transactional
	public CryptoTipos salvarCrypto(CryptoTipos crypto) {
		crypto.getCriptoTransactions().forEach( 
				criptoTransactions -> criptoTransactions.setCriptoTipos(crypto));
		return repository.save(crypto);
	}
	
	@Transactional
	public CryptoTipos atualizarCrypto(CryptoTipos crypto, Long codigo) {
		CryptoTipos cryptoBuscada = buscarOuFalhar(codigo);
		cryptoBuscada.getCriptoTransactions().clear();
		cryptoBuscada.getCriptoTransactions().addAll(crypto.getCriptoTransactions());
		cryptoBuscada.getCriptoTransactions().forEach( 
				criptoTransactions -> criptoTransactions.setCriptoTipos(cryptoBuscada));
		if (crypto.getNome() != null) {			
			cryptoBuscada.setNome(crypto.getNome());
		}
		
		if (crypto.getDataCadastro() != null) {			
			cryptoBuscada.setDataCadastro(crypto.getDataCadastro());
		}
		
		BeanUtils.copyProperties(cryptoBuscada, crypto);
		return repository.save(cryptoBuscada);
	}
	
	@Transactional
	public void deletarCrypto(Long codigo) {
		CryptoTipos cryptoBuscada = buscarOuFalhar(codigo);
		repository.delete(cryptoBuscada);
	}
	
	public CryptoTipos buscarOuFalhar(Long codigo) {
		return repository.findByCodigo(codigo)
			.orElseThrow(() -> 
			new EntidadeNaoEncontradaException(String.format(MSG_ENTIDADE_NAO_ENCONTRADA, codigo)));
	}
}
