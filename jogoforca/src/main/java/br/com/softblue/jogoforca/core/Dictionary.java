package br.com.softblue.jogoforca.core;

import java.lang.reflect.Constructor;

public abstract class Dictionary {
	private static Dictionary instance;

	public static Dictionary getInstance() {
		if (Dictionary.instance == null) {
			String className = Config.get(Config.DICTIONARY_CLASS_NAME);

			try {
				Class<?> clazz = Class.forName(className);
				Constructor<?> constructor = clazz.getConstructor();

				Dictionary.instance = (Dictionary) constructor.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return Dictionary.instance;
	}

	public abstract Word nextWord();

	public abstract String getName();
}
