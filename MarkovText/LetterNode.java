package MarkovText;

import java.util.TreeSet;

public class LetterNode implements Comparable<LetterNode> {

	private final char letter;
	private boolean isTerminal;

	private TreeSet<LetterNode> subNodes = new TreeSet<LetterNode>();

	public LetterNode(String wordSegment) {

		letter = wordSegment.charAt(0);

		if (wordSegment.length() == 1) {

			isTerminal = true;

		} else if (wordSegment.length() > 1) {

			isTerminal = false;

			// Note that substring's arguments are inclusive and exclusive, respectively.
			LetterNode lowerNode = new LetterNode(wordSegment.substring(1, wordSegment.length()));
			subNodes.add(lowerNode);

		} else {

			// throw error;

		}

	}

	public void add(String wordSegment) {

		// This method assumes that the parent WordTrie has already checked for the existence
		// of this word and that it has also formatted it so that it is completely lowercase.

		if (wordSegment.length() == 1) {

			isTerminal = true;

		} else if (wordSegment.length() > 1) {

			char nextChar = wordSegment.charAt(1);

			if (this.containsLetterNode(nextChar)) {

				subNodes.floor(new LetterNode(String.valueOf(nextChar))).add(wordSegment.substring(1, wordSegment.length()));

			} else {

				LetterNode lowerNode = new LetterNode(wordSegment.substring(1, wordSegment.length()));
				subNodes.add(lowerNode);

			}


		}

	}

	private char getNodeLetter() {

		return letter;

	}

	@Override
	public int compareTo(LetterNode otherNode) {

		return Character.compare(this.getNodeLetter(), otherNode.getNodeLetter());

	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) return false;
		if (obj == this) return true;

		if (obj instanceof LetterNode == false) {

			return false;

		} else {

			LetterNode otherNode = (LetterNode) obj;

			return this.getNodeLetter() == otherNode.getNodeLetter();

		}

	}

	private boolean containsLetterNode(char c) {

		return subNodes.contains(new LetterNode(String.valueOf(c)));

	}

	public void listWords(String wordSegment) {

		String currentSegment = wordSegment + this.getNodeLetter();

		if (this.isTerminal) {

			System.out.println(currentSegment);

		}


		for (LetterNode n : subNodes) {

			n.listWords(currentSegment);

		}

	}

}