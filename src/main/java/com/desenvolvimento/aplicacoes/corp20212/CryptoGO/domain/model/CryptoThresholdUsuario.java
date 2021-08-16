package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cripto_threshold_usuario")
public class CryptoThresholdUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private BigDecimal threshold_minimo;

	private BigDecimal threshold_maximo;

	private LocalDate data_atualizacao;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_usuario")
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_crypto_tipos")
	private CryptoTipos criptoTipos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
		CryptoThresholdUsuario other = (CryptoThresholdUsuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
