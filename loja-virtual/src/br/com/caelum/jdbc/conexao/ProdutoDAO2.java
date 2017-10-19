package br.com.caelum.jdbc.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Categoria;
import br.com.caelum.jdbc.modelo.Produto;

public class ProdutoDAO2 {

	Connection con;
	
	public ProdutoDAO2(Connection con) {
		this.con = con;
	}
	
	public void salva(Produto produto) throws SQLException{
		String sql = "insert into Produto(nome, descricao) values(?, ?)";
		try(PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			boolean resultado = ps.execute();
			con.commit();
			System.out.println((resultado) ? "[T]Operação realizada com sucesso" : "[F]Operação realizada com sucesso");
			
			ResultSet rs = ps.getGeneratedKeys();
			
			while(rs.next()){
				produto.setId(rs.getInt(1));
				System.out.println("Produto " + rs.getInt(1) + " inserido.");
			}
		}
	}

	public List<Produto> lista() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "select * from Produto";
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			ps.execute();
			
			transformaResultadoEmProdutos(produtos, ps);
		}
		
		return produtos;
		
	}
	
	public List<Produto> buscaProdutosPorCategoria(int categoriaId) throws SQLException{
		List<Produto> produtos = new ArrayList<>();
		String sql = "select * from Produto where categoria_id = ?";
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, categoriaId);
			ps.execute();
			
			transformaResultadoEmProdutos(produtos, ps);
		}
		return produtos;
	}

	private void transformaResultadoEmProdutos(List<Produto> produtos,
			PreparedStatement ps) throws SQLException {
		try(ResultSet rs = ps.getResultSet()){
			while(rs.next()){
				Produto produto = new Produto(rs.getString(2), rs.getString(3));
				produto.setId(rs.getInt(1));
				produtos.add(produto);
			}
		}
	}
}
