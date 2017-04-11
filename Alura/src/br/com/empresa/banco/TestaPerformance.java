package br.com.empresa.banco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {

		System.out.println("Iniciando..................");
		
		Collection<Integer> teste = new HashSet<Integer>();
//		Collection<Integer> teste = new ArrayList<Integer>();
		
		long inicio = System.currentTimeMillis();
		
		int total = 30000;
		
		System.out.println("1° for");
		for(int i = 0; i < total; i++){
			teste.add(i);
		}
		long fimForHum = System.currentTimeMillis();
		long totalFimForHum = fimForHum - inicio;
		System.out.println("Tempo de inserção: " + totalFimForHum);
		
		System.out.println("2° for");
		long inicioBusca = System.currentTimeMillis();
		for(int i = 0; i < total; i++){
			teste.contains(i);
		}
		long fimFroDois = System.currentTimeMillis();
		long totalFimForDois = fimFroDois - inicioBusca;
		System.out.println("Tempo de busca: " + totalFimForDois);
		
		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo total gasto: " + tempo);
	}

}
