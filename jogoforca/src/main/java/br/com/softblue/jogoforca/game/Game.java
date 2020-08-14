package br.com.softblue.jogoforca.game;

import java.util.HashSet;
import java.util.Set;

import br.com.softblue.jogoforca.core.Config;
import br.com.softblue.jogoforca.core.Dictionary;
import br.com.softblue.jogoforca.core.InvalidCharacterException;
import br.com.softblue.jogoforca.core.Word;
import br.com.softblue.jogoforca.ui.UI;

public class Game {

	public void start(String[] args) {
		UI.print("Bem vindo ao jogo da forca!");

		Dictionary dicionary = Dictionary.getInstance();
		Word word = dicionary.nextWord();

		UI.print("A palavra tem " + word.size() + " letras");

		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;

		if (args.length > 0) {
			Config.setMaxErrors(args[0]);
		}
		int maxErrors = Integer.parseInt(Config.get(Config.MAX_ERRORS));

		UI.print("Você pode errar no máximo " + maxErrors + " vezes");

		while (true) {
			UI.print(word);
			UI.printNewLine();

			try {
				char c = UI.readChar("Digite uma letra: ");

				if (usedChars.contains(c)) {
					throw new InvalidCharacterException("Esta letra já foi utilizada");
				}
				usedChars.add(c);

				if (word.hasChar(c)) {
					UI.print("Você acertou uma letra!");
				} else {
					errorCount++;
					UI.print("Você errou! Você pode errar mais " + (maxErrors - errorCount) + " vez(es)");
				}

				UI.printNewLine();

				if (word.discoverd()) {
					UI.print("PARABÉNS! Você acertou a palavra completa: " + word.getOriginalWorld());
					UI.print("Fim do jogo!");
					break;
				}

				if (errorCount == maxErrors) {
					UI.print("Você perdeu o jogo! a palavra correta era: " + word.getOriginalWorld());
					UI.print("Fim do jogo!");
					break;
				}

			} catch (InvalidCharacterException e) {
				UI.print("Erro: " + e.getMessage());
				UI.printNewLine();
			}
		}
	}

}
