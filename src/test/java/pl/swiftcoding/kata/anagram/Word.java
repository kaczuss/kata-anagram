package pl.swiftcoding.kata.anagram;

import java.util.Objects;

final class Word {
	private String word;

	Word(String word) {
		this.word = word;
	}

	char[] characters() {
		return word.toCharArray();
	}

	@Override
	public String toString() {
		return word;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Word word1 = (Word) o;
		return Objects.equals(word, word1.word);
	}

	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
}
