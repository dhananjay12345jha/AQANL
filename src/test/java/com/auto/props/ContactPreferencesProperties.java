package com.auto.props;

import com.auto.config.PropertyConfig;
import com.automation.core.utilities.Sleeper;

public class ContactPreferencesProperties
{
	private static final String CONTACT_PREFERENCES_PREFIX = "contactPreference.";

	public static String ContactPreferencesProperties(final String key)
	{
		return PropertyConfig.getValue(CONTACT_PREFERENCES_PREFIX + key);
	}


	public static String getTitle()
	{
		return ContactPreferencesProperties("title");
	}
	public static String getSummary()
	{
		return ContactPreferencesProperties("summary");
	}
	public static String getPrivacyHelpPageUrl()
	{
		return ContactPreferencesProperties("privacyHelpPage");
	}
	public static String getSocialCampaigns()
	{
		return ContactPreferencesProperties("socialCampaigns");
	}
	public static String getSocialCampaignsDesc()
	{
		return ContactPreferencesProperties("socialCampaignsDesc");
	}
	public static String getPostPurchaseProductReview()
	{
		return ContactPreferencesProperties("postPurchaseProductReview");
	}
	public static String getPostPurchaseProductReviewDesc()
	{
		return ContactPreferencesProperties("postPurchaseProductReviewDesc");
	}
	public static String getEmailNewsletter()
	{
		return ContactPreferencesProperties("emailNewsletter");
	}
	public static String geteEmailNewsletterDesc()
	{
		return ContactPreferencesProperties("emailNewsletterDesc");
	}
	public static String getUpdateMessage()
	{
		return ContactPreferencesProperties("updateMessage");
	}

}
