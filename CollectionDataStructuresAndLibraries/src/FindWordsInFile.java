package src;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FindWordsInFile {
	//Please add file path...
	private final static String FILE_NAME = "input.txt";
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static void main(String[] args) throws IOException {
		final long startTime = System.currentTimeMillis();
		Map<String, Integer> words = findWords(FILE_NAME);
		final long endTime = System.currentTimeMillis();
		
		words.forEach((word, count) -> System.out.println(word + " -> " + count));
	}

	private static Map<String, Integer> findWords(String fileName) throws IOException {
		Map<String, Integer> words = new HashMap<>();
		Path path = Paths.get(fileName);
		String word = null;
		try (Scanner scanner = new Scanner(path, ENCODING.name())){
			while (scanner.hasNext()) {
				word = scanner.next();
				if (words.containsKey(word)) {
					words.put(word, words.get(word) + 1);
				} else {
					words.put(word, 1);
				}
			}
		}
		
		return words;
	}
}
