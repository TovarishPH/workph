package br.com.ph.livraria.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class LivroBean {
	
	private Livro livro = new Livro();

	public Livro getLivro(){
		return this.livro;
	}
	
	@PostConstruct
	public void criacao(){
		System.out.println("Objeto LivroBean foi criado!");
	}
	
	public void gravar(){
		System.out.println("Gravando livro " + "'" + this.livro.getTitulo() + "'");
	}
}
