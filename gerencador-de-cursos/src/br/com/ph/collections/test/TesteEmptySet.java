package br.com.ph.collections.test;

import java.util.Collections;
import java.util.Set;

public class TesteEmptySet {

	public static void main(String[] args) {
		
		Set<String> nomes = Collections.emptySet();
		nomes.add("Juarez");
		
		nomes.forEach(nome ->{
			System.out.println(nome);
		});
	}
}
