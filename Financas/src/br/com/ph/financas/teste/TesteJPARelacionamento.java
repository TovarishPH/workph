package br.com.ph.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.ph.financas.modelo.Conta;
import br.com.ph.financas.modelo.Movimentacao;
import br.com.ph.financas.util.JPAUtil;
import br.com.ph.financas.util.TipoMovimentacao;

public class TesteJPARelacionamento {

	public static void main(String[] args){
		
		Conta c = new Conta();
		c.setAgencia("0102");
		c.setBanco("Itau");
		c.setNumero("1234");
		c.setTitular("Juka Tarro");
		
		Movimentacao m = new Movimentacao();
		m.setData(Calendar.getInstance());
		m.setDescricao("churrascaria");
		m.setTipo(TipoMovimentacao.ENTRADA);
		m.setValor(new BigDecimal("120.5"));
		
		m.setConta(c);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(c);
		em.persist(m);
		em.getTransaction().commit();
		em.close();
		
	}
}
