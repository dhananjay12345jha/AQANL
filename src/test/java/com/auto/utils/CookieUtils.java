package com.auto.utils;

import com.auto.props.UrlProperties;
import org.openqa.selenium.Cookie;

import java.util.Calendar;

public class CookieUtils
{
	public static final String JSESSIONID = "JSESSIONID";

	public static Cookie generateJsessionIdCookie(final String value)
	{
		final Calendar expiryDate = Calendar.getInstance();
		expiryDate.add(Calendar.DAY_OF_MONTH, 5);

		return new Cookie(JSESSIONID,
						  value,
						  UrlProperties.getJsessionIdDomain(),
						  "/",
						  expiryDate.getTime(),
						  true,
						  true,
						  "None");
	}
}
