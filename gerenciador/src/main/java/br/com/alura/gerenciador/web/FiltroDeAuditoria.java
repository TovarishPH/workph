package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servReq, ServletResponse servResp,
			FilterChain fc) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) servReq;
		
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("loggedUser");
		String usuario = "<deslogado>";
		
		
		if(usuarioLogado != null){
			usuario = usuarioLogado.getEmail();
		}
		
		
		System.out.println("Usuário " + usuario + " acessando a URI " + req.getRequestURI());
		fc.doFilter(servReq, servResp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
