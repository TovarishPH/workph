package br.com.ph.livraria.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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
            FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor"));
//			throw new RuntimeException("Livro deve ter pelo menos um Autor");
            return;
        }else{
        	new DAO<Livro>(Livro.class).adiciona(this.livro);
        	this.livro = new Livro();
        }

	}
	
	public void gravaAutor(){
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		System.out.println(">>>>>" + autor.getNome());
		this.livro.adicionaAutor(autor);
	}
	
	public String formAutor(){
		System.out.println("Chamando o formulário do Autor");
		return "autor?faces-redirect=true";
	}
	
	/**
	 * Valida se o ISBN comeca com digito 1
	 */
	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException{
		String valor = value.toString();
		if(!valor.startsWith("1")){
			throw new ValidatorException(new FacesMessage("ISBN deveria começar com '1'"));
		}
	}
	
	public List<Autor> getAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
	}
	
	public List<Livro> getLivros(){
		return new DAO<Livro>(Livro.class).listaTodos();
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
}
