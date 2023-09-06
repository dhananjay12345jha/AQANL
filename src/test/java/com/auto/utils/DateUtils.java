package com.auto.utils;


import com.auto.pages.OrderDetailsPage;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtils
{

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(DateUtils.class);

	public static void  parseDate(String format, String dateTime) {
		try{
			DateFormat inputFormat = new SimpleDateFormat(format, Locale.UK);
			inputFormat.parse(dateTime);
		} catch(ParseException e){
			LOG.error(e +  " - could not parse the date time from"+dateTime);
		}
	}
}
