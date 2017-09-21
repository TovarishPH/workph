package br.com.ph.collections.test;

import java.util.List;

import br.com.ph.collections.bean.Aula;
import br.com.ph.collections.bean.Curso;

public class TestaCurso {

	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções Java", "Paulo Silveira");

		//		List<Aula> aulas = javaColecoes.getAulas();
//		System.out.println(aulas);
//		
//		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
//		System.out.println(aulas);
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));
        
        // tentando adicionar da maneira "antiga". Podemos fazer isso? Teste:
        javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));

        
        System.out.println(javaColecoes.getAulas());
		
	}
}
