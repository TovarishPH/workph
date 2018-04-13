package br.com.ph.financas.teste;

import javax.persistence.EntityManager;

import br.com.ph.financas.modelo.Conta;
import br.com.ph.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta c = em.find(Conta.class, 1);
		
		c.setTitular("Juka Tarro");
		c.setNumero("1234");
		
		System.out.println(c.toString());

		em.getTransaction().commit();
		
		em.close();
		
	}
}
