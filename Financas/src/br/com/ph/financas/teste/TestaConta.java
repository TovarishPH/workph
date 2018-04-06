package br.com.ph.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ph.financas.modelo.Conta;

public class TestaConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setTitular("Juka Tarro");
		conta.setBanco("Caixa Economica");
        conta.setAgencia("123");
        conta.setNumero("456");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
	}
}
