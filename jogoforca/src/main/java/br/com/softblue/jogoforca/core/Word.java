package br.com.softblue.jogoforca.core;

import java.util.HashSet;
import java.util.Set;

public class Word {

	private static final char SECRET_CHAR = '_';
	private String originalWorld;
	private Set<Character> foundChars = new HashSet<>();
	private Set<Character> wordChars = new HashSet<>();

	public Word(String originalWorld) {
		this.originalWorld = originalWorld.toUpperCase();

		char[] chars = this.originalWorld.toCharArray();
		for (char c : chars) {
			this.wordChars.add(c);
		}
	}

	public boolean discoverd() {
		return this.foundChars.equals(this.wordChars);
	}

	public String getOriginalWorld() {
		return originalWorld;
	}

	public int size() {
		return this.originalWorld.length();
	}

	public boolean hasChar(char c) {
		c = Character.toUpperCase(c);
		if (this.originalWorld.indexOf(c) > -1) {
			this.foundChars.add(c);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		char[] charArray = this.originalWorld.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];

			if (this.foundChars.contains(c)) {
				sb.append(c);
			} else {
				sb.append(SECRET_CHAR);
			}

			sb.append(" ");
		}

		return sb.toString();
	}

}
