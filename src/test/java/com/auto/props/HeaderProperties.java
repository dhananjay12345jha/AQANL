package com.auto.props;

import com.auto.config.PropertyConfig;

public class HeaderProperties
{
	private static final String HEADER_PREFIX = "header.";

	public static String getHeaderProperty(final String key)
	{
		return PropertyConfig.getValue(HEADER_PREFIX + key);
	}

	public static String getWelcomeMessage()
	{
		return getHeaderProperty("welcome");
	}

	public static String getMiniMenuLink(final String link)
	{
		return getHeaderProperty("miniMenu.link." + link);
	}

	public static String getSearchBarPlaceholderText()
	{
		return getHeaderProperty("search.placeholder");
	}

	public static String getSearchTerm(final String term)
	{
		return getHeaderProperty("search.term." + term);
	}

	public static String getBreadcrumbLink(final String link)
	{
		return getHeaderProperty("breadcrumb." + link);
	}
}
