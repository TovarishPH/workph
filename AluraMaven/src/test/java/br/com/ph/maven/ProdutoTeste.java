package br.com.ph.maven;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoTeste {

	@Test
	public void verificaPrecoComImposto(){
		Produto p = new Produto("bala jukinha", 0.10);
		Assert.assertEquals(0.11, p.getPrecoComImposto(), 0.00001);
	}
}
