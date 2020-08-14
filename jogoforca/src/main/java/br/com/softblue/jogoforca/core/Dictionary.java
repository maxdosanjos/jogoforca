package br.com.softblue.jogoforca.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.softblue.jogoforca.utils.RandomUtils;

public class Dictionary {

	private static final String FILE_NAME = "dicionario.txt";
	private List<String> words = new ArrayList<>();
	private static Dictionary instance;

	private Dictionary() {
		load();
	}

	public static Dictionary getInstance() {
		if(Dictionary.instance == null) {
			Dictionary.instance = new Dictionary();
		}
		return Dictionary.instance;
	}

	private void load() {
		try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine().trim();

				words.add(word);
			}
		}

		if (words.size() == 0) {
			throw new GameException("A lista de palavras não pode ser vazia");
		}

	}

	public Word nextWord() {
		int pos = RandomUtils.newRandomNumber(0, this.words.size());
		return new Word(this.words.get(pos));
	}
}
