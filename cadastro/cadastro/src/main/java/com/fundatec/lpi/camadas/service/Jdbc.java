package com.fundatec.lpi.camadas.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Jdbc {
	public static void main(String[] args) {
		try {
			// Carrega driver do MySQL (cada banco tem o seu driver)
			String mysqlDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(mysqlDriver);

			// Cria uma conexão com o banco de dados, passando o nome
			// do banco, usuário e senha
			String connString = "jdbc:mysql://localhost/cadastro?user=root&password=";
			Connection conn = DriverManager.getConnection(connString);

			// Statements permitem executar queries (SQL) no banco
			Statement statement = conn.createStatement();

			// Nossa query
			String query = "SELECT * FROM aluno";

			// Roda a query e pega o retorno
			ResultSet resultSet = statement.executeQuery(query);

			// Itera no resultado, imprimindo os valores
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				int idade = resultSet.getInt("idade");

				// Imprime os resultados
				System.out.format("%s - %s - %s\n", id, nome, idade);
			}

			// Notem que o nome precisa ter as aspas duplas, tal qual seria
			// como no SQL
			//String query = "INSERT INTO aluno (nome, idade) values (\"" + aluno.getNome() + "\", " + aluno.getIdade() + ")";
			statement.execute(query);
			
			// Exemplo de INSERT usando prepared statements
			query = "INSERT INTO aluno (nome, idade) values (?)";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, "Lucas");
			preparedStmt.setInt(1, 26);
			preparedStmt.execute();

			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}