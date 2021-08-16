package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.domain.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cripto_tipos")
public class CryptoTipos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nome;

	@CreationTimestamp
	@Column(nullable = false)
	private LocalDate dataCadastro;

	@JsonIgnoreProperties("criptoTipos")
	@OneToMany(mappedBy = "criptoTipos", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<CryptoTransactions> criptoTransactions;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<CryptoTransactions> getCriptoTransactions() {
		return criptoTransactions;
	}

	public void setCriptoTransactions(List<CryptoTransactions> criptoTransactions) {
		this.criptoTransactions = criptoTransactions;
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
		CryptoTipos other = (CryptoTipos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CryptoTipos [codigo=" + codigo + ", nome=" + nome + ", dataCadastro=" + dataCadastro
				+ ", criptoTransactions=" + criptoTransactions + "]";
	}	
	
	
}
