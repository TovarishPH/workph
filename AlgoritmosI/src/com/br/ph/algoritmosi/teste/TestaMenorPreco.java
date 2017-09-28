package com.br.ph.algoritmosi.teste;

import com.br.ph.algoritmosi.bean.Produto;

public class TestaMenorPreco {

	public static void main(String[] args) {
		
		Produto[] produtos = new Produto[5];
		produtos[0] = new Produto("Lamborghini", 1000000);
		produtos[1] = new Produto("Jipe", 46000);
		produtos[2] = new Produto("Brasilia", 16000);
		produtos[3] = new Produto("Smart", 46000);
		produtos[4] = new Produto("Fusca", 17000);
		
		int maisBarato = 0;
		int maisCaro = 0;
		
		for (int i = 0; i < produtos.length; i++){
			maisBarato = ProdutoMaisBarato(produtos, maisBarato, i);
			maisCaro = ProdutoMaisCaro(produtos, maisCaro, i);
		}
		
		System.out.println("Carro mais barato: " + produtos[maisBarato].getNome() + ", valor: " + produtos[maisBarato].getPreco() + ".");
		System.out.println("Carro mais caro: " + produtos[maisCaro].getNome() + ", valor: " + produtos[maisCaro].getPreco() + ".");
	}

	private static int ProdutoMaisCaro(Produto[] produtos, int maisCaro, int i) {
		if(produtos[i].getPreco() > produtos[maisCaro].getPreco()){
			maisCaro = i;
		}
		return maisCaro;
	}

	private static int ProdutoMaisBarato(Produto[] produtos, int maisBarato, int i) {
		if(produtos[i].getPreco() < produtos[maisBarato].getPreco()){
			maisBarato = i;
		}
		return maisBarato;
	}
}
