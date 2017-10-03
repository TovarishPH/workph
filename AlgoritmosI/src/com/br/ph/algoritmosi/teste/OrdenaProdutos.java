package com.br.ph.algoritmosi.teste;

import com.br.ph.algoritmosi.bean.Produto;

public class OrdenaProdutos {

	public static void main(String[] args) {
		
		Produto[] produtos = new Produto[5];
		produtos[0] = new Produto("Lamborghini", 1000000);
		produtos[1] = new Produto("Jipe", 46000);
		produtos[2] = new Produto("Brasilia", 16000);
		produtos[3] = new Produto("Smart", 46000);
		produtos[4] = new Produto("Fusca", 17000);
		
		
		
		ordenaProdutos(produtos, produtos.length);
		
		System.out.println("************ ************* ************* *************");
		
		for (int i = 0; i < produtos.length; i++) {
			System.out.println(produtos[i].getNome() + ", R$" + produtos[i].getPreco());
		}
		
	}

	private static void ordenaProdutos(Produto[] produtos, int quantidadeDeElementos) {
		for(int atual = 0; atual < quantidadeDeElementos - 1; atual++){
			System.out.println("Posição " + atual);
			int maisBarato = buscaProdutoMaisBarato(produtos, atual, quantidadeDeElementos);
			System.out.println("Trocando " + atual + " com " + maisBarato);
			Produto produtoAtual = produtos[atual];
			Produto produtoMaisBarato = produtos[maisBarato];
			System.out.println("Trocando " + produtoAtual.getNome() + " com " + produtoMaisBarato.getNome());
			produtos[atual] = produtoMaisBarato;
			produtos[maisBarato] = produtoAtual;
		}
	}

	private static int buscaProdutoMaisBarato(Produto[] produtos, int inicio, int fim) {
		int maisBarato = inicio;
		for (int atual = inicio; atual < fim; atual ++){
			if(produtos[atual].getPreco() < produtos[maisBarato].getPreco()){
				maisBarato = atual;
			}
		}
		return maisBarato;
	}
}
