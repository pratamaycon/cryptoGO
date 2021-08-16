package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoThresholdUsuario;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.service.CryptoThresholdService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
@Api(value = "Resource CryptoThresholds")
public class CryptoThresholdResource {

	@Autowired
	private CryptoThresholdService service;

	@GetMapping(value = { "v1/cryptosThresholds" })
	@ApiOperation(value = "Retorna uma lista de CryptoThresholds com paginação", response = CryptoThresholdUsuario[].class)
	@ResponseStatus(HttpStatus.OK)
	public Page<CryptoThresholdUsuario> buscarTodos(@RequestParam("page") int page, @RequestParam("size") int size) {
		return service.paginacao(page, size);
	}

	@GetMapping(value = { "v1/cryptosThresholds/{codigo}" })
	@ApiOperation(value = "Retorna uma CryptoThresholds")
	public ResponseEntity<?> buscarPeloId(@PathVariable("codigo") Long codigo) {
		CryptoThresholdUsuario cryptoThresholds = service.buscarOuFalhar(codigo);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cryptoThresholds);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping(value = { "v1/cryptosThresholds" })
	@ApiOperation(value = "Salvar uma CryptoThresholds")
	public ResponseEntity<?> criar(@RequestBody CryptoThresholdUsuario cryptoThreshold) {
		CryptoThresholdUsuario cryptoSalva = service.salvarCryptoThreshold(cryptoThreshold);
		return ResponseEntity.status(HttpStatus.CREATED).body(cryptoSalva);
	}

	@PutMapping(value = { "v1/cryptosThresholds/{codigo}" })
	@ApiOperation(value = "Alterar uma CryptoThresholds")
	public ResponseEntity<CryptoThresholdUsuario> atualizar(@RequestBody CryptoThresholdUsuario cryptoThreshold,
			@PathVariable("codigo") Long codigo) {
		try {
			CryptoThresholdUsuario cryptoThresholdAtualizada = service.atualizarCryptoThreshold(cryptoThreshold,
					codigo);
			return ResponseEntity.status(HttpStatus.OK).body(cryptoThresholdAtualizada);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping(value = { "v1/cryptosThresholds/{codigo}" })
	@ApiOperation(value = "Deletar uma CryptoThresholds")
	public void remover(@PathVariable("codigo") Long codigo){	
		service.deletarCryptoThreshold(codigo);
	}
}
