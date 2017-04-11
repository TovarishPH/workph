package br.com.empresa.sistema;

import java.util.Comparator;

import br.com.empresa.conta.Conta;


public class ComparadorNomeContaPoupanca implements Comparator<Conta> {

	@Override
	public int compare(Conta conta, Conta outraConta) {
		return conta.getNome().compareTo(outraConta.getNome());
	}

}
