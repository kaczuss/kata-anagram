package pl.swiftcoding.kata.anagram;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


class AnagramAnalyzer {

	private final Set<Anagrams> anagrams = new LinkedHashSet<>();

	AnagramAnalyzer(List<String> words) {
		analyze(words);
	}

	private void analyze(List<String> words) {
		for (String word : words) {
			Word anagramCandidate = new Word(word);
			Anagrams currentAnagrams = findAnagrams(anagramCandidate);
			if (currentAnagrams == null) {
				currentAnagrams = new Anagrams(anagramCandidate);
				anagrams.add(currentAnagrams);
			} else {
				currentAnagrams.add(anagramCandidate);
			}
		}
	}

	private Anagrams findAnagrams(Word word) {
		for (Anagrams anagram : anagrams) {
			if (anagram.matches(word)) {
				return anagram;
			}
		}
		return null;
	}


	Set<Anagrams> anagrams() {
		return anagrams;
	}
}
