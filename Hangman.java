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

import HangmanLexicon.java;

public class Hangman extends ConsoleProgram {

    public void run() {
    	word = new HangmanLexicon(1);
    	println(word);
	}

    
    private HangmanLexicon word;
}
