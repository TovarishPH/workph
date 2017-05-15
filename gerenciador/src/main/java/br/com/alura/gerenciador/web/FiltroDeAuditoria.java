package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
		Cookie cookie = getLoggedUser(req);
		String usuario = "<deslogado>";
		
		
		if(cookie != null){
			usuario = cookie.getValue();
		}
		
		
		System.out.println("Usuário " + usuario + " acessando a URI " + req.getRequestURI());
		fc.doFilter(servReq, servResp);
	}

	private Cookie getLoggedUser(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		
		if(cookies == null){
			return null;
		}
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("loggedUser")){
				return cookie;
			}
		}
		return null;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
