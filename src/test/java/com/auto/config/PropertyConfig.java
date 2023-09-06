package com.auto.config;

import com.auto.utils.LocaleUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfig {

	public static String getValue(final String file, final String key) {
		try (final InputStream input = new FileInputStream("src/test/java/com/auto/properties/" + file + ".properties")) {
			final Properties prop = new Properties();
			prop.load(input);
			return prop.getProperty(key);
		}
		catch (final IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String getValue(final String key) {
		return getValue(LocaleUtils.getSite(), key);
	}
}

