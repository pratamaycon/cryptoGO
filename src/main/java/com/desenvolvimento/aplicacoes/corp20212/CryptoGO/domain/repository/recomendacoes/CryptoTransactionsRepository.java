package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.recomendacoes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoTransactions;

@Repository
public interface CryptoTransactionsRepository extends JpaRepository<CryptoTransactions, Long> {

	List<RecomendacaoThresholdDTO> findByDataAfter(LocalDate data);
	
	List<RecomendacaoThresholdDTO> findByDataBefore(LocalDate data);
}
