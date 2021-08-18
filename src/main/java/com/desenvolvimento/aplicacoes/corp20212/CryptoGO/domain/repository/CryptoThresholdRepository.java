package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoThresholdUsuario;

@Repository
public interface CryptoThresholdRepository extends JpaRepository<CryptoThresholdUsuario, Long> {

	CryptoThresholdUsuario findByCodigo(Long codigo);
	
}
