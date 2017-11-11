package pl.swiftcoding.kata.anagram;

import static com.google.common.truth.Truth.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class AnagramAnalyzerTest {

	@Test
	void shouldFineAnagramsInSimpleList() {
		List<String> listOf3Anagrams = List.of("abab", "baba", "abba");

		AnagramAnalyzer anagramAnalyzer = new AnagramAnalyzer(listOf3Anagrams);

		Set<Anagrams> anagrams = anagramAnalyzer.anagrams();

		assertThat(anagrams).contains(new Anagrams(listOf3Anagrams));
		assertThat(anagrams).containsExactly(new Anagrams(listOf3Anagrams));
	}
}
