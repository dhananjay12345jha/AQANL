package com.auto.steps;

import com.auto.pages.FooterPage;
import com.auto.utils.LocaleUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class FooterSteps {

	@Autowired
	FooterPage footerPage;

	@Then("^the footer links and icons are displayed$")
	public void checkSocialMediaIconsOnFooter() {
		if (footerPage.isMobile()) {
			footerPage.checkAppStoresIcons();
		} else {
			footerPage.checkFooterIconsLinks();
		}
	}

	@Then("verify Top Countries list in Delivery Country field")
	public void checkTopCountriesOnFooter() {
		footerPage.checkTopCountries();
	}

	@Then("^switch to (.*) Delivery Country$")
	public void switchToDifferentDeliveryCountry(String country) {
		footerPage.switchToCountrySuccess(country);
	}

	@When("I open and close delivery country footer popup by clicking outside the popup")
	public void iOpenAndCloseDeliveryCountryFooterButtonWithoutChangingCountry() {
		footerPage.openCloseDeliveryCountryPopupByClickOutside();
	}

	@Then("the delivery country remains same")
	public void theDeliveryCountryRemainsSame() {
		footerPage.checkFooterDeliveryCountry("gb");
	}

	@When("I open and close delivery country footer popup by clicking close popup")
	public void iOpenAndCloseDeliveryCountryFooterPopupByClickingClosePopup() {
		footerPage.openCloseDeliveryCountryPopup();
	}

	@When("^I open delivery country popup and search$")
	public void iOpenDeliveryCountryPopupAndSearchByCharacter() {
		footerPage.openDeliveryCountryPopupAndSearch();
	}

	@Then("^(\\d+) countries are displayed in the country results$")
	public void countriesAreDisplayedInTheCountryResults(int count) {
		footerPage.displayedCountries(count);
	}

	@When("^I (add|append) character '(.*)' to the country search box$")
	public void iAddAnotherCharacterGToTheCountrySearchBox(String action,String c) {
		footerPage.searchDeliveryCountryOnPopup(c, !action.equals("add"));
	}

	@Then("^(.*) country is displayed in the country search$")
	public void bbCountryIsDisplayedInTheCountrySearch(String country) {
		footerPage.verifyDisplayedCountry(country);
	}

	@Then("all countries are displayed in the list")
	public void allCountriesAreDisplayedInTheList() {
		footerPage.allCountriesDisplayed();
	}

	@When("I clear the country search box")
	public void iClearTheCountrySearchBox() {
		footerPage.clearCountrySearchBox();
	}

	@Then("^verify the footer country change to (.*)$")
	public void verifyTheFooterCountryChangeToCountry(String country) {
		footerPage.checkFooterDeliveryCountry(country);
	}

    @And("^Payment types are in an order in the footer$")
    public void paymentTypesAreInAnOrderInTheFooter() {
		footerPage.arePaymentTypesInOrder();
    }

	@And("the key copyright content is displayed")
	public void theKeyCopyrightContentIsDisplayed() {
		footerPage.copyrightDisplayed();
	}

	@Then("^verify the footer links under vertical alignments/columns")
	public void checkFooterLinksOnFooter(){	footerPage.checkFooterLinks();}

	@Then("^verify the bottom footer links$")
	public void checkBottomFooterLinks() { footerPage.checkBottomFooterLinks();	}

	@Then("^select country (.*) from drop down list$")
	public void selectCountry(String country) { footerPage.selectCountry(country);	}

	@Then("^close Delivery Country Selector without confirming$")
	public void closeDeliveryCountrySelector() { footerPage.closeDeliveryCountrySelector();	}

	@Then("^verify (.*) display in Delivery Country field$")
	public void checkCountryDisplayInDeliveryCountryField(String country) {
		footerPage.CountryDisplayInDeliveryCountryField(country);
		footerPage.checkDropdownListCollapsed();
	}

	@Then("check page skeleton structure not compromised")
	public void checkPageSkeletonStructureNotCompromised() {
		footerPage.checkDeliveryCountryPopup();
	}

	@When("I open delivery country popup")
	public void iOpenDeliveryCountryPopup() {
		footerPage.openDeliveryCountryPopup();
	}

	@Then("verify error message display on page")
	public void verifyErrorMessageDisplayOnPage() {
		footerPage.checkErrorMessage();
	}

	@Then("click try again link to updating my delivery country")
	public void clickTryAgainLinkToUpdatingMyDeliveryCountry() {
		footerPage.clickRetryBtn();
	}

	@Then("check page skeleton structure not compromised when page time out")
	public void checkPageSkeletonStructureNotCompromisedWhenPageTimeOut() {
		footerPage.checkDeliveryCountryPopupTimeOut();
	}

	@Then("check page skeleton structure not compromised when page has error")
	public void checkPageSkeletonStructureNotCompromisedWhenPageError() {
		footerPage.checkDeliveryCountryPopupError();
	}

	@Then("check page loading CTA animation")
	public void checkPageLoadingCTA() {
		footerPage.checkPageLoadingCTA();
	}

	@When("^try to change to (.*) Delivery Country$")
	public void tryToChangeToFrDeliveryCountry(String country) {
		footerPage.switchToCountry(country);
	}

	@When("^I change my delivery country to (.*)$")
	public void iChangeMyDeliveryCountryTo(final String country)
	{
		footerPage.switchToCountry(country);
		LocaleUtils.setSite(country);
	}
	
    /**
     * step to check the sign up news letter footer displaying with defined title and description
     */
    @Then("I see a Newsletter sign-up section in the Footer")
    public void newsletterSignUpTitle() {
        this.footerPage.checkTitleNewsletter();
    }

    /**
     * step to check with valid email id user able to navigate to next URL of news letter
     */
    @Then("I am able to enter my valid email address and clicked on signup button successfully")
    public void checkEmailIdEnteredAndSignUpButtonDisplayed() {
        this.footerPage.checkEmailIdEnteredAndSignUpButtonDisplayed();
    }

    /**
     * step to validate error message while entering invalid format email id
     */
    @Then("I am not able to enter the invalid email address and getting error message")
    public void checkInvalidEmailIdDisplayingError() {
        this.footerPage.checkInvalidEmailIdDisplayingError();
    }
    
    /**
     * step to check language displaying in footer
     */
    @Then("I see the language info displaying")
    public void checkLanguageInfo() {
        this.footerPage.checkLanguageInfo();
    }
     
    /**
     * step to check the warning message displaying while country selection pop up appears
     */
    @Then("I see the warning message displaying")
    public void checkWarningMessage() {
        this.footerPage.checkWarningMessage();
    }
}