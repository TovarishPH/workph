package br.com.ph.collections.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {
		
		// Testando performance entre as Collections List e Set
		
		//Collection<Integer> numeros = new ArrayList<Integer>();
		Collection<Integer> numeros = new HashSet<Integer>();
		
		long ini = System.currentTimeMillis();
		
		// Inicio da inserção
		for (int i = 0; i < 15000; i++) {
			numeros.add(i);
		}
		long fimInsercao = System.currentTimeMillis();
		System.out.println("tempo de inserção: " + (fimInsercao - ini));
		
		// inicio da Busca(contains)
		long inicioDeBusca = System.currentTimeMillis();
		for (Integer numero : numeros) {
			numeros.contains(numero);
		}
		long fimDeBusca = System.currentTimeMillis();
		System.out.println("Tempo de comparação(contains):" + (fimDeBusca - inicioDeBusca));
		
		long fim = System.currentTimeMillis();
		long tempoDeExecucao = fim - ini;
		
		System.out.println("Tempo gasto na execução: " + tempoDeExecucao);
	}
}
