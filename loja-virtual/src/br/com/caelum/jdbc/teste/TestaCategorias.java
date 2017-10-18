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
			ProdutosDAO pdao = new ProdutosDAO(con);
			
			List<Categoria> categorias = dao.lista();
			
			for (Categoria categoria : categorias) {
				System.out.println("Categoria " + categoria);
				for (Produto produto : pdao.listaPorCategoria(categoria.getId())){
					System.out.println(produto);
				}//for produto
			}//fro categoria
		}
	}
}
