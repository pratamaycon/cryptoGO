package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.model;

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
public class CriptoTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate data;

	private BigDecimal valor_corrente;

	@ManyToOne
	@JoinColumn(name = "id_cripto_tipos")
	private CriptoTipos criptoTipos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValor_corrente() {
		return valor_corrente;
	}

	public void setValor_corrente(BigDecimal valor_corrente) {
		this.valor_corrente = valor_corrente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public CriptoTipos getCriptoTipos() {
		return criptoTipos;
	}

	public void setCriptoTipos(CriptoTipos criptoTipos) {
		this.criptoTipos = criptoTipos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriptoTransactions other = (CriptoTransactions) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
