package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.exception.EntidadeNaoEncontradaException;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoTipos;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.service.CryptoTipoService;

@RestController
@RequestMapping("/api/")
public class CryptoTiposResource {

	@Autowired
	private CryptoTipoService service;

	@GetMapping(value = { "v1/crypto" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public Page<CryptoTipos> buscarTodos(@RequestParam("page") int page, @RequestParam("size") int size) {
		return service.paginacao(page, size);
	}
	
	@GetMapping(value = { "v1/crypto/{codigo}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> buscarPeloId(@PathVariable("codigo") Long codigo) {
		CryptoTipos crypto = service.buscarOuFalhar(codigo);

		try {
			return ResponseEntity.status(HttpStatus.OK).body(crypto);			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@PostMapping(value = { "v1/crypto" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CryptoTipos> criar(@RequestBody CryptoTipos crypto) {
		CryptoTipos cryptoSalva = service.salvarCrypto(crypto);
		return ResponseEntity.status(HttpStatus.CREATED).body(cryptoSalva);
	}
	
	@PutMapping(value = { "v1/crypto/{codigo}" })
	public ResponseEntity<CryptoTipos> atualizar(@RequestBody CryptoTipos crypto, @PathVariable("codigo") Long codigo) {
		try {		
			CryptoTipos cryptoAtualizada = service.atualizarCrypto(crypto, codigo);
			return ResponseEntity.status(HttpStatus.OK).body(cryptoAtualizada);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping(value = { "v1/crypto/{codigo}" })
	public void removePessoa(@PathVariable Long codigo){	
			service.deletarCrypto(codigo);
	}

}
