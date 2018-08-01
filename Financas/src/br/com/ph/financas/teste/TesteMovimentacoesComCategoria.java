package br.com.ph.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.ph.financas.modelo.Categoria;
import br.com.ph.financas.modelo.Conta;
import br.com.ph.financas.modelo.Movimentacao;
import br.com.ph.financas.util.JPAUtil;
import br.com.ph.financas.util.TipoMovimentacao;

public class TesteMovimentacoesComCategoria {

	public static void main (String[] args){
		
		Categoria c1 = new Categoria("viagem");
		Categoria c2 = new Categoria("negócios");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao m1 = new Movimentacao();
		m1.setData(Calendar.getInstance());
		m1.setDescricao("Viagem à SP");
		m1.setTipo(TipoMovimentacao.SAIDA);
		m1.setValor(new BigDecimal("100.0"));
		m1.setCategorias(Arrays.asList(c1,c2));
		
		m1.setConta(conta);
		
		Movimentacao m2 = new Movimentacao();
        m2.setData(Calendar.getInstance());
        m2.setDescricao("Viagem ao RJ");
        m2.setTipo(TipoMovimentacao.SAIDA);
        m2.setValor(new BigDecimal("300.0"));
        m2.setCategorias(Arrays.asList(c1, c2));
        
        m2.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.persist(c1);
        em.persist(c2);
        em.persist(m1);
        em.persist(m2);
        em.getTransaction().commit();
        em.close();
	}
}
