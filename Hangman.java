/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;


public class Hangman extends ConsoleProgram {

    public void run() {
    	setGame();
    	beginGame();	
	}
    private void setGame() {
    	lexiconObject = new HangmanLexicon();
    	int wordIndex = rgen.nextInt(0,lexiconObject.getWordCount());
    	word = lexiconObject.getWord(wordIndex);
    }
    private void beginGame() {
    	println("Welcome to Hangman!");
    	for (int i; i < word.length();, i++) {
    		
    	}
    	if( guessesRemaining > 0 ) {
    		if( lettersRemaining > 0 ) {
    			println("The word now looks like this: " + wordMarked);
    			println("You have " + guessesRemaining + " left.");
    			String guess = readLine("Your guess: ");
    			wordMarked = checkGuess(guess);
    			
    		}
    	}
    	
    }
    private String checkGuess(String checkedGuess) {
    	while(true) {
    		
    	}
    }

    
    private HangmanLexicon lexiconObject;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private String word;
    private int guessesRemaining = 8;
    private int lettersRemaining;
    private String wordMarked;
}
