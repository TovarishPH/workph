package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Classe de controle de cookies
 * 
 * @author pacorrea
 *
 */
public class Cookies {

	Cookie[] cookies;
	
	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}
	
	public Cookie getusuarioLogado(HttpServletRequest req){
		
		cookies = req.getCookies();
		
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
}
