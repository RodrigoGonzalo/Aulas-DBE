package br.com.fiap.model;

import java.math.BigDecimal;

public class Setup {
	private String NomeSetup = "Meu Setup";
	private String Descricao = "Descrição";
	private BigDecimal Preco = new BigDecimal(10000);

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public BigDecimal getPreco() {
		return Preco;
	}

	public void setPreco(BigDecimal preco) {
		Preco = preco;
	}

	public String getNomeSetup() {
		return NomeSetup;
	}

	public void setNomeSetup(String nomeSetup) {
		NomeSetup = nomeSetup;
	}

	@Override
	public String toString() {
		return "Setup [NomeSetup=" + NomeSetup + ", Descricao=" + Descricao + ", Preco=" + Preco + "]";
	}
	
	
}
