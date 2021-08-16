package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoThresholdUsuario;

public interface CryptoThresholdRepository extends JpaRepository<CryptoThresholdUsuario, Long> {

	CryptoThresholdUsuario findByCodigo(Long codigo);
	
}
