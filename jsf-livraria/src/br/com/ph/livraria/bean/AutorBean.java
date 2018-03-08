package br.com.ph.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.ph.livraria.dao.DAO;
import br.com.ph.livraria.model.Autor;
import br.com.ph.livraria.util.RedirectView;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public RedirectView gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		new DAO<Autor>(Autor.class).adiciona(this.autor);
		
		autor = new Autor();
		
		//return "livro?faces-redirect=true";
		
		//Usando a classe utilitária RedirectView
		return new RedirectView("livro");
	}
	
	public RedirectView voltar(){
		return new RedirectView("livro");
	}
}
