
package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import it.polito.tdp.anagrammi.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button burronCalcolaAnagrammi;

    @FXML
    private Button burronReset;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private TextField txtInserisciParola;

    @FXML
    void premiCalcolaAnagrammi(ActionEvent event) {
    	//calcolare tutti gli anagrammi
    	String parola = txtInserisciParola.getText();
    	List<String> anagrammi = this.model.anagrammi(parola);
    	for (String s: anagrammi) {
    		boolean anagrammaEsiste = model.parolaEsiste(s);
    		//se esistono nelle nostre parole li stampiamo in txtAnagrammiCorretti
    		if (anagrammaEsiste == true) {
    			txtAnagrammiCorretti.appendText(s + "\n");
    		}
    		//se non esistono li stampiamo in txtAnagrammiErrati
    		else {
    			txtAnagrammiErrati.appendText(s + "\n");
    		}
    	}
    	
    	
    	
    	

    }

    @FXML
    void premiReset(ActionEvent event) {
    	this.txtInserisciParola.clear();
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();

    }

    @FXML
    void initialize() {
        assert burronCalcolaAnagrammi != null : "fx:id=\"burronCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert burronReset != null : "fx:id=\"burronReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserisciParola != null : "fx:id=\"txtInserisciParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}


