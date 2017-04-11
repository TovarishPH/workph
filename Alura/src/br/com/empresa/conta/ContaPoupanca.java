package br.com.empresa.conta;

public class ContaPoupanca extends Conta{

	public void deposita(double valor){
		this.saldo += valor - 0.10;
	}

	@Override
	public void atualiza(double taxaSelic) {
		this.saldo += this.saldo * taxaSelic * 3;
	}

	@Override
	public int compareTo(Conta o) {
		return this.getNome().compareTo(o.getNome());
	}

}
