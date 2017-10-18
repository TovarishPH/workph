package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.conexao.ProdutosDAO;
import br.com.caelum.jdbc.conexao.ConnectionPool;
import br.com.caelum.jdbc.modelo.Produto;

public class TesteComProduto {

	public static void main(String[] args) throws SQLException {

		Produto mesa = new Produto("mesa azul", "mesa de jantar");

		try (Connection con = new ConnectionPool().getConnection()) {
			ProdutosDAO produtosDAO = new ProdutosDAO(con);
			con.setAutoCommit(false);
			produtosDAO.salva(mesa);
			
			List<Produto> produtos = produtosDAO.lista();
			for (Produto produto : produtos) {
				System.out.println("Existe o produto: " + produto);
			}
		}
	}
}
