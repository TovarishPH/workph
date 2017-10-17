package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.caelum.jdbc.conexao.ConnectionPool;
import br.com.caelum.jdbc.modelo.Produto;

public class TesteComProduto {

	public static void main(String[] args) throws SQLException {

		Produto mesa = new Produto("mesa", "mesa de jantar");

		ConnectionPool cp = new ConnectionPool();

		try (Connection con = cp.getConnection()) {
			con.setAutoCommit(false);
			String sql = "insert into Produto(nome, descricao) values (?, ?)";
			try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				adiciona(mesa, ps);
				con.commit();
				System.out.println("O prodtudo inserido com sucesso: " + mesa);
			} catch (Exception e) {
				e.printStackTrace();
				con.rollback();
				System.out.println("Deu ruim, malandro!");
			}
		}
	}

	private static void adiciona(Produto produto, PreparedStatement ps)
			throws SQLException {
		ps.setString(1, produto.getNome());
		ps.setString(2, produto.getDescricao());
		boolean resultado = ps.execute();
		System.out.println(resultado);

		ResultSet rs = ps.getGeneratedKeys();

		while (rs.next()) {
			int id = rs.getInt(1);
			produto.setId(id);
			System.out.println("ID " + id + " inserido.");
		}
	}
}
