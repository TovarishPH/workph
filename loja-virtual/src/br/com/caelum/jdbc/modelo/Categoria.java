package br.com.caelum.jdbc.modelo;

public class Categoria {

	private final Integer id;
	private final String nome;
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "[" + id + " - " + nome +"]";
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
