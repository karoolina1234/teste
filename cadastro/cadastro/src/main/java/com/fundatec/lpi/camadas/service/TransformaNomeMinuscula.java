package com.fundatec.lpi.camadas.service;

public class TransformaNomeMinuscula implements TransformaNome{

	public String valida(String nome) {
		String novoNome = nome.toLowerCase();
		return novoNome;
	}
	
}
