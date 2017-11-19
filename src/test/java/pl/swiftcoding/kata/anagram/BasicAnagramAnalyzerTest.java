package pl.swiftcoding.kata.anagram;

import static com.google.common.truth.Truth.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class BasicAnagramAnalyzerTest {

	protected BasicAnagramAnalyzer getSut(List<String> words) {
		return new BasicAnagramAnalyzer(words);
	}

	@Test
	void shouldFineAnagramsInSimpleList() {
		List<String> listOf3Anagrams = List.of("abab", "baba", "abba");

		BasicAnagramAnalyzer anagramAnalyzer = getSut(listOf3Anagrams);

		Set<Anagrams> anagrams = anagramAnalyzer.allSets();

		assertThat(anagrams).contains(new Anagrams(listOf3Anagrams));
		assertThat(anagrams).containsExactly(new Anagrams(listOf3Anagrams));
	}

	@Test
	void shouldSplitWordsByAnagrams() {
		List<String> list = List.of("abab", "cac", "acc", "baba", "abba", "BB");

		BasicAnagramAnalyzer anagramAnalyzer = getSut(list);

		Set<Anagrams> anagrams = anagramAnalyzer.allSets();

		assertThat(anagrams).containsExactly(anagrams("abab", "baba", "abba"),
			anagrams("cac", "acc"),
			anagrams("BB"));
	}

	@Test
	void shouldIgnoreNoAnagrams() {
		List<String> list = List.of("abab", "cac", "acc", "baba", "abba", "BB");

		BasicAnagramAnalyzer anagramAnalyzer = getSut(list);

		Set<Anagrams> anagrams = anagramAnalyzer.anagrams();

		assertThat(anagrams).containsExactly(anagrams("abab", "baba", "abba"),
			anagrams("cac", "acc"));
	}

	private Anagrams anagrams(String... words) {
		return new Anagrams(Arrays.asList(words));
	}
}
