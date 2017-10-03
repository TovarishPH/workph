package com.br.ph.algoritmosi.teste;

import com.br.ph.algoritmosi.bean.Produto;

public class OrdenacaoTeste {

	public static void main(String[] args) {

		//Refazendo primeiro exercício Ordenação
		Produto[] produtos = new Produto[5];
		produtos[0] = new Produto("Lamborghini", 1000000);
		produtos[1] = new Produto("Jipe", 46000);
		produtos[2] = new Produto("Brasilia", 16000);
		produtos[3] = new Produto("Smart", 46000);
		produtos[4] = new Produto("Fusca", 17000);

		for(int atual = 0; atual < produtos.length; atual++){
			
			int maisBarato = atual;
			for (int i = atual; i < produtos.length; i++) {
				if (produtos[i].getPreco() < produtos[maisBarato].getPreco()) {
					maisBarato = i;
				}
			}
			Produto produtoAtual = produtos[atual];
			Produto menorPreco = produtos[maisBarato];
			produtos[atual] = menorPreco;
			produtos[maisBarato] = produtoAtual;
		}
		
		for (Produto produto : produtos) {
			System.out.println(produto.getNome() + " " + produto.getPreco());
		}

	}
}
