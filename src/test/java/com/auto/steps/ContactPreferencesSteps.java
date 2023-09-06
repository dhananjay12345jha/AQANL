package com.auto.steps;

import com.auto.config.PropertyConfig;
import com.auto.pages.CommonPage;
import com.auto.pages.ContactPreferencePage;
import com.auto.pages.HeaderPage;
import com.auto.props.ContactPreferencesProperties;
import com.auto.props.HeaderProperties;
import com.auto.utils.DeviceUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactPreferencesSteps {
	@Autowired
	private ContactPreferencePage contactPreferencePage;

	@Autowired
	CommonPage commonPage;

	@When("^i click on privacy policy link$")
	public void clickOnPrivacyPolicyLink() throws Throwable {
      contactPreferencePage.clickPrivacyPolicyLink();
	}
	@Then("^i am able to see the title of Contact Preferences page$")
	public void contactPreferencesPageTitle(){
		contactPreferencePage.checkTitle();
	}
	@And("^i am able to see the summary of Contact Preferences page$")
	public void summeryContactPreferencePage(){
		contactPreferencePage.checkSummary();
	}

	@Then("^I see the  Privacy Policy help page$")
	public void privacyPolicyHelpPage(){
      contactPreferencePage.checkPrivacyPolicyHelpPage();

	}

	@And("^i am able to see the T&Cs for contact preferences page$")
	public void tcContactPreferencePage(){
		contactPreferencePage.termAndCondition();
	}

	@And("^i can see the privacy policy link$")
	public void visibilityOfPrivacyPolicyPage() throws Throwable {
		contactPreferencePage.checkPrivacyLink();
	}
	@Then("^i am able to see the Email Newsletter title, description and optin options$")
	public void emailTitleDesOptValidation(){
		contactPreferencePage.checkEmailNewsTitleDescOpt();
	}

	@Then("^i am able to see the Post Purchase Product Reviews title, description and optin options$")
	public void postPurchaseTitleDesOptValidation() throws Throwable {
		contactPreferencePage.checkPostPurchaseProductNewsTitleDescOpt();

	}

	@Then("^i am able to see the Social Campaigns title, description and optin options$")
	public void socialCampaignTitleDesOptValidation() throws Throwable {
        contactPreferencePage.checkSocialCampaignNewsTitleDescOpt();
	}


    @Then("^check default select options for user (.*)$")
    public void checkDefaultSelectOptions(String user) {
		contactPreferencePage.checkDefaultSelectOptions(user);
    }

	@Then("^check banner displayed after click save button for user (.*)$")
	public void checkBannerDisplayedAfterClickSaveButton(String user) {
		contactPreferencePage.checkBannerDisplayedAfterSave(user);
	}

	@Then("^check options restored after page refresh for user (.*)$")
	public void checkOptionsRestoredAfterPageRefresh(String user) {
		contactPreferencePage.checkOptionsRestoredAfterRefresh(user);
	}

    @Then("click Save Preferences button")
    public void clickSavePreferencesButton() {
		contactPreferencePage.clickSavePreferencesButton();
    }

	@Then("^select different selection for user (.*)$")
	public void selectDifferentSelectionInPagePageForUserUser(String user) {
		contactPreferencePage.selectDifferentSelection(user);
	}

	@Then("^select default selection for user (.*)$")
	public void selectDefaultSelectionInPagePageForUser(String user) {
		contactPreferencePage.selectDefaultSelection(user);
	}

	@Then("click Save Preferences button with slow internet connection")
	public void clickSavePreferencesButtonSlow() {
		commonPage.setNetworkSpeedTo3G();
		contactPreferencePage.clickSavePreferencesButton();
	}
}
