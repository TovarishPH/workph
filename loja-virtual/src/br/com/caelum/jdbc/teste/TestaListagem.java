package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//DriverManager.registerDriver(new jdbcDriver());
		//Class.forName("org.hsqldb.jdbcDriver");
		//Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
		//Class.forName("org.gjt.mm.mysql.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root", "root");
		
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
