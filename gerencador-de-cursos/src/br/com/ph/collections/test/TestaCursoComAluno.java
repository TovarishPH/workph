package br.com.ph.collections.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.com.ph.collections.bean.Aluno;
import br.com.ph.collections.bean.Aula;
import br.com.ph.collections.bean.Curso;

public class TestaCursoComAluno {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleções do Java",
				"Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

		Aluno a1 = new Aluno("Rodrigo Turini", 34672);
		Aluno a2 = new Aluno("Guilherme Silveira", 5617);
		Aluno a3 = new Aluno("Mauricio Aniche", 17645);

		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);

		System.out.println("Todos os alunos matriculados: ");
		javaColecoes.getAlunos().forEach(aluno -> {
			System.out.println(aluno);
		});

		Aluno a4 = new Aluno("Juka Tarro", 12345);

		// add(0 não funciona por causa do unmodifiableSet (getAlunos(), classe Curso)
//		javaColecoes.getAlunos().add(a4);
//
//		System.out.println("Segundo conjunto de  alunos matriculados: ");
//		javaColecoes.getAlunos().forEach(aluno -> {
//			System.out.println(aluno);
//		});

	}
}
