package br.com.ph.collections.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExercicioMap {

	public static void main(String[] args) {
		 Map<Integer, String> pessoas = new HashMap<>();

	        pessoas.put(21, "Leonardo Cordeiro");
	        pessoas.put(27, "Fabio Pimentel");
	        pessoas.put(19, "Silvio Mattos");
	        pessoas.put(23, "Romulo Henrique");
	        
	        System.out.println("Iterando sobre chaves com keyset()");
	        Set<Integer> chaves = pessoas.keySet();
	        
	        for (Integer idade : chaves) {
				System.out.println(idade);
			}
	        
//	        System.out.println("***** No java 8 *****");
//	        pessoas.keySet().forEach(idade ->{
//	        	System.out.println(pessoas.get(idade));
//	        });
	        
	        System.out.println("\nIterando sobre valores com value()");
	        Collection<String> valores = pessoas.values();
	        
	        for (String pessoa : valores) {
				System.out.println(pessoa);
			}
	        
	        System.out.println("\nIterando sobre map com entry()");
	        Set<Entry<Integer, String>> associacoes = pessoas.entrySet();
	        for (Entry<Integer, String> pessoa : associacoes) {
				System.out.println(pessoa.getKey() + " - " + pessoa.getValue());
			}
	}
}
