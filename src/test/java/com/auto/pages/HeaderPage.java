package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.auto.data.TestData;
import com.auto.props.HeaderProperties;
import com.auto.utils.DeviceUtils;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import com.automation.core.utilities.assertion.AssertUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HeaderPage extends BasePage
{
	@FindBy(css = "[data-testid='headerAccountWelcomeText']")
	private ExtWebElement welcomeMessage;

	@FindBy(css = "[data-testid='headerAccountIcon']")
	private ExtWebElement accountIcon;

	@FindBy(css = "[data-testid='headerHoverSpan']")
	private ExtWebElement welcomeMessageAccountIconContainer;

	@FindBy(className = "MuiPaper-root")
	private ExtWebElement miniMenu;

	@FindBy(className = "MuiListItemText-primary")
	private List<ExtWebElement> miniMenuLinks;

	@FindBy(css = "[data-testid='logoutButton']")
	private ExtWebElement miniMenuSignOutButton;

	@FindBy(css = "[data-testid='myAccountOrdersTable']")
	private ExtWebElement myAccountOrdersTable;

	private static final By ORDERS_TABLE_LOCATOR = By.cssSelector("[data-testid='myAccountOrdersList']");

	@FindBy(css = "[data-testid='headerNavigationPlaceholder']")
	private ExtWebElement stickyHeader;

	@FindBy(css = "[data-testid='searchButton']")
	private ExtWebElement searchButton;

	@FindBy(css = "[data-testid='saved-items-button']")
	private ExtWebElement wishlistIcon;

	@FindBy(css = "[data-testid='count-notify_saved-items']")
	private ExtWebElement savedItemsCount;

	@FindBy(css = "[data-testid='count-notify_basket-items']")
	private ExtWebElement cartItemsCount;

	@FindBy(css = "[data-testid='basket-items-button']")
	private ExtWebElement cartItemButton;

	@FindBy(css = "[data-testid='cartIcon']")
	private ExtWebElement cartIcon;

	@FindBy(css = "[data-testid='burgerMenuIcon']")
	private ExtWebElement burgerMenuItem;

	@FindBy(css = "[data-testid='findStoreIconMobile']")
	private ExtWebElement findStoreIconMobile;

	@FindBy(css = "[data-testid='searchInput']")
	private ExtWebElement searchBar;

	@FindBy(css = "[data-testid='search-input-container'] [data-testid='searchButton']")
	private ExtWebElement searchIcon;

	@FindBy(css = "[aria-labelledby='search-modal-title'][aria-describedby='search-modal-msg']")
	private ExtWebElement mobileSearchPopup;

	@FindBy(css = "[data-testid='closeModalIcon']")
	private ExtWebElement closeMobileSearchPopupButton;

	@FindBy(css = "[data-testid='searchMenuItem'] [data-testid='searchButton']")
	private ExtWebElement searchToggle;
	
	@FindBy(css = "[data-testid='searchTermResultList']")
	private ExtWebElement searchTermResultList;

	
	@FindBy(css="[data-testid='searchTermResultList'] > li >a >span")
	private List<ExtWebElement> searchResultList;
	
	@FindBy(css = "[class='search__headline']")
	private ExtWebElement redirectSite;
	
	@FindBy(css = "[class='plp-title']")
	private ExtWebElement redirectSetupKeyword;
	
	@FindBy(css="[data-testid='searchTermResultList'] > li")
	private ExtWebElement searchResultListMobile;
	
	@FindBy(css="[data-testid='recentSearchLabel']")
	private ExtWebElement recentSearchLabel;
	 	
	@FindBy(css="[data-testid='recentSearchClear'] > span")
	private ExtWebElement recentSearchClear;
	
	@FindBy(css="[data-testid='recentSearchListRoot'] > li >a")
	private List<ExtWebElement> recentSearchList;
	
	@FindBy(css="[data-testid='recentSearchListRoot']")
	private ExtWebElement recentSearchListRoot;
	@FindBy(css="[data-testid='headerPromoHeading']")
	private ExtWebElement headerPromoHeading;
	@FindBy(css="[data-testid='headerPromoMessage']")
	private ExtWebElement headerPromoMessage;
	
	
	private String breadcrumbLastNode = null;

	private String mobileBreadcrumbRemovedString = "";

	@Autowired
	TestData testData;

	@FindBy(css = "[data-testid='menuHeaderText']")
	private ExtWebElement MenuBar;
	@FindBy(css = "[data-testid='closeModalIcon']")
	private ExtWebElement CloseButton;
	@FindBy(css = "[data-testid='footerAccountWelcomeText']")
	private ExtWebElement WelcomeMessage;
	@FindBy(css = "[data-testid='footerAccountIconContainer']")
	private ExtWebElement AccountIcon;

	@FindBy(css = ".MuiBox-root > span > a > span")
	private List<ExtWebElement> breadcrumbNames;
	
	@FindBy(css = "[class='MuiInputBase-root MuiOutlinedInput-root Mui-focused Mui-focused']")
	private ExtWebElement searchBarCursorHoverState;

	public void welcomeMessageIsVisible()
	{
		Assert.assertTrue(welcomeMessage.isVisible());
		AssertUtils.assertMatches(HeaderProperties.getWelcomeMessage(),
								  welcomeMessage.getText());
		checkCssValues(headerPromoHeading,"header.promoHeading");
		checkCssValues(headerPromoMessage,"header.promoMessage");
	}

	public void accountIconIsVisible()
	{
		Assert.assertTrue(accountIcon.isVisible());
	}

	public void clickAccountIcon()
	{
		accountIcon.click();
	}

	public void hoverOverWelcomeMessage()
	{
		// Technically we are hovering over the container, so we use that instead
		moveTo(welcomeMessageAccountIconContainer);
		jsMoveTo(welcomeMessageAccountIconContainer);
		checkCssValues(welcomeMessageAccountIconContainer,"header.hoverOverWelcomeMessage");
	}

	public void miniMenuIsVisible()
	{
		Assert.assertTrue(miniMenu.isVisible());
	}

	public void clickMiniMenuLink(final String link)
	{
		jsClick(getMiniMenuLink(link));
	}

	private ExtWebElement getMiniMenuLink(final String link)
	{
		return miniMenuLinks.stream()
							.filter(mml -> mml.getText().equalsIgnoreCase(link))
							.findAny()
							.orElseThrow(() -> new NotFoundException("Mini menu link not found: " + link));
	}

	public void clickMiniMenuSignOutButton()
	{
		jsClick(miniMenuSignOutButton);
	}

	public void checkHeaderIsNotVisibleOnScrollDown() {
		DeviceUtils.waitIfIpad(1000);
		jsExecutor("window.scrollBy(0,document.body.scrollHeight/2)");
		Sleeper.sleep(1000);
		Assert.assertFalse(isElementVisible(stickyHeader));
	}

	public void stickyHeaderIsVisibleOnScrollUp() {
		scrollAndClick(ORDERS_TABLE_LOCATOR);
		Assert.assertTrue(isElementVisible(stickyHeader));
	}


	public void headerElementsArePresent() {
		SoftAssert softly = new SoftAssert();
		softly.assertTrue(cartIcon.isVisible(),"Cart icon is not visible");
		softly.assertTrue(wishlistIcon.isVisible(),"Wishlist icon is not visible");
		softly.assertTrue(searchButton.isVisible(),"Search button is not visible");
		softly.assertTrue(searchBar.isVisible(),"Search input is not visible");
		softly.assertAll();
	}

	public void checkStandardHeaderIsVisibleOnTop() {
		scrollToTop();
		Assert.assertFalse(isElementVisible(stickyHeader));
		headerElementsArePresent();
	}

	public void checkHeaderIsVisibleOnScrollDownOnMobile() {
		jsExecutor("window.scrollBy(0,1000)");
		Assert.assertTrue(isElementVisible(stickyHeader));
	}

	public void checkStandardMobileHeaderIsVisibleOnTop() {
		scrollToTop();
		Assert.assertFalse(isElementVisible(stickyHeader));
		mobileHeaderElementsArePresent();
	}

	private void mobileHeaderElementsArePresent() {
		SoftAssert softly = new SoftAssert();
		softly.assertTrue(burgerMenuItem.isVisible(),"Hamburger icon is not visible");
		softly.assertTrue(searchButton.isVisible(),"Search icon is not visible");
		softly.assertTrue(findStoreIconMobile.isVisible(),"Find store icon is not visible");
		softly.assertTrue(wishlistIcon.isVisible(),"Wishlist icon is not visible");
		softly.assertTrue(cartIcon.isVisible(),"Cart icon is not visible");
		softly.assertAll();
	}

    public void clickOnSavedItemsIcon() {
		wishlistIcon.click();
    }

	public void clickOnCartItemsIcon() {
		cartItemButton.click();
	}

	public void searchBarIsVisible()
	{
		Assert.assertTrue(searchBar.isVisible());
	}

	public void searchBarPlaceholderTextIsVisible()
	{
		Assert.assertEquals(HeaderProperties.getSearchBarPlaceholderText(),
							searchBar.getAttribute("placeholder"));
		checkCssValues(searchBar,"header.searchInputText");
	}

	public void searchIconIsVisible()
	{
		Assert.assertTrue(searchIcon.isVisible());
	}

	public void typeSearchTerm(final String searchTerm)
	{
		if (isMobile() && !isElementVisible(searchBar))
		{
			clickSearchToggle();
			DeviceUtils.waitIfIphone(3000);
		}
		searchBar.sendKeys(searchTerm);
	}

	public void clickSearchIcon()
	{
		searchIcon.click();
	}

	public void searchTermIsVisibleInTheUrl(final String searchTerm)
	{
		waitForPageLoad();
		final String searchTermVariable = "text=" + searchTerm;
		AssertUtils.assertContains(getCurrentUrl(),
								   searchTermVariable);
	}

	public void mobileSearchPopupIsVisible()
	{
		Assert.assertTrue(mobileSearchPopup.isVisible());
	}

	public void closeMobileSearchPopupButtonIsVisible()
	{
		Assert.assertTrue(closeMobileSearchPopupButton.isVisible());
	}

	public void searchFor(final String searchTerm)
	{
		if (isMobile())
		{
			clickSearchToggle();
			DeviceUtils.waitIfIphone(2000);
		}
		typeSearchTerm(searchTerm);
		clickSearchIcon();
	}

	public void searchToggleIsVisible()
	{
		Assert.assertTrue(searchToggle.isVisible());
	}

	public void clickSearchToggle()
	{
		searchToggle.click();
	}

	public void clickSearchToggleIfVisible()
	{
		if (isElementVisible(searchToggle))
		{
			clickSearchToggle();
		}
	}

	public void clickSearchIconWithoutTyping()
	{
		searchFor("");
	}

	public void savedIconContainsNumberOfItems(String count) {
		Assert.assertEquals(savedItemsCount.getText(), count, "items count do not match");
	}

	public void cartIconContainsNumberOfItems(String count) {
		Assert.assertEquals(cartItemsCount.getText(), count, "items count do not match");
	}

	public void checkMyBagIconLinkedToCartPage(String page) {
		clickOnCartItemsIcon();
		DeviceUtils.waitIfIphone(1000);
		Assert.assertTrue(getDriver().getCurrentUrl().contains(page), "The link of cart icon is incorrect.");
		browserBack();
	}

	public void savedItemsCounterShouldNotBePresent() {
		Assert.assertFalse(isElementVisible(savedItemsCount));
	}

	public void myBagCounterShouldNotBePresent() {
		Assert.assertFalse(isElementVisible(cartItemsCount));
	}

	public void checkSearchTermResultList()
	{
		if (isMobile())
		{
			Assert.assertFalse(isElementVisible(searchResultListMobile));
			DeviceUtils.waitIfIphone(2000);
		} else {		
		    Assert.assertFalse(isElementVisible(searchTermResultList));
		}
		browserRefresh();

	}
	
	public String resultList(String expectedSearchOptionToClick, List<ExtWebElement> extWebElement, String countList)
	{	
			String stringAutoSearchOptionList = "";
			int listCount = 0;
			// below  wait condition code is required or not we will check once search functionality will work on CICD till that time commented it
			//waitForCondition().until(ExpectedConditions.visibilityOf(searchResultListMobile));
			for (ExtWebElement web : extWebElement)
			{
				if (stringAutoSearchOptionList.equals(""))
				{
					stringAutoSearchOptionList = web.getText().replaceAll("\n", "");
					AssertUtils.assertContains(stringAutoSearchOptionList , expectedSearchOptionToClick);
					
				}
				else
				{
					stringAutoSearchOptionList = (!web.getText().replaceAll("\n", "").trim().equals(""))
						? stringAutoSearchOptionList + "," + web.getText().replaceAll("\n", "").trim() : stringAutoSearchOptionList + "";
					AssertUtils.assertContains(stringAutoSearchOptionList , expectedSearchOptionToClick);
					
				}
				listCount++;
			}
			if (listCount <= Integer.parseInt(countList)) {}
			else {
				throw new ArithmeticException();
			}
			return stringAutoSearchOptionList;		
		}	
	
	public void checkSearchTermResultListDisplaying()
	{
		waitForCondition().until(ExpectedConditions.visibilityOf(searchTermResultList));
		Assert.assertTrue(isElementVisible(searchTermResultList));
		resultList(PropertyConfig.getValue("header.click.on.auto.option"), searchResultList, PropertyConfig.getValue("header.searched.suggested.list.count"));
	}
	
	public void checkSearchTermRedirectResultListDisplaying()
	{
		waitForCondition().until(ExpectedConditions.visibilityOf(searchTermResultList));
		Assert.assertTrue(isElementVisible(searchTermResultList));
		resultList(PropertyConfig.getValue("header.search.term.searchTermRedirectSetup"), searchResultList, PropertyConfig.getValue("header.searched.suggested.list.count"));
	}
	
	public void clickOnAutoSuggestedOption()
	{
		clickOnAutoSuggestedOption(PropertyConfig.getValue("header.click.on.auto.option"), searchResultList);

	}
	
	public void clickOnAutoSuggestedOption(String expectedSearchOptionToClick, List<ExtWebElement> extWebElement)
	{
		waitForPageLoad();
		String stringHeaderText = "";
		// below  wait condition code is required or not we will check once search functionality will work on CICD till that time commented it
		//waitForCondition().until(ExpectedConditions.visibilityOf(searchResultListMobile));
		for (ExtWebElement web : extWebElement)
		{
			if (stringHeaderText.equals(""))
			{
				if (web.getText().replaceAll("\n", "").equals(expectedSearchOptionToClick)) {
					
					web.click();
				}	
				
				break;
			}

		}
	}
		
	public void checkRedirectSiteIsCorrect(String expectedSearchOptionToClick)
	{
		DeviceUtils.waitIfIphone(1000);
		waitForPageLoad();
		Assert.assertEquals(getCurrentUrl(), expectedSearchOptionToClick);
	}
	
	
	public void checkRedirectSetupKeyword()
	{
		waitForPageLoad();
		Assert.assertEquals(redirectSetupKeyword.getText(), PropertyConfig.getValue("header.redirect.setup.keyword"));
	}


	public void verifySignOut() {
		Assert.assertTrue(getCurrentUrl().contains("newlook.com/"+testData.getSite()));
	}

	public void checkSignOutNofification() {
//		Add step for signout message when implemented
//		Assert.assertEquals(redirectSetupKeyword.getText(), PropertyConfig.getValue("signout.notification"));
	}
	public void clickOnHamburgerMenu()
	{
		burgerMenuItem.click();
	}
	public void menuHeaderBarIsVisible()
	{
		Assert.assertTrue(MenuBar.isVisible());

	}
	public void closeSignIsVisible()
	{
		Assert.assertTrue(CloseButton.isVisible());

	}
	public void welcomeMessageAndAccountIconIsVisible()
	{
		Assert.assertTrue(WelcomeMessage.isVisible());
		Assert.assertTrue(AccountIcon.isVisible());

	}
	public void welcomeMessageAndAccountIconClose()
	{
		WelcomeMessage.click();


	}
	public void closeButtonClick() {
		CloseButton.click();
	}

	public void breadcrumbLinkIsVisible(final String link) {
		Sleeper.sleep(1000);
		AssertUtils.assertContainsIgnoreCase(getVisibleBreadcrumbLinks(), link);
	}

	public void clickBreadcrumbLink(final String link)
	{
		breadcrumbLinks.stream()
					   .filter(breadcrumb -> breadcrumb.getText().equalsIgnoreCase(link))
					   .findAny()
					   .orElseThrow(() -> new NotFoundException("No breadcrumb link found: " + link))
					   .click();
		waitForPageLoad();
	}

	public void checkBreadcrumbLinkDisplayOrder(String expectedBreadcrumb) {
		List<String> expectedLinks;
		if (isMobile()) {
//			For mobile and tablets the breadcrumb is shortened like .../my orders/HY XXXX and hence this logic
			expectedLinks = Stream.of(expectedBreadcrumb.split("/")).skip(2).collect(Collectors.toList());
			IntStream.range(0, expectedLinks.size() - 1).forEach(i -> Assert.assertTrue(expectedLinks.get(i).trim().equals(getVisibleBreadcrumbLinks().get(i + 1)), "The expected breadcrumb " + expectedLinks.get(i + 1).trim() + " not same as " + getVisibleBreadcrumbLinks().get(i)));
		} else {
			expectedLinks = Stream.of(expectedBreadcrumb.split("/")).collect(Collectors.toList());
			IntStream.range(0, expectedLinks.size() - 1).forEach(i -> Assert.assertTrue(expectedLinks.get(i).trim().equals(getVisibleBreadcrumbLinks().get(i)), "The expected breadcrumb " + expectedLinks.get(i).trim() + " not same as " + getVisibleBreadcrumbLinks().get(i)));
		}
	}

	public void checkRecentSearches()
	{		
		Assert.assertEquals(recentSearchLabel.getText(), PropertyConfig.getValue("header.recentSearchLabel"));
		recentSearchClear.isDisplayed();
		resultList(PropertyConfig.getValue("header.click.on.recentSearch.option"), recentSearchList, PropertyConfig.getValue("header.recent.searched.list.count"));
	}
	
	public void clickOnRecentSearchListOption()
	{
		clickOnAutoSuggestedOption(PropertyConfig.getValue("header.click.on.recentSearch.option"), recentSearchList);
	}
	
	public void clickOnSearchbar() {
	if (isMobile()){
			clickSearchToggle();
			DeviceUtils.waitIfIphone(3000);
	    }
		searchBar.click();
	}
	
	public void clickOnClearLink() {
		waitForCondition().until(ExpectedConditions.visibilityOf(recentSearchClear));
		clickButton(recentSearchClear);
	}
	
	public void noRecentSearchListDisplay() {	
		Assert.assertFalse(isElementVisible(recentSearchListRoot));
		Assert.assertFalse(isElementVisible(recentSearchClear));
	}	
	
	public void recentSearchListDisplay() {	
		Assert.assertTrue(isElementVisible(recentSearchListRoot));
		Assert.assertTrue(isElementVisible(recentSearchClear));
	}
	
	public void clickHoverStateOfSearchbar() {	
		Assert.assertTrue(isElementVisible(searchBarCursorHoverState));
	}
	
	public void searchbarNoHoverState() {	
		Assert.assertFalse(isElementVisible(searchBarCursorHoverState));
	}

	public void checkKeyAttributesSetForEachPages(String page) {
		waitForPageLoad();
		untilElementWithTextIsPresent(Duration.ofMillis(600), PropertyConfig.getValue("header.pageTitle."+page));
		Assert.assertEquals(getDriver().getTitle(), PropertyConfig.getValue("header.pageTitle."+page));
	}
}
