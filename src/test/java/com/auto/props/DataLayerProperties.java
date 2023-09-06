package com.auto.props;

import com.auto.config.PropertyConfig;
import com.auto.utils.LocaleUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataLayerProperties
{
	private static final String DATA_LAYER_PREFIX = "dataLayer.";

	public static final String USER_AGENT = "user.user_agent";
	public static final String BREADCRUMB = "page.breadcrumbs";
	public static final String TITLE = "page.title";

	public static final String ERROR_MESSAGE = "error_message";

	public static String getDataLayerProperty(final String key)
	{
		return PropertyConfig.getValue(DATA_LAYER_PREFIX + key);
	}

	public static Map<String, Object> getDataLayerJson()
	{
		return getDataLayerJson("global", LocaleUtils.getSite());
	}

	public static Map<String, Object> getDataLayerJson(final String event, final String variables)
	{
		try
		{
			final String filename = String.format("src/test/resources/dataLayer/DataLayer-%s-%s.json", event, variables);
			return new ObjectMapper().readValue(new File(filename), HashMap.class);
		}
		catch (final IOException e)
		{
			return new HashMap<>();
		}
	}
}
