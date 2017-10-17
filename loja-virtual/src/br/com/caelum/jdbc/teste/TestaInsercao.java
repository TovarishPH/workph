package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.caelum.jdbc.conexao.DataBase;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
//		Connection con = DataBase.getConnection();
//		Statement stmt = con.createStatement();
//		boolean resultado = stmt.execute("insert into Produto (nome, descricao) values ('notebook', 'notebook i5')", stmt.RETURN_GENERATED_KEYS);
//		System.out.println(resultado);
		
		Connection con = DataBase.getConnection();
		String sql = "insert into Produto (nome, descricao) values (?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		adiciona("mochila", "mochila de alpinismo", pstmt);
		adiciona("televisor", "tv led 42''", pstmt);
		
		pstmt.close();
		con.close();
	}

	private static void adiciona(String nome, String descricao,
			PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, nome);
		pstmt.setString(2, descricao);
		boolean resultado = pstmt.execute();
		
		System.out.println(resultado);
		
		ResultSet rs = pstmt.getGeneratedKeys();
		
		while (rs.next()) {
			String id = rs.getString(1);
			System.out.println("ID: " + id + " gerado");
		}
		rs.close();
	}
}
