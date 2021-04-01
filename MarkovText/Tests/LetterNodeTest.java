package MarkovText.Tests;

import MarkovText.LetterNode;

class LetterNodeTest {

	public static void main(String[] args) {

		new LetterNodeTest();

	}

	LetterNodeTest() {

		LetterNode nodeOne = new LetterNode("readings");
		nodeOne.add("reading");
		nodeOne.add("read");
		nodeOne.add("readingsworth");

		//nodeOne.add("readingsworth");
		//nodeOne.add("reading");
		//nodeOne.add("read");

		nodeOne.listWords("");

	}



}