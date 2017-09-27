package br.alura.refatoracao.cap6;

public enum Moeda {

	DOLAR(2.7),
	EURO(4.3);
	
	private double taxa;
	
	private Moeda(double taxa) {
		this.taxa = taxa;
	}
	
	public double getTaxa() {
		return taxa;
	}
}
