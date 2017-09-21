package br.com.ph.collections.bean;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}
	
	public void adiciona(Aula aula){
		this.aulas.add(aula);
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " Tempo: " + this.getTempoTotal() + " Instrutor: " + this.instrutor + " Aulas: " + this.aulas;
	}
	
//	public int getTempoTotal(){
//		int tempoTotal = 0;
//		for (Aula aula : aulas) {
//			tempoTotal += aula.getTempo();
//		}
//		return tempoTotal;
//	}
	
	// Implementação do Java 8
	public int getTempoTotal(){
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}
}
