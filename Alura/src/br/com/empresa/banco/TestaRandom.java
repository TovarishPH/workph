package br.com.empresa.banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import br.com.empresa.conta.Conta;
import br.com.empresa.conta.ContaCorrente;
import br.com.empresa.conta.ContaPoupanca;
import br.com.empresa.sistema.ComparadorNomeContaPoupanca;

public class TestaRandom {

	public static void main(String[] args) {

		List<Conta> contas = new ArrayList<Conta>();
//		List<Conta> contas = new LinkedList<Conta>();
		
		Random saldo = new Random();
		
//		ComparadorNomeContaPoupanca cp = new ComparadorNomeContaPoupanca();
		
		Conta c1 = new ContaPoupanca();
		c1.setNome("Juarez");
		c1.setSaldo(saldo.nextInt(200));
		Conta c2 = new ContaPoupanca();
		c2.setNome("Astolfinho");
		c2.setSaldo(saldo.nextInt(200));
		Conta c3 = new ContaPoupanca();
		c3.setNome("Pafúncio");
		c3.setSaldo(saldo.nextInt(200));
		
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);
		
//		Collections.sort(contas, cp);
		Collections.sort(contas);
		
		for (Conta conta : contas) {
			System.out.println(conta.getNumero() + "/" + conta.getNome() + "/" + conta.getSaldo());
		}
	}

}
