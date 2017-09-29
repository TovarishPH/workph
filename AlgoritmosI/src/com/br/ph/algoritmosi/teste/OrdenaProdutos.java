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

		for (int i = 0; i < produtos.length; i++){
			int menor = buscaMenorPreco(produtos, i);
			Produto produtoAtual = produtos[i];
			Produto produtoMaisBarato = produtos[menor];
			produtos[i] = produtoMaisBarato;
			produtos[menor] = produtoAtual;
		}
		
		for (Produto produto : produtos) {
			System.out.println(produto.getNome() + " " + produto.getPreco());
		}
		
//		System.out.println("Produto mais barato: "
//				+ produtos[maisBarato].getNome() + ", valor: "
//				+ produtos[maisBarato].getPreco() + ".");
	}

	private static int buscaMenorPreco(Produto[] produtos, int inicio) {
		int maisBarato = 0;
		for (int atual = inicio; atual < produtos.length; atual++) {
			if (produtos[atual].getPreco() < produtos[maisBarato].getPreco()) {
				maisBarato = atual;
			}
			
		}
		return maisBarato;
	}

}
