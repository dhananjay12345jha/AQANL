package com.auto.props;

import com.auto.config.PropertyConfig;

public class UserProperties
{
	private static final String USER_PREFIX = "user.";

	public static String getUserProperty(final String key)
	{
		return PropertyConfig.getValue(USER_PREFIX + key);
	}

	public static String getJsessionId(final String user)
	{
		return getUserProperty(user);
	}

	public static String getEmail(final String user)
	{
		return getUserProperty(user + ".email");
	}

	public static String getPassword(final String user)
	{
		return getUserProperty(user + ".password");
	}
}
