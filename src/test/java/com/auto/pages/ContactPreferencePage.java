package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.props.ContactPreferencesProperties;
import com.auto.utils.DeviceUtils;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import com.automation.core.utilities.assertion.AssertUtils;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Objects;

public class ContactPreferencePage extends BasePage
{
	@FindBy(css = "[data-testid='pageTitle']")
	private ExtWebElement title;

	@FindBy(css = "[data-testid='contact-pref-sub-title_test']")
	private ExtWebElement summary;
	@FindBy(css = "[data-testid='privacy-policy-link_test']")
	private ExtWebElement privacylink;
	@FindBy(css = "[data-testid='privacy-policy-container_test']")
	private ExtWebElement termCondition;
	@FindBy(css = "[data-testid='email-newsletter-titled-box_test'] [data-testid='titled-box-title_test']")
	private ExtWebElement emailNewsTitle;
	@FindBy(css = "[data-testid='email-newsletter-titled-box_test'] [data-testid='titled-box-title_desc']")
	private ExtWebElement emailNewsDesc;
	@FindBy(css = "[data-testid='email-newsletter-group-radio-group_test}']")
	private ExtWebElement emailoptInOption;

	@FindBy(css = "[data-testid='post-purchase-reviews-titled-box_test'] [data-testid='titled-box-title_test']")
	private ExtWebElement postProductReviewTitle;
	@FindBy(css = "[data-testid='post-purchase-reviews-titled-box_test'] [data-testid='titled-box-title_desc']")
	private ExtWebElement postProductReviewDesc;
	@FindBy(css = "[data-testid='post-purchase-reviews-group-radio-group_test}']")
	private ExtWebElement optInOptionPostProductReview;

	@FindBy(css = "[data-testid='social-campaigns-titled-box_test'] [data-testid='titled-box-title_test']")
	private ExtWebElement socialCampaignsTitle;
	@FindBy(css = "[data-testid='social-campaigns-titled-box_test'] [data-testid='titled-box-title_desc']")
	private ExtWebElement socialCampaignsDesc;
	@FindBy(css = "[data-testid='social-campaigns-group-radio-group_test}']")
	private ExtWebElement optInOptionSocialCampaigns;

	@FindBy(css = "[id='social-campaigns-yes']")
	private ExtWebElement optInOptionNewsletterYes;

	@FindBy(css = "[id='post-purchase-reviews-yes']")
	private ExtWebElement optOutOptionPurchaseReviewsYes;

	@FindBy(css = "[id='social-campaigns-no']")
	private ExtWebElement optInOptionSocialCampaignsNo;
	
	@FindBy(css = "[id='post-purchase-reviews-no']")
	private ExtWebElement optOutOptionPurchaseReviewsNo;

	@FindBy(css = "[id='social-campaigns-yes']")
	private ExtWebElement optInOptionSocialCampaignsYes;

	@FindBy(css = "[id='email-newsletter-no']")
	private ExtWebElement optOutOptionNewsletterNo;

	@FindBy(css = "[id='post-purchase-reviews-yes']")
	private ExtWebElement optInOptionPurchaseReviewsYes;

	@FindBy(css = "[id='social-campaigns-no']")
	private ExtWebElement optOutOptionSocialCampaignsNo;

	@FindBy(css = "[data-testid='save-preferences-button_test']")
	private ExtWebElement savePreferencesButton;

	@FindBy(css = "[data-testid='updateMessageContainer']")
	private ExtWebElement updateMessage;

	public void checkTitle(){
		Sleeper.sleep(1000);
		Assert.assertEquals(title.getText(), ContactPreferencesProperties.getTitle());
	}
	public void checkSummary(){
		Sleeper.sleep(1000);
		Assert.assertEquals(summary.getText(),ContactPreferencesProperties.getSummary());
	}
	public void checkPrivacyLink(){
		Assert.assertTrue(privacylink.isVisible());
	}
	public void termAndCondition(){
		Assert.assertTrue(termCondition.isVisible());
	}
	public void clickPrivacyPolicyLink(){
		privacylink.click();
	}
	public void checkPrivacyPolicyHelpPage(){
		waitForPageLoad();
		DeviceUtils.waitIfIphone(2000);
		DeviceUtils.waitIfIpad(2000);
		AssertUtils.assertContains(getCurrentUrl(),
								   ContactPreferencesProperties.getPrivacyHelpPageUrl());
	}
	public void checkEmailNewsTitleDescOpt(){

		Assert.assertEquals(emailNewsTitle.getText(),ContactPreferencesProperties.getEmailNewsletter());
		Assert.assertEquals(emailNewsDesc.getText(),ContactPreferencesProperties.geteEmailNewsletterDesc());
		Assert.assertTrue(emailoptInOption.isVisible());

	}
	public void checkPostPurchaseProductNewsTitleDescOpt(){

		Assert.assertEquals(postProductReviewTitle.getText(),ContactPreferencesProperties.getPostPurchaseProductReview());
		Assert.assertEquals(postProductReviewDesc.getText(),ContactPreferencesProperties.getPostPurchaseProductReviewDesc());
		Assert.assertTrue(optInOptionPostProductReview.isVisible());

	}
	public void checkSocialCampaignNewsTitleDescOpt(){

		Assert.assertEquals(socialCampaignsTitle.getText(),ContactPreferencesProperties.getSocialCampaigns());
		Assert.assertEquals(socialCampaignsDesc.getText(),ContactPreferencesProperties.getSocialCampaignsDesc());
		Assert.assertTrue(optInOptionSocialCampaigns.isVisible());

	}

    public void checkDefaultSelectOptions(String user) {
		if (user.equals("multipleOrders")) {
			Assert.assertTrue(optInOptionNewsletterYes.isSelected(),"optInOptionNewsletterYes not selected");
			Assert.assertTrue(optOutOptionPurchaseReviewsNo.isSelected(),"optOutOptionPurchaseReviewsNo not selected");
			Assert.assertTrue(optInOptionSocialCampaignsYes.isSelected(),"optInOptionSocialCampaignsYes not selected");
		}
		else if (user.equals("longName"))
		{
			Assert.assertTrue(optOutOptionNewsletterNo.isSelected(), "optOutOptionNewsletterNo not selected");
			Assert.assertTrue(optOutOptionPurchaseReviewsYes.isSelected(), "optOutOptionPurchaseReviewsYes not selected");
			Assert.assertTrue(optInOptionSocialCampaignsNo.isSelected(), "optInOptionSocialCampaignsNo not selected");
		}		
		else
		{
			Assert.assertTrue(optOutOptionNewsletterNo.isSelected(), "optOutOptionNewsletterNo not selected");
			Assert.assertTrue(optOutOptionPurchaseReviewsNo.isSelected(), "optOutOptionPurchaseReviewsNo not selected");
			Assert.assertTrue(optInOptionSocialCampaignsYes.isSelected(), "optInOptionSocialCampaignsYes not selected");
		}
    }

	public void checkBannerDisplayedAfterSave(String user) {
		selectDifferentSelection(user);
		clickSavePreferencesButton();
		Assert.assertEquals(updateMessage.getText(),ContactPreferencesProperties.getUpdateMessage(),"Missing update message");
	}

	public void checkOptionsRestoredAfterRefresh(String user) {
		selectDifferentSelection(user);
		browserRefresh();
		DeviceUtils.waitIfIpad(1000);
		waitForPageLoad();
		if (user.equals("multipleOrders")) {
			Assert.assertTrue(optInOptionNewsletterYes.isSelected(),"optInOptionNewsletterYes not selected");
		}
		else
		{
			Assert.assertTrue(optOutOptionNewsletterNo.isSelected(),"optOutOptionNewsletterNo not selected");
		}
	}

	public void clickSavePreferencesButton() {
		savePreferencesButton.click();
	}

	public void selectDifferentSelection(String user) {
		if (Objects.equals(user, "multipleOrders")) {
			optOutOptionNewsletterNo.click();
		} else {
			optInOptionNewsletterYes.click();
		}
	}

	public void selectDefaultSelection(String user) {
		if (Objects.equals(user, "multipleOrders")) {
			optInOptionNewsletterYes.click();
			optOutOptionPurchaseReviewsNo.click();
			optInOptionSocialCampaignsYes.click();
		} else {
			optOutOptionNewsletterNo.click();
			optInOptionPurchaseReviewsYes.click();
			optOutOptionSocialCampaignsNo.click();
		}
	}
}


