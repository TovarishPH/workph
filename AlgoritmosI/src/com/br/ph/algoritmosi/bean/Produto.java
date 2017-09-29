package com.br.ph.algoritmosi.bean;

public class Produto {

	private String nome;
	private double preco;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}
	
	
}
