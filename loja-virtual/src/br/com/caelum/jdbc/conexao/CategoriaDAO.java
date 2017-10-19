package br.com.caelum.jdbc.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Categoria;
import br.com.caelum.jdbc.modelo.Produto;

public class CategoriaDAO {

	Connection con;
	
	public CategoriaDAO(Connection con) {
		this.con = con;
	}

	public List<Categoria> lista() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		String sql = "select * from Categoria";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			boolean resultado = ps.execute();
			
			ResultSet rs = ps.getResultSet();
			
			while(rs.next()){
				Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
				categorias.add(categoria);
			}
		}
		
		return categorias;
	}

	public List<Categoria> listaComPordutos() throws SQLException {
		List<Categoria> categoriaComProdutos = new ArrayList<Categoria>();
		Categoria categoriaAtual = null;
		String sql = "select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome, p.descricao as p_descricao from Categoria as c join Produto as p on p.categoria_id = c.id";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.execute();
			
			try(ResultSet rs = ps.getResultSet()){
				
				while(rs.next()){
					int catId = rs.getInt(1);
					String catNome = rs.getString(2);
					if(categoriaAtual == null || !categoriaAtual.getNome().equals(catNome)){
						Categoria categoria = new Categoria(catId, catNome);
						categoriaComProdutos.add(categoria);
						categoriaAtual = categoria;
					}
					 int prodId = rs.getInt(3);
					 String prodNome = rs.getString(4);
					 String prodDescricao = rs.getString(5);
					 Produto p = new Produto(prodNome, prodDescricao);
					 p.setId(prodId);
					 categoriaAtual.adicionaProduto(p);
				}
			}
		}
		
		return categoriaComProdutos;
	}
}
