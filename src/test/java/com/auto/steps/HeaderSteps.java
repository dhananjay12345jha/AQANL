package com.auto.steps;

import com.auto.config.PropertyConfig;
import com.auto.pages.HeaderPage;
import com.auto.props.HeaderProperties;
import com.auto.utils.DeviceUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class HeaderSteps {
	@Autowired
	private HeaderPage headerPage;

	@And("The header welcome message is visible")
	public void theHeaderWelcomeMessageIsVisible() {
		headerPage.welcomeMessageIsVisible();
	}

	@And("The account icon is visible")
	public void theAccountIconIsVisible() {
		headerPage.accountIconIsVisible();
	}

	@When("I click on the account icon")
	public void iClickOnTheAccountIcon() {
		headerPage.clickAccountIcon();
	}

	@When("I hover over the header welcome message")
	public void iHoverOverTheHeaderWelcomeMessage() {
		headerPage.hoverOverWelcomeMessage();
	}

	@Then("The header mini menu is visible")
	public void theHeaderMiniMenuIsVisible() {
		headerPage.miniMenuIsVisible();
	}

	@When("^I click on the mini menu (.*) link$")
	public void iClickOnTheMiniMenuLink(final String link) {
		headerPage.clickMiniMenuLink(HeaderProperties.getMiniMenuLink(link));
	}

	@And("I click on the mini menu sign out button")
	public void iClickOnTheMiniMenuSignOutButton() {
		headerPage.clickMiniMenuSignOutButton();
	}

	@When("I scroll down the header is not visible")
	public void iScrollDownTheHeaderIsNotVisible() {
		headerPage.checkHeaderIsNotVisibleOnScrollDown();
	}

	@And("I scroll up the sticky header should be visible")
	public void iScrollUpTheStickyHeaderShouldBeVisible() {
		headerPage.stickyHeaderIsVisibleOnScrollUp();
	}

	@When("I scroll down the sticky header is visible")
	public void iScrollDownTheStickyHeaderIsVisible() {
		headerPage.checkHeaderIsVisibleOnScrollDownOnMobile();
	}

	@And("I scroll to the top of the page the standard mobile header should be visible")
	public void iScrollToTheTopOfThePageTheStandardMobileHeaderShouldBeVisible() {
		headerPage.checkStandardMobileHeaderIsVisibleOnTop();
	}

	@When("I click on the saved items icon on header")
	public void iClickOnTheSavedItemsIconOnHeader() {
		headerPage.clickOnSavedItemsIcon();
	}

	@And("The search bar is visible")
	public void theSearchBarIsVisible() {
		DeviceUtils.waitIfIphone(2000);
		headerPage.searchBarIsVisible();
	}

	@And("The search bar placeholder text is visible")
	public void theSearchBarPlaceholderTextIsVisible() {
		headerPage.searchBarPlaceholderTextIsVisible();
	}

	@And("The search icon is visible")
	public void theSearchIconIsVisible() {
		headerPage.searchIconIsVisible();
	}

	@When("^I type a (.*) search term into the search bar$")
	public void iTypeASearchTermIntoTheSearchBar(final String term) {
		headerPage.typeSearchTerm(HeaderProperties.getSearchTerm(term));
	}

	@And("I click on the search icon")
	public void iClickOnTheSearchIcon() {
		headerPage.clickSearchIcon();
	}

	@Then("^My (.*) search term is visible in the URL$")
	public void mySearchTermIsVisibleInTheURL(final String term) {
		DeviceUtils.waitIfIphone(2000);
		DeviceUtils.waitIfSafari(2000);
		DeviceUtils.waitIfIpad(2000);
		headerPage.searchTermIsVisibleInTheUrl(HeaderProperties.getSearchTerm(term));
	}

	@And("The mobile search popup is visible")
	public void theMobileSearchPopupIsVisible() {
		headerPage.mobileSearchPopupIsVisible();
	}

	@And("The close mobile search popup button is visible")
	public void theCloseMobileSearchPopupButtonIsVisible() {
		headerPage.closeMobileSearchPopupButtonIsVisible();
	}

	@When("^I search for a (.*) search term$")
	public void iSearchForASearchTerm(final String searchTerm) {
		headerPage.searchFor(HeaderProperties.getSearchTerm(searchTerm));
	}

	@And("The search toggle is visible")
	public void theSearchToggleIsVisible() {
		headerPage.searchToggleIsVisible();
	}

	@When("I click on the search toggle")
	public void iClickOnTheSearchToggle() {
		headerPage.clickSearchToggle();
	}

	@When("I click on the search toggle if visible")
	public void iClickOnTheSearchToggleIfVisible() {
		headerPage.clickSearchToggleIfVisible();
	}

	@Then("I have NOT type into the search field and click on the search button")
	public void clickOnSearchButton() {
		headerPage.clickSearchIconWithoutTyping();
	}

	@When("I clicked on hamburger menu from the header")
	public void clickHambergerMenu() {
		headerPage.clickOnHamburgerMenu();

	}

	@Then("I can see the Menu at the top in header bar")
	public void visibilityOfMenuHeader() {
		headerPage.menuHeaderBarIsVisible();
	}

	@Then("the header Menu is having option to close")
	public void headerOptionClose() {
		headerPage.closeSignIsVisible();

	}

	@Then("I can see the welcome message and the account icon")
	public void visibityOfWelcomeMessageAndAccountIcon() {
		headerPage.welcomeMessageAndAccountIconIsVisible();
	}

	@When("I click on welcome message and account icon")
	public void clickOnWelcomeIcon() {
		headerPage.welcomeMessageAndAccountIconClose();

	}

	@When("I click on the close option")
	public void closeButtonClick() {
		headerPage.closeButtonClick();
	}

		@Then("^I should see the saved items icon with the counter (.*) displayed$")
		public void iShouldSeeTheSavedItemsIconWithTheCounterValueDisplayed (String number){
			headerPage.savedIconContainsNumberOfItems(number);
		}

		@Then("I should not see any counter on the saved item icon")
		public void iShouldNotSeeAnyCounterOnTheSavedItemIcon () {
			headerPage.savedItemsCounterShouldNotBePresent();
		}

		@Then("I see no auto suggested terms displayed")
		public void checkSearchTermResultList ()
		{
			headerPage.checkSearchTermResultList();
		}

		@Then("I see auto suggested terms displayed")
		public void checkSearchTermResultListDisplaying ()
		{
			headerPage.checkSearchTermResultListDisplaying();
		}

		@Then("I see redirect auto suggested terms displayed")
		public void checkSearchTermRedirectResultListDisplaying ()
		{
			headerPage.checkSearchTermRedirectResultListDisplaying();
		}

		@Then("I click on with out redirect option from auto suggested option")
		public void selectOnAutoSuggestedOption ()
		{
			headerPage.clickOnAutoSuggestedOption();
		}

		@Then("I am redirect to expected result page")
		public void checkRedirectIsCorrect ()
		{
			headerPage.checkRedirectSiteIsCorrect(PropertyConfig.getValue("header.redirect.site"));
		}

		@Then("I am redirect to expected PLP or PDP page")
		public void checkRedirectSetupKeyword ()
		{
			headerPage.checkRedirectSetupKeyword();
		}

		@Then("I click on with redirect setup option from auto suggested option")
		public void selectRedirectAutoSuggestedOption ()
		{
			headerPage.clickOnAutoSuggestedOption();
		}

		@And("I have been signed out")
		public void iHaveBeenSignedOut () {
			headerPage.verifySignOut();
		}

		@And("I scroll to the top of the page the standard header elements should be visible")
		public void iScrollToTheTopOfThePageTheStandardHeaderElementsShouldBeVisible () {
			headerPage.checkStandardHeaderIsVisibleOnTop();
		}

		@And("The signed out notification is visible")
		public void theSignedOutNotificationIsVisible () {
			headerPage.checkSignOutNofification();
		}

	@And("^The (.*) breadcrumb link is visible$")
	public void theBreadcrumbLinkIsVisible(final String link)
	{
		headerPage.breadcrumbLinkIsVisible(HeaderProperties.getBreadcrumbLink(link));
	}

	@Then("^I see My Bag icon with the counter (.*) displayed$")
	public void checkMyBagIconWithTheCounterValueDisplayed (String number){
		headerPage.cartIconContainsNumberOfItems(number);
	}

	@Then("I should not see any counter on the My Bag icon")
	public void checkNotSeeAnyCounterOnTheMyBagIcon () {
		headerPage.myBagCounterShouldNotBePresent();
	}

	@When("^I click on the (.*) breadcrumb link$")
	public void iClickOnTheBreadcrumbLink(final String link)
	{
		headerPage.clickBreadcrumbLink(HeaderProperties.getBreadcrumbLink(link));
	}

	@Then("^verify breadcrumb display as (.*)$")
	public void verifyBreadcrumbOrderNumber(String expectedBreadcrumb) {
		headerPage.checkBreadcrumbLinkDisplayOrder(expectedBreadcrumb);
	}

	@Then("^click My Bag icon and verify linked to (.*) page$")
	public void clickMyBagIconAndVerifyLinkedToCartPage(String page) {
		headerPage.checkMyBagIconLinkedToCartPage(page);
	}
	
	@Then("I see the recent search list")
	public void checkRecentSearchesDisplaying ()
	{
		headerPage.checkRecentSearches();
	}
	
	@Then("I click on recent searched list option")
	public void clickonSearchBarAndSeeRecentSearchList ()
	{
		headerPage.clickOnRecentSearchListOption();
	}

	@Then("I see expected result page for recent search")
	public void checkRecentSearchRedirectIsCorrect ()
	{
		headerPage.checkRedirectSiteIsCorrect(PropertyConfig.getValue("header.redirect.site.recentSearch"));
	}
	
	@When("I click on search bar")
	public void clickOnSearchbar()
	{
		headerPage.clickOnSearchbar();
	}
	
	@Then("I see the cursor blink in search box in hover state")
	public void clickHoverStateOfSearchbar()
	{
		headerPage.clickHoverStateOfSearchbar();
	}
	
	@When("I click on clear link for recent search")
	public void clickOnClearLink ()
	{
		headerPage.clickOnClearLink();
	}
	
	@Then("I see there is no recent search list and clear link display")
	public void noRecentSearchListDisplay ()
	{
		headerPage.noRecentSearchListDisplay();
	}
	
	@Then("I see there is recent search list and clear link display")
	public void recentSearchListDisplay ()
	{
		headerPage.recentSearchListDisplay();
	}
	
	@Then("I see no cursor blink in search box and its not in hover state")
	public void searchbarNoHoverState ()
	{
		headerPage.searchbarNoHoverState();
	}
@Then("^check key attributes set for (.*) page on the SPA site$")
	public void checkKeyAttributesSetForEachPageOnTheSPASite(String page) {
		headerPage.checkKeyAttributesSetForEachPages(page);
	}
}
