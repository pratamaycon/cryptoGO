package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoTipos;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.CryptoTiposRepository;

@Service
public class CryptoTipoService {
	
	@Autowired
	private CryptoTiposRepository repository;

    /**
     * Lista todas as entidades CryptoTipos com paginação  *
     * @param page
     * @param size
     * @return retorna uma lista de entidades com paginação
     */
	public List<CryptoTipos> paginacao(int page, int size) {
		return repository.findAll(PageRequest.of(page, size)).getContent();
	}

}
