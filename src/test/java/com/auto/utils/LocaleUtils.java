package com.auto.utils;

public class LocaleUtils
{
	public static final String DEFAULT_SITE = "uk";

	private static final ThreadLocal<String> site;

	static
	{
		site = new ThreadLocal<>();
		site.set(DEFAULT_SITE);
	}

	public static String getSite()
	{
		return site.get();
	}

	public static void setSite(final String newSite)
	{
		site.set(newSite);
	}
}
