package it.polito.tdp.DAO;

import java.sql.*;
import java.util.*;

import it.polito.tdp.anagrammi.model.Parola;

public class ParolaDAO {
	
	public boolean parolaEsiste(String parola) {
		//where nome=cane
		//se nome esiste count = 1
		//se nome non esiste count = 0
		boolean risultato = false;
		final String sql = "SELECT COUNT(*) AS n "+ "FROM parola " + "WHERE nome = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int esiste = rs.getInt("n");
				if(esiste > 0) {
					risultato = true;
				}
			}

			conn.close();
			
			return risultato;
			

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore di connessione con db");
			return risultato;
			
		}
	}

}
