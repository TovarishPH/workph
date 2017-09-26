package br.com.ph.collections.test;

import br.com.ph.collections.bean.Aluno;
import br.com.ph.collections.bean.Aula;
import br.com.ph.collections.bean.Curso;

public class TestaBuscaAlunosNoCurso {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java",
                "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

        Aluno a1 = new Aluno("Rodrigo Turini", 34672);
        Aluno a2 = new Aluno("Guilherme Silveira", 5617);
        Aluno a3 = new Aluno("Mauricio Aniche", 17645);
        Aluno a4 = new Aluno("Aluno Repetido", 5617);// esse aluno será lembrado pelo map, e o outro será esquecido
        
        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);
        javaColecoes.matricula(a4);
        
        System.out.println("Quem é o aluno com a matríclua 5617?");
        Aluno aluno = javaColecoes.buscaMatriculado(5617);
        System.out.println("Aluno " + aluno);
	}
}
