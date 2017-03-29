package br.com.empresa.banco;

import br.com.empresa.conta.ContaCorrente;
import br.com.empresa.conta.GerenciadorDeImpostoDeRenda;
import br.com.empresa.conta.SeguroDeVida;

public class TestaGerenciadoDeImpostoDeRenda {

	public static void main(String[] args) {
		GerenciadorDeImpostoDeRenda ger = new GerenciadorDeImpostoDeRenda();
		SeguroDeVida sv = new SeguroDeVida();
		
		ger.adiciona(sv);
		
		ContaCorrente cc = new ContaCorrente();
		cc.deposita(1000);
		ger.adiciona(cc);
		
		System.out.println(ger.getTotal());
	}
}
