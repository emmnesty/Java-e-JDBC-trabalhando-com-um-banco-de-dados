import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		Statement stm = connection.createStatement();
		// Essa lista vai me retornar um booleano, no caso da consulta.
		// Caso fosse del ou upd retornaria um boolean false.
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

		ResultSet rst = stm.getResultSet();

		// Esse método Next vai percorrer um a um na lista que retornou, quando chegar
		// no ultimo vai sair do laço
		while (rst.next()) {
			Integer id = rst.getInt("id");
			System.out.println(id);
			String nome = rst.getString("nome");
			System.out.println(nome);
			String descricao = rst.getString("descricao");
			System.out.println(descricao);
		}

		connection.close();

	}

}
