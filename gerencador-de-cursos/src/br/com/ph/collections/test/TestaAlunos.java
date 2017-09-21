package br.com.ph.collections.test;

import java.util.HashSet;
import java.util.Set;

public class TestaAlunos {

	public static void main(String[] args) {

		Set<String> alunos = new HashSet<String>();

		alunos.add("Paulo Silveira");
		alunos.add("Rodrigo Turini");
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
//		alunos.add("Sergio Lopes");
//        alunos.add("Renan Saggio");
//        alunos.add("Mauricio Aniche");

		boolean adicionouRepetido = alunos.add("Nico Steppat"); // nome repetido
		System.out.println("Aluno repetido adicionado? " + adicionouRepetido);
		
        for (String aluno : alunos) {
			System.out.println(aluno);
		}

		System.out.println(alunos);
		System.out.println(alunos.size());
		
		boolean pauloEstaMatriculado = alunos.contains("Paulo Silveira");
		System.out.println("Contém aluno matriculado?" + pauloEstaMatriculado);
	}
}
