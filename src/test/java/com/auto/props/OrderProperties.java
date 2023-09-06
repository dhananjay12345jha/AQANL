package com.auto.props;

import com.auto.config.PropertyConfig;

import java.util.Arrays;
import java.util.List;

public class OrderProperties
{
	private static final String ORDER_PREFIX = "orders.";

	public static String getOrderProperty(final String key)
	{
		return PropertyConfig.getValue(ORDER_PREFIX + key);
	}

	public static String getOrderId(final String id)
	{
		return String.format(getOrderProperty("idFormat"), id);
	}

	public static String getItemCount(final int number)
	{
		if (number == 1)
		{
			return getOrderProperty("itemCount.single");
		}
		else
		{
			return String.format(getOrderProperty("itemCount.multi"), number);
		}
	}

	public static List<String> getOrderStatuses(final String deliveryMethod)
	{
		return Arrays.asList(getOrderProperty("statuses." + deliveryMethod).split(","));
	}

	public static String getOrderStatus(final String id)
	{
		return getOrderProperty("status." + id);
	}

	public static String getStatusDescription(final String status)
	{
		return getOrderProperty("status.description." + status);
	}

	public static String getOpenMapText()
	{
		return getOrderProperty("openMap.text");
	}

	public static String getDeliveryMethod(final String deliveryMethod)
	{
		return getOrderProperty("delivery." + deliveryMethod);
	}
}
