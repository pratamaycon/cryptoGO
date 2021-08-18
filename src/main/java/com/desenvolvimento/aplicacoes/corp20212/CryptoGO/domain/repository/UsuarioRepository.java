package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		
	Usuario findByLogin(String login);

}
