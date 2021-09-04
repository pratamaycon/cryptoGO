package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoTipos;

@Repository
public interface CryptoTiposRepository extends JpaRepository<CryptoTipos, Integer> {
	
	Optional<CryptoTipos> findByCodigo(Long codigo);
	
	Optional<CryptoTipos> findByNome(String nome);

}
