package MarkovText;

import java.util.TreeSet;

class LetterNode implements Comparable {

	private final char letter;
	private boolean isTerminal;

	TreeSet<LetterNode> subNodes = new TreeSet<LetterNode>();

	LetterNode(String wordSegment) {

		if (wordSegment.length() == 1) {

			letter = wordSegment.charAt(0);
			isTerminal = true;

		} else if (wordSegment.length() > 1) {

			letter = wordSegment.charAt(0);
			isTerminal = false;

			LetterNode lowerNode = new LetterNode(wordSegment.subString(1, wordsegment.length()-1));
			subNodes.add(lowerNode);

		} else {

			// throw error;

		}

	}

	boolean add(String wordSegment) {

		if (wordSegment.length() == 1) {

			isTerminal = true;

		} else if (wordSegment.length() > 1) {

			isTerminal = false;

			char nextChar = wordSegment.charAt(1);

			if (this.containsLetterNode(nextChar)) {

				

			} else {

				LetterNode lowerNode = new LetterNode(wordSegment.subString(1, wordSegment.length()-1));
				subNodes.add(lowerNode);

			}


		}

	}

}