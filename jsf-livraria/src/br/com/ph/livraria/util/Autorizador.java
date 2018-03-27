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
		
		//Se a tentaiva de acesso for na pagina de login, tudo ocorre normal
		//em qualquer outra pagina, não havera acesso
		if("/login.xhtml".equals(nomeDaPagina)){
			return;
		}
		
		// verifica usuario na sessao e atribui uma variavel
		Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if(usuarioLogado != null){
			return;
		}
		
		//Estabelece navegacao caso o processo de login nao aconteca corretamente
		NavigationHandler nav = context.getApplication().getNavigationHandler();
		//volta para a pagina de login
		nav.handleNavigation(context, null, "/login?faces-redirect=true");
		//renderiza resposta de navegacao
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
