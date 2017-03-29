package br.com.empresa.banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import br.com.empresa.conta.Conta;
import br.com.empresa.conta.ContaCorrente;
import br.com.empresa.conta.ContaPoupanca;

public class TestaOrdenacao {

	public static void main(String[] args) {

		ContaPoupanca c1 = new ContaPoupanca();
		ContaPoupanca c2 = new ContaPoupanca();
		ContaPoupanca c3 = new ContaPoupanca();
		ContaPoupanca c4 = new ContaPoupanca();
		
		List<ContaPoupanca> listaContas = new LinkedList<>();
		
		c1.setSaldo(1000);
		c1.setNumero(1);
		c2.setSaldo(30000);
		c2.setNumero(2);
		c3.setSaldo(345);
		c3.setNumero(3);
		c4.setSaldo(900);
		c4.setNumero(4);
		
		listaContas.add(c1);
		listaContas.add(c2);
		listaContas.add(c3);
		listaContas.add(c4);
		
		for (ContaPoupanca contaPoupanca : listaContas) {
			System.out.println(contaPoupanca.getNumero() + " Saldo: " + contaPoupanca.getSaldo());
		}

		System.out.println("************* ****************** ****************");
		
//		Collections.sort(listaContas);
//		
//		for (ContaPoupanca contaPoupanca : listaContas) {
//			System.out.println(contaPoupanca.getNumero() + " Saldo: " + contaPoupanca.getSaldo());
//		}
		
		System.out.println("************* ****************** ****************");
		
		Collections.rotate(listaContas, 2);
		
		for (ContaPoupanca contaPoupanca : listaContas) {
			System.out.println(contaPoupanca.getNumero() + " Saldo: " + contaPoupanca.getSaldo());
		}
	}

}
