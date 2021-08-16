package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.api.model.input;

import javax.validation.constraints.NotBlank;

public class SenhaInput {

	@NotBlank
	private String senhaAtual;

	@NotBlank
	private String novaSenha;

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((novaSenha == null) ? 0 : novaSenha.hashCode());
		result = prime * result + ((senhaAtual == null) ? 0 : senhaAtual.hashCode());
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
		SenhaInput other = (SenhaInput) obj;
		if (novaSenha == null) {
			if (other.novaSenha != null)
				return false;
		} else if (!novaSenha.equals(other.novaSenha))
			return false;
		if (senhaAtual == null) {
			if (other.senhaAtual != null)
				return false;
		} else if (!senhaAtual.equals(other.senhaAtual))
			return false;
		return true;
	}

}
