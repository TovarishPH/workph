package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.conexao.ConnectionPool;
import br.com.caelum.jdbc.conexao.ProdutoDAO2;
import br.com.caelum.jdbc.modelo.Produto;

public class TesteComProduto2 {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con = new ConnectionPool().getConnection()){
			con.setAutoCommit(false);
			ProdutoDAO2 dao = new ProdutoDAO2(con);
			
			Produto produto = new Produto("smartphone", "smartphone motorola G5");
			
			//dao.salva(produto);
			
			List<Produto> produtos = dao.lista();
			for (Produto p : produtos) {
				System.out.println("Produto " + p);
			}
		}
	}
}
