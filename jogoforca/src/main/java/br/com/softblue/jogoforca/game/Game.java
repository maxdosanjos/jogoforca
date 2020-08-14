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

		UI.print("Voc� pode errar no m�ximo " + maxErrors + " vezes");

		while (true) {
			UI.print(word);
			UI.printNewLine();

			try {
				char c = UI.readChar("Digite uma letra: ");

				if (usedChars.contains(c)) {
					throw new InvalidCharacterException("Esta letra j� foi utilizada");
				}
				usedChars.add(c);

				if (word.hasChar(c)) {
					UI.print("Voc� acertou uma letra!");
				} else {
					errorCount++;
					UI.print("Voc� errou! Voc� pode errar mais " + (maxErrors - errorCount) + " vez(es)");
				}

				UI.printNewLine();

				if (word.discoverd()) {
					UI.print("PARAB�NS! Voc� acertou a palavra completa: " + word.getOriginalWorld());
					UI.print("Fim do jogo!");
					break;
				}

				if (errorCount == maxErrors) {
					UI.print("Voc� perdeu o jogo! a palavra correta era: " + word.getOriginalWorld());
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
