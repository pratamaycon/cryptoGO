package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cripto_transactions")
public class CryptoTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private LocalDate data;

	private BigDecimal valorCorrente;

	@ManyToOne
	@JoinColumn(name = "id_crypto_tipos")
	private CryptoTipos criptoTipos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CryptoTransactions other = (CryptoTransactions) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
