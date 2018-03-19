package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {

	private String alienWord;
	private List<String> translations = new LinkedList<String>();
	
	public WordEnhanced(String alienWord, List<String> translations) {
		this.alienWord = alienWord;
		this.translations = translations;
	}
	
	
}
