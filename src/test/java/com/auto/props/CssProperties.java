package com.auto.props;

import com.auto.config.PropertyConfig;

public class CssProperties
{
	private static final String CSS_FILE = "css";
	private static final String CSS_MOBILE_FILE = "css-mobile";

	public static String getCssProperty(final String key)
	{
		return PropertyConfig.getValue(CSS_FILE, key);
	}

	public static String getCssMobileProperty(final String key)
	{
		return PropertyConfig.getValue(CSS_MOBILE_FILE, key);
	}

}
