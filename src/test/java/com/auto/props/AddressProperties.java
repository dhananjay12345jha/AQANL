package com.auto.props;

import com.auto.config.PropertyConfig;

import java.util.Arrays;
import java.util.List;

public class AddressProperties
{
	private static final String ADDRESS_PREFIX = "addresses.";

	public static String getAddressProperty(final String key)
	{
		return PropertyConfig.getValue(ADDRESS_PREFIX + key);
	}

	public static String getDefaultAddressMessage()
	{
		return getAddressProperty("defaultAddress.message");
	}

	public static String getSetAsDefaultAddressMessage()
	{
		return getAddressProperty("setAsDefaultAddress.message");
	}

	public static String getAddAddressMessage()
	{
		return getAddressProperty("addAddress.message");
	}

	public static String getDeleteAddressLink()
	{
		return getAddressProperty("deleteAddress.link");
	}

	public static String getDeleteAddressPopupTitle()
	{
		return getAddressProperty("deleteAddress.title");
	}

	public static String getDeleteAddressPopupDescription()
	{
		return getAddressProperty("deleteAddress.description");
	}

	public static String getDeleteAddressPopupConfirm()
	{
		return getAddressProperty("deleteAddress.confirm");
	}

	public static String getDeleteAddressPopupCancel()
	{
		return getAddressProperty("deleteAddress.cancel");
	}

	public static String getAddressName(final String address)
	{
		return getAddressProperty(address + ".name");
	}

	public static String getAddressTown(final String address)
	{
		return getAddressProperty(address + ".town");
	}

	public static String getAddressPostcode(final String address)
	{
		return getAddressProperty(address + ".postcode");
	}

	public static String getAddressCountry(final String address)
	{
		return getAddressProperty(address + ".country");
	}

	public static List<String> getAddressLines(final String address)
	{
		return Arrays.asList(getAddressProperty(address + ".lines").split(","));
	}
}
