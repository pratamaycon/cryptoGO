package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.api.model.input.SenhaInput;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.exception.EntidadeNaoEncontradaException;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.Usuario;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.UsuarioRepository;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
@Api(value = "Resource Usuário")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioRepository repository;

	@GetMapping(value = { "v1/users" })
	@ApiOperation(value = "Retorna uma lista de Usuários", response = Usuario[].class)
	@ResponseStatus(HttpStatus.OK)
	
	public List<Usuario> buscarTodos() {
		return repository.findAll();
	}

	@GetMapping(value = { "v1/users/{login}" })
	@ApiOperation(value = "Retorna um usuário de acordo com o login", response = Usuario.class)
	public ResponseEntity<?> buscarPeloLogin(@PathVariable("login") String login) {
		Usuario usuarioExiste = service.buscarOuFalhar(login);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioExiste);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping(value = { "v1/users" })
	@ApiOperation(value = "Cadastra um usuário", response = Usuario.class)
	public ResponseEntity<?> criar(@RequestBody Usuario usuario) {
		Usuario usuarioSalvo = service.salvar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	@PutMapping(value = { "v1/users/{login}" })
	@ApiOperation(value = "Atualiza um usuário, com exceção de sua senha", response = Usuario.class)
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario, @PathVariable("login") String login) {
		try {
			Usuario usuarioExistente = service.buscarOuFalhar(login);
			BeanUtils.copyProperties(usuario, usuarioExistente, "codigo", "senha");
			Usuario usuarioAtual = service.salvar(usuarioExistente);
			return ResponseEntity.status(HttpStatus.OK).body(usuarioAtual);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PutMapping(value = { "v1/users/{codigo}/senha" })
	@ApiOperation(value = "Atualiza a senha do usuário")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarSenha(@PathVariable("codigo") Long codigo, @RequestBody @Valid SenhaInput senha ) {
		service.alterarSenha(codigo, senha.getSenhaAtual(), senha.getNovaSenha());
	}
	
	@DeleteMapping(value = { "v1/crypto/{login}" })
	@ApiOperation(value = "Deletar usuário pelo login")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removePessoa(@PathVariable("login") String login){	
			service.deletarUsuario(login);
	}
}
