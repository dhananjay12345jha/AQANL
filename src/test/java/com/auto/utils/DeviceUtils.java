package com.auto.utils;

import com.automation.core.utilities.Sleeper;

import java.util.Objects;

public class DeviceUtils
{
	// Used to wait only when the device is iPhone - useful if iPhone is slower than other devices
	public static void waitIfIphone(final long millis)
	{
		if (isIphone())
		{
			Sleeper.sleep(millis);
		}
	}

	public static void waitIfSafari(final long millis)
	{
		if (isSafari())
		{
			Sleeper.sleep(millis);
		}
	}

	public static void waitIfIpad(final long millis)
	{
		if (isIpad())
		{
			Sleeper.sleep(millis);
		}
	}

	public static boolean isIphone()
	{
		final String device = System.getProperty("core_ENV#deviceName");
		return Objects.nonNull(device) && device.contains("iPhone");
	}

	public static boolean isSafari()
	{
		final String device = System.getProperty("core_ENV#browser");
		return Objects.nonNull(device) && device.contains("Safari");
	}

	public static boolean isSamsung() {
		final String device = System.getProperty("core_ENV#browser");
		return Objects.nonNull(device) && device.contains("Samsung");
	}

	public static boolean isCatalina()
	{
		final String os = System.getProperty("core_ENV#os_version");
		return Objects.nonNull(os) && os.contains("Catalina");
	}

	public static boolean isIpad()
	{
		final String device = System.getProperty("core_ENV#deviceName");
		return Objects.nonNull(device) && device.contains("iPad");
	}
}
