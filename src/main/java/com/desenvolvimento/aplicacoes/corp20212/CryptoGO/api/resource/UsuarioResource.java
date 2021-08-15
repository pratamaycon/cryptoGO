package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.api.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.exception.EntidadeNaoEncontradaException;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.Usuario;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.UsuarioRepository;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.service.UsuarioService;

@RestController
@RequestMapping("/api/")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioRepository repository;

	@GetMapping(value = { "v1/users" })
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> buscarTodos() {
		return repository.findAll();
	}

	@GetMapping(value = { "v1/users/{login}" })
	public ResponseEntity<?> buscarPeloLogin(@PathVariable("login") String login) {
		Usuario usuarioExiste = service.buscarOuFalhar(login);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioExiste);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping(value = { "v1/users" })
	public ResponseEntity<?> criar(@RequestBody Usuario usuario) {
		Usuario usuarioSalvo = service.salvar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	@PutMapping(value = { "v1/users/{login}" })
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario, @PathVariable("login") String login) {
		try {
			Usuario usuarioExistente = service.buscarOuFalhar(login);
			BeanUtils.copyProperties(usuario, usuarioExistente, "codigo");
			Usuario usuarioAtual = service.salvar(usuarioExistente);
			return ResponseEntity.status(HttpStatus.OK).body(usuarioAtual);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
