package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.exception.EntidadeNaoEncontradaException;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.exception.NegocioException;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.Usuario;
import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final String MSG_USUARIO_NAO_ENCONTRADO
	= "O Login %s não foi encontrado";
	
	private static final String MSG_USUARIO_EM_USO
	= "Já existe um usuário cadastrado com o username %s";

	@Transactional
	public Usuario salvar(Usuario usuario) {
		String senhaRemovebcrypt = "";

		Optional<Usuario> usuarioExistente = Optional.ofNullable(repository.findByLogin(usuario.getLogin()));
		
		if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
			throw new NegocioException(
					String.format(MSG_USUARIO_EM_USO, usuario.getLogin()));
		}

		if (usuario.isNovo()) {
			senhaRemovebcrypt = passwordEncoder.encode(usuario.getSenha()).replace("{bcrypt}", "");
			usuario.setSenha(senhaRemovebcrypt);
		}

		return repository.save(usuario);
	}
	
	@Transactional
	public void alterarSenha(Long codigo, String senhaAtual, String novaSenha) {
		String senhaRemovebcrypt = "";
		Usuario usuario = repository.findById(codigo)
				.orElseThrow(() -> 
				new EntidadeNaoEncontradaException(String.format(MSG_USUARIO_NAO_ENCONTRADO, codigo)));
	
		if (!senhaAtual.equals(novaSenha)) {
			throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
		} 
		
		senhaRemovebcrypt = passwordEncoder.encode(novaSenha).replace("{bcrypt}", "");
		usuario.setSenha(senhaRemovebcrypt);
	}
	
	public void deletarUsuario(String login) {
		Usuario usuario = buscarOuFalhar(login);
		repository.delete(usuario);
	}
	
	public Usuario buscarOuFalhar(String login) {
		return Optional.ofNullable(repository.findByLogin(login))
			.orElseThrow(() -> 
			new EntidadeNaoEncontradaException(String.format(MSG_USUARIO_NAO_ENCONTRADO, login)));
	}
}
