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
	public void displayWord() {
		Hangman wordForDisplay = new Hangman();
		String showWord = wordForDisplay.getWordMarked();
		wordDisplay = new GLabel("test", 500, 50);
		wordDisplay.setFont("Times-12");
		wordDisplay.setColor(Color.red);
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
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
	}
	public GLabel wordDisplay;

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
