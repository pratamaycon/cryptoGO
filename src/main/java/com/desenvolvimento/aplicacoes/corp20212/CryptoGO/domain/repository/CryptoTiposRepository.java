package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoTipos;

public interface CryptoTiposRepository extends JpaRepository<CryptoTipos, Integer> {
	
	Optional<CryptoTipos> findByCodigo(Long codigo);

}
