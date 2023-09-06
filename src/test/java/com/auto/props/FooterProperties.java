package com.auto.props;

import com.auto.config.PropertyConfig;

public class FooterProperties
{
	private static final String FOOTER_PREFIX = "footer.";

	public static String getFooterProperty(final String key)
	{
		return PropertyConfig.getValue(FOOTER_PREFIX + key);
	}

	public static String getNewsletterSignUpErrorMessage()
	{
		return getFooterProperty("newsletterSignUpErrorMessage");
	}
}
