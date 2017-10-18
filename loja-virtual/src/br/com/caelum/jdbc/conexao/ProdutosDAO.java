package br.com.caelum.jdbc.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Produto;

public class ProdutosDAO {

	private Connection con;

	public ProdutosDAO(Connection con) {
		this.con = con;
	}

	public void salva(Produto produto) throws SQLException {
		String sql = "insert into Produto(nome, descricao) values (?, ?)";
		try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			boolean resultado = ps.execute();
			con.commit();
			System.out.println(resultado);

			ResultSet rs = ps.getGeneratedKeys();

			while (rs.next()) {
				int id = rs.getInt(1);
				produto.setId(id);
				System.out.println("ID " + id + " inserido.");
			}
		}
	}

	public List<Produto> lista() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "select * from Produto";
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			boolean resultado = ps.execute();
			System.out.println(resultado);
			
			try(ResultSet rs = ps.getResultSet()){
				
				while(rs.next()){
					Produto prod = new Produto(rs.getString(2), rs.getString(3));
					prod.setId(rs.getInt(1));
					produtos.add(prod);
					//System.out.println("Produto: [" + prod.getId() + "] " + prod.getNome() + " - " + prod.getDescricao());
				}
			}
		}
		
		return produtos;
	}

	public List<Produto> listaPorCategoria(Integer categoria) throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "select * from Produto where categoria_id = ?";
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, categoria);
			ps.execute();
			
			try(ResultSet rs = ps.getResultSet()){
				
				while(rs.next()){
					Produto prod = new Produto(rs.getString(2), rs.getString(3));
					prod.setId(rs.getInt(1));
					produtos.add(prod);
				}
			}
		}
		
		return produtos;
	}
}
