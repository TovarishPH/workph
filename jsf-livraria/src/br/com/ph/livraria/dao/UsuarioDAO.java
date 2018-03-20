package br.com.ph.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.ph.livraria.model.Usuario;

public class UsuarioDAO {

	
	public boolean existe(Usuario usuario){
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> q = em.
								createQuery(
								"select u from Usuario u where u.email = :pEmail and u.senha = :pSenha",
								Usuario.class);
		q.setParameter("pEmail", usuario.getEmail());
		q.setParameter("pSenha", usuario.getSenha());
		
		try {
			Usuario resultado = q.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return false;
		}
		
		em.close();
		
		return true;
	}
}
