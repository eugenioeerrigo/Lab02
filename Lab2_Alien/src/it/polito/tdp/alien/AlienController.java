package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary a = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	List<String> translations = new LinkedList<String>();
    	
    	String in = txtWord.getText().toLowerCase();
    	
    	Pattern p = Pattern.compile("[0-9]");    	
    	Matcher m = p.matcher(in);
    	if(!m.find()){
    	String[] arr = in.split(" ");
    	
    	for(int i=1; i<arr.length; i++) 
			translations.add(arr[i]);
    	
    	if(arr.length==2){
    		a.addWord(arr[0], translations);
    		txtResult.appendText("Inserita!\n");
    	}
    	
    	if(arr.length==1)
    		txtResult.appendText(a.translateWord(arr[0])+"\n");
    	
    	if(arr.length>2) {
    		a.addWord(arr[0], translations);
    		txtResult.appendText("Inserite parole multiple!\n");
    	}
    	}else
    		txtResult.appendText("ERRORE! Inserire solo caratteri.\n");
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }
    
}
