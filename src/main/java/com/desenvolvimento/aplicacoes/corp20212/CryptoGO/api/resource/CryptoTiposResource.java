package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoTipos;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.CryptoTiposRepository;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.service.CryptoTipoService;

@RestController
@RequestMapping("/api/")
public class CryptoTiposResource {

	@Autowired
	private CryptoTiposRepository repository;

	private CryptoTipoService service;

	@GetMapping(value = { "v1/crypto" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public List<CryptoTipos> buscarTodos(@RequestParam("page") int page, @RequestParam("size") int size) {
		return service.paginacao(page, size);
	}
	
	@PostMapping(value = { "v1/crypto" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CryptoTipos> criar(@RequestBody CryptoTipos crypto) {
		CryptoTipos cryptoSalva = repository.save(crypto);
		return ResponseEntity.status(HttpStatus.CREATED).body(cryptoSalva);
	}

}
