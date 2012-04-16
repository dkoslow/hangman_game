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
    	int wordIndex = rgen.nextInt(0,(lexiconObject.getWordCount() - 1));
    	word = lexiconObject.getWord(wordIndex);
    	lettersRemaining = word.length();
    	println(word);
    }
    private void beginGame() {
    	println("Welcome to Hangman!");
    	wordMarked = "-";
    	for (int i = 0; i < (word.length() - 1); i++) {
    		wordMarked = wordMarked + "-";
    	}
    	while ( guessesRemaining > 0 ) {
    		while ( lettersRemaining > 0 ) {
    			println("The word now looks like this: " + wordMarked);
    			println("You have " + guessesRemaining + " guesses left.");
    			String guess = readLine("Your guess: ");
    			if ( guess.length() == 1 ) {
    				guess = guess.toUpperCase();
    				wordMarked = checkGuess(guess);
    				if (isGuessCorrect == true) {
    					correctGuess();
    				} else if (isGuessCorrect == false) {
    					incorrectGuess();
    				} else {
//    					throw new ErrorException("lastGuess neither true nor false.");
    				}
    			} else {
    				println("You may only guess one letter at a time.");
    			}
    		}
    	}
    }
    private String checkGuess(String checkedGuess) {
    	int y = 0;
    	for ( int i = 0; i < word.length(); i++) {
    		char letter = checkedGuess.charAt(0);
    		if(word.charAt(i) == letter) {
    			wordMarked = wordMarked.substring(0, i) + checkedGuess + wordMarked.substring(i + 1);
    			y++;
    		}
    	}
    	while(true) {
    		int pos = word.indexOf(checkedGuess);
    		if (pos >= 0) {
    			wordMarked = wordMarked.substring(0, pos) + checkedGuess + wordMarked.substring(pos + 1);
    			y++;
    		} else
    			break;
    	}
    	if (y > 0) {
    		isGuessCorrect = true;
    	} else {
    		isGuessCorrect = false;
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
    private Boolean isGuessCorrect;
}
