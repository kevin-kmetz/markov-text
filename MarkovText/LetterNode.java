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

			LetterNode lowerNode = new LetterNode(wordSegment.subString(1, wordSegment.length()-1));
			subNodes.add(lowerNode);

		} else {

			// throw error;

		}

	}

	void add(String wordSegment) {

		// This method assumes that the parent WordTrie has already checked for the existence
		// of this word and that it has also formatted it so that it is completely lowercase.

		if (wordSegment.length() == 1) {

			isTerminal = true;

		} else if (wordSegment.length() > 1) {

			isTerminal = false;

			char nextChar = wordSegment.charAt(1);

			if (this.containsLetterNode(nextChar)) {

				subNotes.floor(new LetterNode(String.valueOf(nextChar))).add(wordSegment.subString(1, wordSegment.length()-1));

			} else {

				LetterNode lowerNode = new LetterNode(wordSegment.subString(1, wordSegment.length()-1));
				subNodes.add(lowerNode);

			}


		}

	}

	boolean getNodeLetter() {

		return letter;

	}

	@Override
	int compareTo(LetterNode otherNode) {

		return Character.compare(this.getNodeLetter(), otherNode.getNodeLetter());

	}

	@Override
	boolean equals(LetterNode otherNode) {

		return this.getNodeLetter() == otherNode.getNodeLetter();

	}

}