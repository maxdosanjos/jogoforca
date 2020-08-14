package br.com.softblue.jogoforca.ui;

import java.util.Scanner;

import br.com.softblue.jogoforca.core.InvalidCharacterException;

public class UI {
	public static void print(Object object) {
		System.out.println(object);
	}

	public static void printNewLine() {
		System.out.println();
	}

	@SuppressWarnings("resource")
	public static char readChar(String text) throws InvalidCharacterException {
		print(text + " ");

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		if (line.trim().isEmpty()) {
			throw new InvalidCharacterException("Nenhuma letra foi digitada");
		}

		if (line.length() > 1) {
			throw new InvalidCharacterException("Apenas 1 letra deve se digitada");
		}

		char c = line.charAt(0);

		if (!Character.isLetter(c)) {
			throw new InvalidCharacterException("Apenas letras deve ser digitada");
		}

		return c;
	}
}
