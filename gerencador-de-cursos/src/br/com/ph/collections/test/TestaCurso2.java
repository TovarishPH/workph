package br.com.ph.collections.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.ph.collections.bean.Aluno;
import br.com.ph.collections.bean.Aula;
import br.com.ph.collections.bean.Curso;
import br.com.ph.collections.utils.NovoComparadorDeAulas;

public class TestaCurso2 {

	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as colecoes do Java",
                "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com colecoes", 24));
        
        List<Aula> aulasImutaveis = javaColecoes.getAulas();
        System.out.println(aulasImutaveis);
        
        List<Aula> aulas = new ArrayList<Aula>(aulasImutaveis);
        
        Collections.sort(aulas);
        System.out.println(aulas);
        
        Comparator<Aula> comparadorDeAulas = new NovoComparadorDeAulas();
        Collections.sort(aulas, comparadorDeAulas);
        System.out.println(aulas);
        
        System.out.println("Tempo total do curso: " + javaColecoes.getTempoTotal() + " minutos.");
        
        System.out.println(javaColecoes);
        
	}
}
