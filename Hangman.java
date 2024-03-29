import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;


public class Hangman extends ConsoleProgram {
	
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
		canvas.reset();
	}
    public void run() {
    	setGame();
    	beginGame();
	}
    private void setGame() {
    	lexiconObject = new HangmanLexicon();
    	int wordIndex = rgen.nextInt(0,(lexiconObject.getWordCount() - 1));
    	word = lexiconObject.getWord(wordIndex);
    	lettersRemaining = word.length();
    	incorrectGuessCounter = 0;
    }
    private void beginGame() {
    	println("Welcome to Hangman!");
    	wordMarked = "-";
    	for (int i = 0; i < (word.length() - 1); i++) {
    		wordMarked = wordMarked + "-";
    	}
    	canvas.displayWord(wordMarked);
    	canvas.noteIncorrectGuess(incorrectGuesses);
    	while ( guessesRemaining > 0 ) {
    		if ( lettersRemaining > 0 ) {
    			println("The word now looks like this: " + wordMarked);
    			if (guessesRemaining != 1) {
    				println("You have " + guessesRemaining + " incorrect guesses left.");
    			} else {
    				println("You have " + guessesRemaining + " incorrect guess left.");
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
    		} else {
    			canvas.winMessage();
    			return;
    		}
    	}canvas.loseMessage();
    	println("The word was: " + word);
    	return;
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
    		canvas.removeWord();
    		canvas.displayWord(wordMarked);
    	} else {
    		println("Incorrect: There are no " + checkedGuess + "'s in the word.");
    		incorrectGuesses = incorrectGuesses + checkedGuess;
    		canvas.removeIncorrectGuess();
    		canvas.noteIncorrectGuess(incorrectGuesses);
    		incorrectGuessCounter++;
    		canvas.addBodyPart(incorrectGuessCounter);
    		guessesRemaining--;
    	}
    	return wordMarked;
    }
    public String getWord() {
    	return wordMarked;
    }
    
    private HangmanCanvas canvas;
    private HangmanLexicon lexiconObject;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private String word;
    private int guessesRemaining = 8;
    private int lettersRemaining;
    private String wordMarked;
    public GLabel wordDisplay;
    private String incorrectGuesses = "";
    private int incorrectGuessCounter;
}
