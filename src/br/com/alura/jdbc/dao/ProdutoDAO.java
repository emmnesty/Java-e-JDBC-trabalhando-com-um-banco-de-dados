package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;

	}

	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUE (?,?)";

		try (PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			psmt.setString(1, produto.getNome());
			psmt.setString(2, produto.getDescricao());

			psmt.execute();

			try (ResultSet rst = psmt.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();

		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		try (PreparedStatement psmt = connection.prepareStatement(sql)) {
			psmt.execute();

			try (ResultSet rst = psmt.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

					produtos.add(produto);
				}
			}
		}
		return produtos;
	}
}
