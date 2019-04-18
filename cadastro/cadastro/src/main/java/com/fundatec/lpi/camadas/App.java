package com.fundatec.lpi.camadas;

import java.io.IOException;
import java.util.Scanner;

import com.fundatec.lpi.camadas.dao.AlunoDAO;
import com.fundatec.lpi.camadas.domain.Aluno;
import com.fundatec.lpi.camadas.service.TransformaNomeMaiuscula;

public class App {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		TransformaNomeMaiuscula nomeMaiuscula = new TransformaNomeMaiuscula();
		Aluno aluno = new Aluno(null);
		AlunoDAO alunoDao = new AlunoDAO();

		int comando = 0;
		do {
			System.out.println("Escolha uma opção:");
			System.out.println("------------------");
			System.out.println("1 - Cadastro de aluno");
			System.out.println("2 - Listagem de alunos");
			System.out.println("3 - Deletar um aluno");
			System.out.println("4 - Editar um aluno");
			System.out.println("0 - Sair");
			System.out.println("");
			System.out.print("Qual opção? ");
			comando = scanner.nextInt();

			if (comando == 1) {
				System.out.println("=> Você quer cadastrar aluno");
				System.out.print("=> NOME: ");

				scanner.nextLine();
				String nome = scanner.nextLine();

		
				String novoNome = nomeMaiuscula.valida(nome);
				
				System.out.print("=> IDADE: ");
				
				int idade = scanner.nextInt();

				aluno.setNome(novoNome);
				aluno.setIdade(idade);
				alunoDao.save(aluno);

			} else if (comando == 2) {
				System.out.println("=> Você quer listar alunos");
				alunoDao.list(aluno);
			

			} else if (comando == 3) {
				System.out.println("=> Você quer deletar um aluno");
				System.out.print("=> ID: ");
				int id = scanner.nextInt();
				aluno.setId(id);
				alunoDao.delete(aluno);
				

			} else if (comando == 4) {
				System.out.println("=>Você quer editar um aluno");
				System.out.println(" ID: ");
				int id = scanner.nextInt();
				aluno.setId(id);
				
				System.out.println(" novo nome: ");
				String nome = scanner.next();
				aluno.setNome(nome);
				
				System.out.println(" nova idade: ");
				int idade = scanner.nextInt();
				aluno.setIdade(idade);
				
				alunoDao.update(aluno);
			
			}else if (comando == 0) {
				System.out.println("Saindo....");

			} else {
				System.out.println("Comando inválido");
			}

		} while (comando != 0);

		scanner.close();
	}
}
