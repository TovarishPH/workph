package br.com.ph.livraria.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.ph.livraria.model.Usuario;

public class Autorizador implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		//Pegando os dados da página acessada
		String nomeDaPagina = context.getViewRoot().getViewId();
		
		System.out.println("::: Página: " + nomeDaPagina + " :::");
		
		if("/login.xhtml".equals(nomeDaPagina)){
			return;
		}
		
		// Trabalhando o usuario logado
		Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if(usuarioLogado != null){
			return;
		}
		
		//Estabelecendo navegação
		NavigationHandler nav = context.getApplication().getNavigationHandler();
		nav.handleNavigation(context, null, "/login?faces-redirect=true");
		
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
