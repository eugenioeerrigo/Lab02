package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	List<Word> wordList = new LinkedList<Word>();
	
	public void addWord(String alienWord, String translation){
		Word n = new  Word(alienWord, translation);
		if(!wordList.contains(n))
			wordList.add(n);
		else
			n.setTranslation(translation);
	}
	
	public String translateWord(String alienWord){
		for(Word n : wordList)
			if(n.getAlienWord().equals(alienWord))
				return n.getTranslation();
		return null;
	}
}
