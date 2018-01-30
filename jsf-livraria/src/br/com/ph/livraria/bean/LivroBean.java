package br.com.ph.livraria.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.ph.livraria.dao.DAO;
import br.com.ph.livraria.model.Livro;

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
		
		if(livro.getAutores().isEmpty()) {
            throw new RuntimeException("Livro deve ter pelo menos um Autor");
        }

        new DAO<Livro>(Livro.class).adiciona(this.livro);
	}
}