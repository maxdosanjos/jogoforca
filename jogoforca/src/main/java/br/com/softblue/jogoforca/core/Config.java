package br.com.softblue.jogoforca.core;

import java.io.IOException;
import java.util.Properties;

public class Config {
	private static Properties props = new Properties();
	public static final String MAX_ERRORS = "maxErrors";

	static {
		try {
			Config.props.load(Config.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String get(String nome) {
		return Config.props.getProperty(nome);
	}
	
	public static void setMaxErrors(String maxErrors) {
		Config.props.setProperty(Config.MAX_ERRORS, maxErrors);
	}
}
