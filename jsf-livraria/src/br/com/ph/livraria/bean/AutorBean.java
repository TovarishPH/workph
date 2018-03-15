package br.com.ph.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ph.livraria.dao.DAO;
import br.com.ph.livraria.model.Autor;
import br.com.ph.livraria.util.RedirectView;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();
	private Integer autorId;

	public Autor getAutor() {
		return autor;
	}
	
	public List<Autor> getAutores(){
		return new DAO(Autor.class).listaTodos();
	}
	
	public void carregaAutorPeloId(){
		System.out.println("Carregando autor" + this.autorId);
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
	}
	
	public void removerAutor(Autor autor){
		System.out.println("Removendo autor " + autor.getNome());
		new DAO<Autor>(Autor.class).remove(autor);
		this.getAutores().remove(autor);
	}
	
	public void alterarAutor(Autor autor){
		System.out.println("Carregando autor " + autor.getNome());
		this.autor = autor;
	}

	public RedirectView gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if(this.autor.getId() == null){
			new DAO<Autor>(Autor.class).adiciona(this.autor);
		}else {
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		}
		
		autor = new Autor();
		
		//return "livro?faces-redirect=true";
		
		//Usando a classe utilitária RedirectView
		return new RedirectView("livro");
	}
	
	public RedirectView voltar(){
		return new RedirectView("livro");
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
}
