package com.br.ph.algoritmosi.teste;

import com.br.ph.algoritmosi.bean.Produto;

public class OrdenacaoTeste {

	public static void main(String[] args) {

		//Refazendo exercícios de Ordenação
		Produto[] produtos = new Produto[5];
		produtos[0] = new Produto("Lamborghini", 1000000);
		produtos[1] = new Produto("Jipe", 46000);
		produtos[2] = new Produto("Brasilia", 16000);
		produtos[3] = new Produto("Smart", 46000);
		produtos[4] = new Produto("Fusca", 17000);

		// Selection Sort
//		for(int atual = 0; atual < produtos.length; atual++){
//			
//			int maisBarato = atual;
//			for (int i = atual; i < produtos.length; i++) {
//				if (produtos[i].getPreco() < produtos[maisBarato].getPreco()) {
//					maisBarato = i;
//				}
//			}
//			Produto produtoAtual = produtos[atual];
//			Produto menorPreco = produtos[maisBarato];
//			produtos[atual] = menorPreco;
//			produtos[maisBarato] = produtoAtual;
//		}
		
		//Insertion Sort
		for(int atual = 1; atual < produtos.length; atual++){
			
			while(atual > 0 && (produtos[atual].getPreco() < produtos[atual - 1].getPreco())){
				Produto prodAtual = produtos[atual];
				Produto prodAnterior = produtos[atual - 1];
				produtos[atual] = prodAnterior;
				produtos[atual -1] = prodAtual;
				// joga o atual do while uma posição acima/esquerda para dar continuidade 
				atual--;
			}
		}
		
		printaResultados(produtos);

	}

	private static void printaResultados(Produto[] produtos) {
		System.out.println("********** Resultado da Ordenação **********");
		for (Produto produto : produtos) {
			System.out.println(produto.getNome() + " " + produto.getPreco());
		}
	}
}
