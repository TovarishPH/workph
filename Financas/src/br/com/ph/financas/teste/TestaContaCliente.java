package br.com.ph.financas.teste;

import javax.persistence.EntityManager;

import br.com.ph.financas.modelo.Cliente;
import br.com.ph.financas.modelo.Conta;
import br.com.ph.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {
		
		Cliente cli = new Cliente();
		cli.setNome("Apendicilino Freitas");
		cli.setProfissao("Farmacêutico");
		cli.setEndereco("Rua Rua, 123");
		
		Cliente cli2 = new Cliente();
        cli2.setNome("Douglas");
        cli2.setEndereco("Rua Fulano, 234");
        cli2.setProfissao("Professor");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Conta conta2 = new Conta();
		conta2.setId(3);
		
		cli.setConta(conta);
		cli2.setConta(conta2);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(cli2);
		em.getTransaction().commit();
		em.close();
	}
}
