package com.auto.dataLayer;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class DataLayer
{
	private final Map<String, Object> dataLayerMap;

	public DataLayer(final List<Map<String, Object>> rawDataLayer)
	{
		dataLayerMap = rawDataLayer.stream()
								   .filter(Objects::nonNull)
								   .flatMap(m -> m.entrySet().stream())
								   // Filter out generic GTM load events
								   .filter(entry -> !(entry.getValue() instanceof String) ||
													!((String) entry.getValue()).contains("gtm"))
								   .collect(Collectors.toMap(Map.Entry::getKey,
															 Map.Entry::getValue,
															 (a, b) -> b));
	}

	public DataLayer(final Map<String, Object> rawDataLayer)
	{
		dataLayerMap = rawDataLayer;
	}

	public String get(final String key)
	{
		return get(key, dataLayerMap);
	}

	public String get(final String key, final Map<String, Object> map)
	{
		if (key.contains("."))
		{
			final String subKey = key.substring(key.indexOf(".") + 1);
			final String mapKey = key.substring(0, key.indexOf("."));
			return get(subKey, (Map<String, Object>) map.get(mapKey));
		}
		else
		{
			return (String) map.get(key);
		}
	}

	public void put(final String key, final String value)
	{
		put(key, value, dataLayerMap);
	}

	public void put(final String key, final String value, final Map<String, Object> map)
	{
		if (key.contains("."))
		{
			final String subKey = key.substring(key.indexOf(".") + 1);
			final String mapKey = key.substring(0, key.indexOf("."));
			if (Objects.isNull(map.get(mapKey)))
			{
				map.put(mapKey, new HashMap<String, Object>());
			}
			put(subKey, value, (Map<String, Object>) map.get(mapKey));
		}
		else
		{
			map.put(key, value);
		}
	}

	public List<String> getKeys()
	{
		return getKeys(dataLayerMap, "");
	}

	public List<String> getKeys(final Map<String, Object> map, final String prefix)
	{
		final List<String> keys = new LinkedList<>();
		for (final String key : map.keySet())
		{
			final String formattedKey = prefix.isBlank() ? key : prefix + "." + key;

			final Object value = map.get(key);
			if (value instanceof Map)
			{
				keys.addAll(getKeys((Map<String, Object>) value, formattedKey));
			}
			else {
				keys.add(formattedKey);
			}
		}
		return keys;
	}
}
