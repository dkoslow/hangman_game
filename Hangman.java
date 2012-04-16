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
    	
	}
    
    private void setGame() {
    	word = new HangmanLexicon();
    }

    
    private HangmanLexicon word;
}
