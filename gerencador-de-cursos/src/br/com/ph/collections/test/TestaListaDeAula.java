package br.com.ph.collections.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.com.ph.collections.bean.Aula;
import br.com.ph.collections.utils.NovoComparadorDeAulas;

public class TestaListaDeAula {

	public static void main(String[] args) {
		
		Aula a1 = new Aula("Revistando as ArrayLists", 21);
        Aula a2 = new Aula("Listas de objetos", 20);
        Aula a3 = new Aula("Relacionamento de listas e objetos", 15);

        ArrayList<Aula> aulas = new ArrayList<>();
        aulas.add(a1);
        aulas.add(a2);
        aulas.add(a3);
        
        System.out.println("Lista simples:");
        System.out.println(aulas);
        System.out.println("Lista ordenada:");
        Collections.sort(aulas);
        System.out.println(aulas);
        System.out.println("Lista ordenada, com uso de compaarator:");
        Comparator<Aula> novoComparadorDeAulas = new NovoComparadorDeAulas();
        Collections.sort(aulas, novoComparadorDeAulas);
        //Comparator Java8
        //aulas.sort(Comparator.comparing(Aula::getTempo));
        System.out.println(aulas);

	}
}
