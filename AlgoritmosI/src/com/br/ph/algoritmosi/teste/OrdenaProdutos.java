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
		
		
		
		//selectionSortMethod(produtos, produtos.length);
		insertionSortMethod(produtos, produtos.length);
		
		//System.out.println("************ Resultado da Ordenação ************");
		//imprimeProdutos(produtos);
		
	}
	
	// Insertion Sort
	private static void insertionSortMethod(Produto[] produtos, int quantidadeDeElementos){
		for (int atual = 1; atual < quantidadeDeElementos; atual++) {
			System.out.println("\nEstou na posição " + atual);
			int analise = atual;
			while(analise > 0 && (produtos[analise].getPreco() < produtos[analise -1].getPreco())){
				System.out.println("Analisando a posição " + analise + " com " + (analise - 1));
				trocaPosicao(produtos, analise, analise - 1);
				//para o contador do while retroceder(em direção à esquerda do array)
				analise--;
			}
			imprimeProdutos(produtos);
		}
	}

	// Selection Sort
	private static void selectionSortMethod(Produto[] produtos, int quantidadeDeElementos) {
		for(int atual = 0; atual < quantidadeDeElementos - 1; atual++){
			System.out.println("Posição " + atual);
			int maisBarato = buscaProdutoMaisBarato(produtos, atual, quantidadeDeElementos);
			System.out.println("Trocando " + atual + " com " + maisBarato);
			trocaPosicao(produtos, atual, maisBarato);
//			Produto produtoAtual = produtos[atual];
//			Produto produtoMaisBarato = produtos[maisBarato];
//			System.out.println("Trocando " + produtoAtual.getNome() + " com " + produtoMaisBarato.getNome());
//			produtos[atual] = produtoMaisBarato;
//			produtos[maisBarato] = produtoAtual;
		}
	}

	private static void trocaPosicao(Produto[] produtos, int index1, int index2) {
		Produto produtoAnalise = produtos[index1];
		Produto produtoAnterior = produtos[index2];
		System.out.println("Trocando " + produtoAnalise.getNome() + " com " + produtoAnterior.getNome());
		produtos[index1] = produtoAnterior;
		produtos[index2] = produtoAnalise;
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
	
	private static void imprimeProdutos(Produto[] produtos) {
		System.out.println("************ Resultado da Ordenação ************");
		for (int i = 0; i < produtos.length; i++) {
			System.out.println(produtos[i].getNome() + ", R$" + produtos[i].getPreco());
		}
	}
}// final da classe
