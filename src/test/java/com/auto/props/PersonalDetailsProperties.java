package com.auto.props;

import com.auto.config.PropertyConfig;

public class PersonalDetailsProperties
{
	private static final String PERSONAL_DETAILS_PREFIX = "personalDetails.";

	public static String getPersonalDetailsProperty(final String key)
	{
		return PropertyConfig.getValue(PERSONAL_DETAILS_PREFIX + key);
	}

	public static String getUpdateSuccessMessage()
	{
		return getPersonalDetailsProperty("updateEmail.success");
	}

	public static String getInvalidEmailMessage()
	{
		return getPersonalDetailsProperty("updateEmail.error.invalidEmail");
	}

	public static String getInvalidPasswordMessage()
	{
		return getPersonalDetailsProperty("updateEmail.error.invalidPassword");
	}

	public static String getMismatchedEmailMessage()
	{
		return getPersonalDetailsProperty("updateEmail.error.mismatchedEmail");
	}

	public static String getUpdateEmailLinkText()
	{
		return getPersonalDetailsProperty("updateEmail.link");
	}
}
