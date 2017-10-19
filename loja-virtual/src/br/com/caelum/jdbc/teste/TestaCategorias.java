package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.conexao.CategoriaDAO;
import br.com.caelum.jdbc.conexao.ConnectionPool;
import br.com.caelum.jdbc.conexao.ProdutosDAO;
import br.com.caelum.jdbc.modelo.Categoria;
import br.com.caelum.jdbc.modelo.Produto;

public class TestaCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con = new ConnectionPool().getConnection()){
			CategoriaDAO dao = new CategoriaDAO(con);
			
			List<Categoria> categoriasComProduto = dao.listaComPordutos();
			
			for (Categoria categoria : categoriasComProduto) {
				System.out.println(categoria);
				for (Produto produto : categoria.getProdutos()) {
					System.out.println(produto.getNome());
				}
			}
		}
	}
}
