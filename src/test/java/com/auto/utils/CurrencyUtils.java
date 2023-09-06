package com.auto.utils;

import com.auto.config.PropertyConfig;
import com.auto.props.SiteProperties;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyUtils
{
	public static double sum(final List<String> prices)
	{
		return prices.stream().mapToDouble(CurrencyUtils::getValue).sum();
	}

	public static double sum(final String... prices)
	{
		return sum(Arrays.stream(prices).collect(Collectors.toList()));
	}

	public static String formattedSum(final List<String> prices)
	{
		return formatCurrency(sum(prices));
	}

	public static String formattedSum(final String... prices)
	{
		return formatCurrency(sum(prices));
	}

	public static double getValue(final String price)
	{
		final String unformattedPrice = CurrencyUtils.stripCurrencyFormatting(price);
		if (unformattedPrice.equalsIgnoreCase(PropertyConfig.getValue("free")))
		{
			return 0;
		}
		else
		{
			return Double.parseDouble(unformattedPrice.replaceAll("[A-Za-z\\s]", ""));
		}
	}

	public static String stripCurrencyFormatting(final String price)
	{
		return price.replaceAll(SiteProperties.getCurrencySymbol(), "")
					.replaceAll(SiteProperties.getCurrencyDelimiter(), ".")
					.trim();
	}

	public static String formatCurrency(final double value)
	{
		return SiteProperties.getCurrencyFormat()
							 .replaceAll("value", String.format("%.2f", value))
							 .replaceAll("symbol", SiteProperties.getCurrencySymbol());
	}
}
