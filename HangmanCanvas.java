/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.Color;

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		GLine scaffoldVert = new GLine(50, 50, 50, 50 + SCAFFOLD_HEIGHT);
		add(scaffoldVert);
		GLine scaffoldBeam = new GLine(50, 50, 50 + BEAM_LENGTH, 50);
		add(scaffoldBeam);
		GLine rope = new GLine(50 + BEAM_LENGTH, 50, 50 + BEAM_LENGTH, 50 + ROPE_LENGTH );
		add(rope);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		wordDisplay = new GLabel (word, 250, 50);
		wordDisplay.setFont("Times-18");
		add(wordDisplay);
	}
	public void removeWord() {
		remove(wordDisplay);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(String word) {
		incorrectGuessLabel = new GLabel("Incorrect guesses: " + word, 50, 450);
		incorrectGuessLabel.setFont("Times-12");
		add(incorrectGuessLabel);
	}
	public void removeIncorrectGuess() {
		remove(incorrectGuessLabel);
	}
	public void addBodyPart(int x) {
		switch (x) {
		case 0: return;
		case 1: addHead();
//		case 2: addBody();
//		case 3: addArmL();
//		case 4: addArmR();
//		case 5: addLegL();
//		case 6: addLegR();
//		case 7: addFootL();
//		case 8: addFootR();
		default: return;
		}
	}
	private void addHead() {
		GOval head = new GOval(50 + BEAM_LENGTH - HEAD_RADIUS, 50 + ROPE_LENGTH, 2* HEAD_RADIUS, 2* HEAD_RADIUS );
		add(head);
	}
	private GLabel wordDisplay;
	private GLabel incorrectGuessLabel;

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
