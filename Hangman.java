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
    	for (int i = 0; i < word.length(); i++) {
    		wordMarked = wordMarked + "-";
    	}
    	if( guessesRemaining > 0 ) {
    		if( lettersRemaining > 0 ) {
    			println("The word now looks like this: " + wordMarked);
    			println("You have " + guessesRemaining + " left.");
    			String guess = readLine("Your guess: ");
    			// if checked guess == 1 character
    			String oldwordMarked = wordMarked;
    			wordMarked = checkGuess(guess);
    			if (oldwordMarked == wordMarked) {
    				incorrectGuess();
    			} else {
    				correctGuess();
    			}
    		}
    	}
    }
    private String checkGuess(String checkedGuess) {
    	while(true) {
    		int pos = word.indexOf(checkedGuess);
    		if (pos >= 0) {
    			wordMarked = wordMarked.substring(0, pos) + checkedGuess + wordMarked.substring(pos + 1);
    		} else
    			break;
    	}
    	return wordMarked;	
    }
    private void incorrectGuess() {
    	//Handle incorrect guess
    	println("Incorrect");
    }
    private void correctGuess() {
    	//Handle correct guess
    	println("Correct");
    }

    
    private HangmanLexicon lexiconObject;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private String word;
    private int guessesRemaining = 8;
    private int lettersRemaining;
    private String wordMarked;
}
