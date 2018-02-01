package br.com.ph.livraria.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ph.livraria.dao.DAO;
import br.com.ph.livraria.model.Autor;
import br.com.ph.livraria.model.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {
	
	private Livro livro = new Livro();
	private Integer autorId;

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
	
	public void gravaAutor(){
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		System.out.println(">>>>>" + autor.getNome());
		this.livro.adicionaAutor(autor);
	}
	
	public List<Autor> getAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
}
