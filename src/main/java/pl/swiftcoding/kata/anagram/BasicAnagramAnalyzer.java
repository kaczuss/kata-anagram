package pl.swiftcoding.kata.anagram;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class BasicAnagramAnalyzer implements AnagramAnalyzer {

	private final Set<Anagrams> anagrams = new LinkedHashSet<>();

	BasicAnagramAnalyzer(List<String> words) {
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


	@Override
	public Set<Anagrams> allSets() {
		return anagrams;
	}

	@Override
	public Set<Anagrams> anagrams() {
		return anagrams.stream()
			.filter(a -> a.wordsCount() > 1)
			.collect(Collectors.toCollection(LinkedHashSet::new));
	}
}
