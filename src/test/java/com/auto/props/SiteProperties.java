package com.auto.props;

import com.auto.config.PropertyConfig;

public class SiteProperties
{
	private static final String SITE_PREFIX = "site.";

	public static String getSiteProperty(final String key)
	{
		return PropertyConfig.getValue(SITE_PREFIX + key);
	}

	public static String getCurrencySymbol()
	{
		return getSiteProperty("currency.symbol");
	}

	public static String getCurrencyDelimiter()
	{
		return getSiteProperty("currency.delimiter");
	}

	public static String getCurrencyFormat()
	{
		return getSiteProperty("currency.format");
	}

	public static String getErrorPageTitle(final int code)
	{
		return getSiteProperty("errorPage." + code + ".title");
	}
}
