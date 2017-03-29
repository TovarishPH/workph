package br.com.empresa.conta;

public class GerenciadorDeImpostoDeRenda {

	private double total;
	
	public void adiciona(Tributavel t) {
		System.out.println("Adicionatributavel: " + t);
		this.total = t.calculaTributos();
	}
	
	public double getTotal() {
		return this.total;
	}
}
