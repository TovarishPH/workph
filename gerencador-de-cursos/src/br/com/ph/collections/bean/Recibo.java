package br.com.ph.collections.bean;

public class Recibo {

	private String descricao;
	private int quantidade;
	
	public Recibo(String descricao, int quantidade) {
		this.descricao = descricao;
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	@Override
	public String toString() {
		return "[Descrição: " + this.descricao + ", quantidade: " + this.quantidade + "]";
	}
}
