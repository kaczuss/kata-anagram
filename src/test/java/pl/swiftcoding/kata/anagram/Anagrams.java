package pl.swiftcoding.kata.anagram;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.TreeMultiset;

final class Anagrams {
	private final Set<Word> words;

	Anagrams(List<String> words) {
		this(words.stream().map(Word::new).toArray(Word[]::new));
	}

	Anagrams(Word... words) {
		if (words.length == 0) {
			throw new IllegalArgumentException("At least one word can create anagrams object");
		}
		this.words = Sets.newLinkedHashSet(Lists.newArrayList(words));
	}

	boolean matches(Word testWord) {
		Multiset<Character> charactersToCheck = charactersSet(words.iterator().next());
		Multiset<Character> testCharacters = charactersSet(testWord);
		return charactersToCheck.equals(testCharacters);
	}

	private Multiset<Character> charactersSet(Word wordToCheck) {
		Multiset<Character> charactersToCheck = TreeMultiset.create();
		for (char character : wordToCheck.characters()) {
			charactersToCheck.add(character);
		}
		return charactersToCheck;
	}

	void add(Word word) {
		words.add(word);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Anagrams anagrams1 = (Anagrams) o;
		return Objects.equals(words, anagrams1.words);
	}

	@Override
	public int hashCode() {
		char[] characters = words.iterator().next().characters();
		Arrays.sort(characters);
		return Arrays.hashCode(characters);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("anagrams", words)
			.toString();
	}
}
