package br.com.ph.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.ph.livraria.dao.UsuarioDAO;
import br.com.ph.livraria.model.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean {
	
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public String efetuaLogin(){
		System.out.println("Fazendo login do usuario " + this.usuario.getEmail());
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		boolean existe = new UsuarioDAO().existe(this.usuario);
		
		if(existe){
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "livro?faces-redirect=true";
		}
		
		return null;
	}

}
