package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		/*
		 * ConnectionFactory factory = new ConnectionFactory(); try (Connection
		 * connection = factory.recuperarConexao()) {
		 * 
		 * PreparedStatement stm =
		 * connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO"); //
		 * Essa lista vai me retornar um booleano, no caso da consulta. // Caso fosse
		 * del ou upd retornaria um boolean false. stm.execute();
		 * 
		 * ResultSet rst = stm.getResultSet();
		 * 
		 * // Esse método Next vai percorrer um a um na lista que retornou, quando
		 * chegar // no ultimo vai sair do laço while (rst.next()) { Integer id =
		 * rst.getInt("id"); System.out.println(id); String nome =
		 * rst.getString("nome"); System.out.println(nome); String descricao =
		 * rst.getString("descricao"); System.out.println(descricao);
		 */

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		ResultSet rst = stm.getResultSet();
		while (rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}
		rst.close();
		stm.close();
		connection.close();
	}
}
