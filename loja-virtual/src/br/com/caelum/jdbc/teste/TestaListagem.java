package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.caelum.jdbc.conexao.ConnectionPool;

public class TestaListagem {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		ConnectionPool connectionPool = new ConnectionPool();
		Connection con = connectionPool.getConnection();
		
		Statement stmt = con.createStatement();
		boolean resultado = stmt.execute("select * from Produto");
		ResultSet rs = stmt.getResultSet();
		
		System.out.println("Resultado da busca: " + resultado);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			System.out.println("[" + id + "]" + nome + " / " + descricao);
			
		}
		
		//Descobrindo tabela e colunas
		ResultSetMetaData rsm = rs.getMetaData();
		int columnsNum = rsm.getColumnCount();
		
		for (int i = 1; i < columnsNum; i++) {
			String columnName = rsm.getColumnName(i);
			String tableName = rsm.getTableName(i);
			System.out.println("Coluna: " + columnName + " Tabela: " + tableName);
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
}
