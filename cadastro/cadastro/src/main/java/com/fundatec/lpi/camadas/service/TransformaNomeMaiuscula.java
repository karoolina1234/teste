package com.fundatec.lpi.camadas.service;

public class TransformaNomeMaiuscula implements TransformaNome{

	public String valida(String nome) {
		String novoNome;
		novoNome = nome.toUpperCase();
		return novoNome;
	}
}
