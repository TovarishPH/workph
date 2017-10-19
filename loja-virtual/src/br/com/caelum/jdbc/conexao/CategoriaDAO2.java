package br.com.caelum.jdbc.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Categoria;
import br.com.caelum.jdbc.modelo.Produto;


public class CategoriaDAO2 {

	Connection con;
	
	public CategoriaDAO2(Connection con) {
		this.con = con;
	}

	public List<Categoria> lista() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		String sql = "select * from Categoria";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.execute();
			
			ResultSet rs = ps.getResultSet();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				Categoria cat = new Categoria(id, nome);
				categorias.add(cat);
			}
		 }
		
		return categorias;
	}
	
	public List<Categoria> listaComProdutos() throws SQLException{
		List<Categoria> categorias = new ArrayList<Categoria>();
		Categoria catAtual = null;
		String sql = "select * from Categoria as c join Produto as p on c.id = p.categoria_id";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.execute();
			
			ResultSet rs = ps.getResultSet();
			
			while(rs.next()){
				int cId = rs.getInt(1);
				String cNome = rs.getString(2);
				
				if(catAtual == null || !catAtual.getNome().equals(cNome)){
					Categoria cat = new Categoria(cId, cNome);
					categorias.add(cat);
					catAtual = cat;
				}
				
				int pId = rs.getInt(3);
				String pNome = rs.getString(4);
				String pDescricao= rs.getString(5);
				Produto p = new Produto(pNome, pDescricao);
				p.setId(pId);
				catAtual.adicionaProduto(p);
			}
		}
		return categorias;
	}
	
}
