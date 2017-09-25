package br.com.ph.collections.bean;

public class Aluno {

	private String nome;
	private int numeroMatricula;
	
	public Aluno(String nome, int numeroMatricula) {
		if(nome == null){
			throw new NullPointerException("Atributo 'nome' não pode ser nulo");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}
	
	@Override
	public String toString() {
		return "[Aluno: " + nome + " Matrícula: " + numeroMatricula + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Aluno outroAluno = (Aluno) obj;
		return this.nome.equals(outroAluno.nome);
	}
}
