package br.com.empresa.banco;

import br.com.empresa.conta.Conta;
import br.com.empresa.conta.ContaCorrente;
import br.com.empresa.conta.ContaPoupanca;

public class TestaConta {

	public static void main(String[] args) {
		Conta cc = new ContaCorrente();
		Conta cp = new ContaPoupanca();

		cc.deposita(1000);
		cp.deposita(1000);

		cc.atualiza(0.01);
		cp.atualiza(0.01);
		
		System.out.printf("O saldo é: %.2f", cc.getSaldo());
		System.out.printf("\nO saldo é: %.2f", cp.getSaldo());

//		AtualizadorDeContas adc = new AtualizadorDeContas(0.01);
//
//		adc.roda(cc);
//		adc.roda(cp);
//
//		System.out.println("Total: " + adc.getSaldoTotal());
		
	}
}
