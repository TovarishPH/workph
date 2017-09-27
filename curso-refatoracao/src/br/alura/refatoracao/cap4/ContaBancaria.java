package br.alura.refatoracao.cap4;

public abstract class ContaBancaria {
	
	protected String titurlar;
	protected double saldo; 
	
	public ContaBancaria(String titular, double saldo) {
		this.titurlar = titular;
		this.saldo = saldo;
	}

	public void saca(double valor){
		this.saldo -= valor;
	}
	
	public void deposita(double valor){
		this.saldo += valor;
	}
	
	public String getTiturlar() {
		return titurlar;
	}

	public double getSaldo() {
		return saldo;
	}
	
}
