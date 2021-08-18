package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.repository.recomendacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model.CryptoTipos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class RecomendacaoThresholdDTO {

	private LocalDate data;

	private BigDecimal valorCorrente;

	@JsonIgnoreProperties("criptoTransactions")
	private CryptoTipos criptoTipos;

	public RecomendacaoThresholdDTO(LocalDate data, BigDecimal valorCorrente, CryptoTipos criptoTipos) {
		this.data = data;
		this.valorCorrente = valorCorrente;
		this.criptoTipos = criptoTipos;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValorCorrente() {
		return valorCorrente;
	}

	public void setValorCorrente(BigDecimal valorCorrente) {
		this.valorCorrente = valorCorrente;
	}

	public CryptoTipos getCriptoTipos() {
		return criptoTipos;
	}

	public void setCriptoTipos(CryptoTipos criptoTipos) {
		this.criptoTipos = criptoTipos;
	}

}
