package com.fundatec.lpi.camadas.dao;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.fundatec.lpi.camadas.domain.Aluno;

public class AlunoDAO implements BaseDAO<Aluno>{
	
	
	public void save(Aluno aluno) throws IOException {
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
			
			// Exemplo de INSERT usando prepared statements
			String query = "INSERT INTO aluno (nome, idade) values (\"" + aluno.getNome() + "\", " + aluno.getIdade() + ")";
			statement.execute(query);

			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void delete(Aluno aluno) throws IOException {
		try {
			// Carrega driver do MySQL (cada banco tem o seu driver)
			String mysqlDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(mysqlDriver);

			// Cria uma conexão com o banco de dados, passando o nome
			// do banco, usuário e senha
			String connString = "jdbc:mysql://localhost/cadastro?user=root&password=";
			Connection conn = DriverManager.getConnection(connString);
			
			// Query para deletar
			String query = "DELETE FROM aluno WHERE id = ?";
			
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, aluno.getId());
			preparedStmt.execute();

			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	public void update(Aluno aluno) throws IOException {
		try {
			// Carrega driver do MySQL (cada banco tem o seu driver)
			String mysqlDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(mysqlDriver);

			// Cria uma conexão com o banco de dados, passando o nome
			// do banco, usuário e senha
			String connString = "jdbc:mysql://localhost/cadastro?user=root&password=";
			Connection conn = DriverManager.getConnection(connString);
			
	
			// query de editar
			String query = "UPDATE aluno SET nome = ? , idade = ? where id=?";
			
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, aluno.getNome());
			preparedStmt.setInt(2, aluno.getIdade());
			preparedStmt.setInt(3, aluno.getId());
			preparedStmt.execute();

			System.out.println("aluno " + aluno.getNome() + " editado com sucesso!");
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void list(Aluno objeto) throws IOException {
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

			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}


}