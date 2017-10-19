package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.conexao.CategoriaDAO2;
import br.com.caelum.jdbc.conexao.ConnectionPool;
import br.com.caelum.jdbc.conexao.ProdutoDAO2;
import br.com.caelum.jdbc.modelo.Categoria;
import br.com.caelum.jdbc.modelo.Produto;

public class TestaCategorias2 {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con = new ConnectionPool().getConnection()) {
//			List<Categoria> categorias = new CategoriaDAO2(con).lista();
//			
//			for (Categoria categoria : categorias) {
//				System.out.println(categoria);
//				List<Produto> produtos = new ProdutoDAO2(con).buscaProdutosPorCategoria(categoria.getId());
//				for (Produto produto : produtos) {
//					System.out.println(produto);
//				}
//				
//			}
			
			List<Categoria> categorias = new CategoriaDAO2(con).listaComProdutos();
			
			for (Categoria categoria : categorias) {
				System.out.println(categoria.getNome());
				for (Produto produto : categoria.getProdutos()) {
					System.out.println(produto);
				}
			}
		}
	}
}
