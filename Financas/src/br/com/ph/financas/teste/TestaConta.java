package br.com.ph.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import br.com.ph.financas.modelo.Conta;
import br.com.ph.financas.util.JPAUtil;

public class TestaConta {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		//Teste de Managed(persist)
//		conta.setTitular("Juares Ramón");
//		conta.setBanco("Bradesco");
//        conta.setAgencia("123");
//        conta.setNumero("456");
//        
//        EntityManager em = new JPAUtil().getEntityManager();
//        
//        em.getTransaction().begin();
//        em.persist(conta);
//        conta.setBanco("Itaú");
//        em.getTransaction().commit();
//        
//        em.close();
        
        //Teste de Removed
        EntityManager em = new JPAUtil().getEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        conta = em.find(Conta.class, 9);
        em.remove(conta);
        et.commit();
        
        em.close();
        
        
        //Teste de Detached
//        EntityManager em2 = new JPAUtil().getEntityManager();
//        
//        em2.getTransaction().begin();
//        c.setTitular("Leonaldo");
//        em2.persist(c);
//        em2.getTransaction().commit();
//        em2.close();
	}
}