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
@Table(name = "cripto_threshold_usuario")
public class CriptoThresholdUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal threshold_minimo;

	private BigDecimal threshold_maximo;

	private LocalDate data_atualizacao;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_cripto_tipos")
	private CriptoTipos criptoTipos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getThreshold_minimo() {
		return threshold_minimo;
	}

	public void setThreshold_minimo(BigDecimal threshold_minimo) {
		this.threshold_minimo = threshold_minimo;
	}

	public BigDecimal getThreshold_maximo() {
		return threshold_maximo;
	}

	public void setThreshold_maximo(BigDecimal threshold_maximo) {
		this.threshold_maximo = threshold_maximo;
	}

	public LocalDate getData_atualizacao() {
		return data_atualizacao;
	}

	public void setData_atualizacao(LocalDate data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public CriptoTipos getCriptoTipos() {
		return criptoTipos;
	}

	public void setCriptoTipos(CriptoTipos criptoTipos) {
		this.criptoTipos = criptoTipos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CriptoThresholdUsuario other = (CriptoThresholdUsuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
