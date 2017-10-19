package br.com.caelum.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private final Integer id;
	private final String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public void adicionaProduto(Produto produto){
		try{
			produtos.add(produto);
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	@Override
	public String toString() {
		return "[" + id + " - " + nome +"]";
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}
