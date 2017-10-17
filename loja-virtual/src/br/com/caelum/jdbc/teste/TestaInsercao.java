package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.caelum.jdbc.conexao.ConnectionPool;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionPool connectionPool = new ConnectionPool();
		
		try(Connection con = connectionPool.getConnection()){
			con.setAutoCommit(false);
			String sql = "insert into Produto (nome, descricao) values (?, ?)";
			
			try(PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				adiciona("mochila", "mochila de alpinismo", pstmt);
				adiciona("blueray", "full hdmi", pstmt);
				con.commit();
				System.out.println("Commit de dados efetuado");
				
			}catch(Exception e){
				e.printStackTrace();
				con.rollback();
				System.out.println("Rollback efetuado!");
			}
		}
		
	}

	private static void adiciona(String nome, String descricao,
			PreparedStatement pstmt) throws SQLException {
//		if(nome.equals("blueray")){
//			throw new IllegalArgumentException("Deu ruim");
//		}
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
