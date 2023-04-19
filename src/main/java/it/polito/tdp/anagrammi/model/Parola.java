package it.polito.tdp.anagrammi.model;

public class Parola {

	private String nome;
	private boolean isCorrect;

	public Parola(String parola, boolean isCorrect) {
		this.nome = parola;
		this.isCorrect = isCorrect;
	}

	public String getParola() {
		return nome;
	}
	
	public boolean getIsCorrect() {
		return isCorrect;
	}
	
	

	

}
