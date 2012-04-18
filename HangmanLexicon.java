/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {
	
	private ArrayList <String> gameWords = new ArrayList <String> ();
	
	public HangmanLexicon() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while(true) {
				String line = reader.readLine();
				if(line == null) break;
				gameWords.add(line);
			}
			reader.close();
		} catch (IOException e) {
			throw new ErrorException(e);
		}
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return gameWords.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return gameWords.get(index);
	};
}
