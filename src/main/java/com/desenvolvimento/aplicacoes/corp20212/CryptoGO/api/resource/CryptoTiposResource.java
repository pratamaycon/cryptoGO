package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.api.resource;

import java.time.LocalDate;
import java.util.List;

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
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoTipos;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.recomendacoes.RecomendacaoThresholdDTO;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.service.CryptoTipoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
@Api(value = "Resource CryptoTipos")
public class CryptoTiposResource {
	
	@Autowired
	private CryptoTipoService service;

	@GetMapping(value = { "v1/cryptos" })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna uma lista paginada com as crypto")
	public Page<CryptoTipos> buscarTodos(@RequestParam("page") int page, @RequestParam("size") int size) {
		return service.paginacao(page, size);
	}
	
	@GetMapping("v1/recomendacao-aposDia/{dia}/{mes}/{ano}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna uma consulta que filtra os thresholds após a data informada")
	public List<RecomendacaoThresholdDTO> aposDia(
			@PathVariable("dia") Integer dia, 
			@PathVariable("mes") Integer mes, 
			@PathVariable("ano") Integer ano) {
		LocalDate data = LocalDate.of(ano, mes, dia);
		return service.recomendacaoThresholdAposDia(data);
	}
	
	@GetMapping("v1/recomendacao-antesDia/{dia}/{mes}/{ano}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna uma consulta que filtra os thresholds antes da data informada")
	public List<RecomendacaoThresholdDTO> antesDia(
			@PathVariable("dia") Integer dia, 
			@PathVariable("mes") Integer mes, 
			@PathVariable("ano") Integer ano) {
		LocalDate data = LocalDate.of(ano, mes, dia);
		return service.recomendacaoThresholdAntesDia(data);
	}
	
	@GetMapping(value = { "v1/cryptos/{nome}" })
	@ApiOperation(value = "Retorna uma crypto")
	public ResponseEntity<?> buscarPeloId(@PathVariable("nome") String nome) {
		CryptoTipos crypto = service.buscarOuFalharPorNome(nome);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(crypto);			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping(value = { "v1/cryptos" })
	@ApiOperation(value = "Salva uma crypto")
	public ResponseEntity<CryptoTipos> criar(@RequestBody CryptoTipos crypto) {
		CryptoTipos cryptoSalva = service.salvarCrypto(crypto);
		return ResponseEntity.status(HttpStatus.CREATED).body(cryptoSalva);
	}
	
	@PutMapping(value = { "v1/cryptos/{codigo}" })
	@ApiOperation(value = "Alterar uma crypto")
	public ResponseEntity<CryptoTipos> atualizar(@RequestBody CryptoTipos crypto, @PathVariable("codigo") Long codigo) {
		try {		
			CryptoTipos cryptoAtualizada = service.atualizarCrypto(crypto, codigo);
			return ResponseEntity.status(HttpStatus.OK).body(cryptoAtualizada);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping(value = { "v1/cryptos/{codigo}" })
	@ApiOperation(value = "Deletar uma crypto")
	public void remover(@PathVariable Long codigo){	
			service.deletarCrypto(codigo);
	}

}
