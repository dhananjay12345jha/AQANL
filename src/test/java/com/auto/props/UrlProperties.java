package com.auto.props;

import com.auto.config.PropertyConfig;
import com.auto.utils.DeviceUtils;
import com.auto.utils.LocaleUtils;

public class UrlProperties
{
	private static final String URL_FILE = "url";

	public static String getUrlProperty(final String key)
	{
		return PropertyConfig.getValue(URL_FILE, key);
	}

	public static String getJsessionIdDomain()
	{
		return getUrlProperty("jsessionid.domain");
	}

	public static String getJsessionIdWhoAmI()
	{
		return String.format(getUrlProperty("jsessionid.whoAmI"), LocaleUtils.getSite());
	}

	public static String getOrderDetailsCollectionMapLink()
	{
		// On iPhone, we link to the Maps app rather than the website
		if (DeviceUtils.isIphone())
		{
			return getUrlProperty("orderDetails.collection.map.ios");
		}
		else
		{
			return getUrlProperty("orderDetails.collection.map");
		}
	}
}
