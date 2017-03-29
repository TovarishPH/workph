package br.com.empresa.conta;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca> {

	public void deposita(double valor){
		this.saldo += valor - 0.10;
	}

	@Override
	public void atualiza(double taxaSelic) {
		this.saldo += this.saldo * taxaSelic * 3;
	}

	@Override
	public int compareTo(ContaPoupanca outraConta) {
		if(this.saldo > outraConta.saldo) return -1;
		if(this.saldo < outraConta.saldo) return +1;
		return 0;
	}
}
