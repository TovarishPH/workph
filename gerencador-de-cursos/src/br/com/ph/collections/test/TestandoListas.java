package br.com.ph.collections.test;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

	public static void main(String[] args) {
		String aula1 = "Modelando a classe Aula";
        String aula2 = "Conhecendo mais de listas";
        String aula3 = "Trabalhando com Cursos e Sets";

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);        

//        System.out.println(aulas);
        
        // Enhanced for
//        for(int i = 0; i < aulas.size(); i++){
//        	System.out.println(aulas.get(i));
//        }
        
//        Collections.sort(aulas);
        
        // Java 8 lambda
        aulas.forEach(aula -> {
        	System.out.println("Percorrendo:");
        	System.out.println("Aula " + aula);
        });
	}

}
