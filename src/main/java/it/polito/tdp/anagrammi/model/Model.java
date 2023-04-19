package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.DAO.*;

public class Model {
	
	private ParolaDAO parolaDao;
	
	public Model() {
		this.parolaDao = new ParolaDAO();
	}
	
	public boolean parolaEsiste(String parola) {
		return this.parolaDao.parolaEsiste(parola);
	}
	
	public List<String> anagrammi(String parola){
		System.out.println(parola);
		
		if (parola.length() == 1) {
			List<String> risultato = new LinkedList<String>();
			risultato.add(parola);
			return risultato;
		}
		else {
			List<String> risultato = new LinkedList<String>();
			//estraggo una lettera per volta dalla parola
			//e divido in sottoproblemi
			for (int pos = 0; pos<parola.length(); pos ++) {
				char lettera = parola.charAt(pos);
				String restanti = parola.substring(0, pos) + parola.substring(pos+1); //lettere restanti della parola
				
				
				//risolvo i sottoproblemi
				List<String> anagrammiRestanti = anagrammi(restanti);
				for (String sol: anagrammiRestanti) {
					risultato.add(lettera+sol);
				}
			}
			return risultato;
		
		}
		
		
	}

		
	

}
