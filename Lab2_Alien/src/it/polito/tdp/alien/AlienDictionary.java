package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	List<WordEnhanced> wordList = new LinkedList<WordEnhanced>();
	
	public void addWord(String alienWord, List<String> translation){
		WordEnhanced n = new  WordEnhanced(alienWord, translation);
		if(!wordList.contains(n))
			wordList.add(n);
		else
			n.setTranslations(translation);
	}
	
	public String translateWord(String alienWord){
		String ris="";
		for(WordEnhanced n : wordList)
			if(n.getAlienWord().equals(alienWord)) {
				for(String s : n.getTranslations())
					ris += s+" ";
				return ris;
			}
		return null;
	}
}
