package com.auto.props;

import com.auto.config.PropertyConfig;

import java.util.Arrays;
import java.util.List;

public class MyAccountProperties
{
	private static final String MY_ACCOUNT_PREFIX = "myAccount.";

	public static String getMyAccountProperty(final String key)
	{
		return PropertyConfig.getValue(MY_ACCOUNT_PREFIX + key);
	}

	public static String getLinkName(final String page)
	{
		return getMyAccountProperty("link." + page);
	}

	public static List<String> getExpectedSideMenuLinks()
	{
		return Arrays.asList(getMyAccountProperty("expectedSideMenuLinks").split(","));
	}
}
