package br.com.empresa.banco;

import java.util.HashSet;
import java.util.Set;

import br.com.empresa.conta.Conta;
import br.com.empresa.conta.ContaCorrente;

public class TesteDeHash {

	public static void main(String[] args) {

		Set<Conta> contas = new HashSet<Conta>();

		Conta c1 = new ContaCorrente();
		c1.setNumero(123);
		c1.setNome("José");
		Conta c2 = new ContaCorrente();
		c2.setNumero(123);
		c2.setNome("Astrogildo");
		Conta c3 = new ContaCorrente();
		c3.setNumero(345);
		c3.setNome("Pafúncia");
		
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);
		
		for (Conta conta : contas) {
			System.out.println("Conta: " + conta.getNumero() + " \nNome: " + conta.getNome() + "\n");
		}
	}
}
