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
    			if (guessesRemaining != 1) {
    				println("You have " + guessesRemaining + " guesses left.");
    			} else {
    				println("You have " + guessesRemaining + " guess left.");
    			}
    			if (lettersRemaining != 1) {
    				println("You have " + lettersRemaining + " letters remaining.");
    			} else {
    				println("You have " + lettersRemaining + " letter remaining.");
    			}
    			String guess = readLine("Your guess: ");
    			if ( guess.length() == 1 ) {
    				guess = guess.toUpperCase();
    				wordMarked = checkGuess(guess);
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
    	if (y > 0) {
    		lettersRemaining = lettersRemaining - y;
    		if (y != 1) {
    			println("Correct: There are " + y + " " + checkedGuess + "'s in the word.");
    		} else {
    			println("Correct: There is " + y + " " + checkedGuess + " in the word.");
    		}
    	} else {
    		println("Incorrect: There are no " + checkedGuess + "'s in the word.");
    	}
    	return wordMarked;
    }
    
    private HangmanLexicon lexiconObject;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private String word;
    private int guessesRemaining = 8;
    private int lettersRemaining;
    private String wordMarked;
}
