package br.com.softblue.jogoforca.core;

import java.util.ArrayList;
import java.util.List;

public class StaticDictionary extends Dictionary {
	private List<String> words = new ArrayList<>();
	private int currentIndex = -1;

	public StaticDictionary() {
		super();
		words.add("casa");
		words.add("computador");
		words.add("caneta");
	}

	@Override
	public Word nextWord() {
		currentIndex = (currentIndex + 1) % this.words.size();
		return new Word(this.words.get(currentIndex));
	}

	@Override
	public String getName() {
		return "Estático";
	}

}
