package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		
	Usuario findByLogin(String login);

}
