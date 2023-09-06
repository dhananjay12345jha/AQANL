package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.auto.enums.BottomFooterLinks;
import com.auto.enums.CountryCode;
import com.auto.enums.FooterLinks;
import com.auto.props.FooterProperties;
import com.auto.utils.DeviceUtils;
import com.auto.utils.DurationUtil;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import com.automation.core.utilities.assertion.AssertUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FooterPage extends BasePage {


	@FindBy(css = "[data-testid='social-app-links-title']")
	private ExtWebElement beSocialTitle;

	@FindBy(css = "[data-testid='social-app-links-subtitle']")
	private ExtWebElement joinTheConversationTitle;

	@FindBy(css = "[data-testid='icon_facebook']")
	private ExtWebElement facebookIcon;

	@FindBy(css = "[data-testid='icon_instagram']")
	private ExtWebElement instagramIcon;

	@FindBy(css = "[data-testid='icon_pinterest']")
	private ExtWebElement pinterestIcon;

	@FindBy(css = "[data-testid='icon_twitter']")
	private ExtWebElement twitterIcon;

	@FindBy(css = "[data-testid='icon_youtube']")
	private ExtWebElement youtubeIcon;
	@FindBy(css = "[data-testid='app-links-title']")
	private ExtWebElement appLinksTitle;

	@FindBy(css = "[data-testid='icon_google_store']")
	private ExtWebElement googleStoreIcon;

	@FindBy(css = "[data-testid='icon_apple_store']")
	private ExtWebElement appleStoreIcon;

	@FindBy(css = "[data-testid='countrySelectorModal'] div label" )
	private ExtWebElement deliveryCountryPopupTitle;

	@FindBy(css = "[data-testid='closeModalIcon']" )
	private ExtWebElement deliveryCountryPopupCloseBtn;

	@FindBy(css = "[data-testid='countrySelect']" )
	private ExtWebElement countryDropDown;

	@FindBy(css = "[data-testid='country-select']" )
	private ExtWebElement countryDropDownMobile;

	@FindBy(css = "[data-testid='country-select'] option" )
	private List<ExtWebElement> countryDropDownMobileOptions;

	@FindBy(css = "[data-testid='country-select'] option:nth-child(1)" )
	private ExtWebElement countryDropDownMobileText;

	private By  noteHeadingText = By.cssSelector("[data-testid='noteHeading'] h6" );

	@FindBy(css = "[data-testid='countrySelectorModal']" )
	private ExtWebElement coutrySelectModal;

	@FindBy(css = "[data-testid='countrySelectorModal']" )
	private ExtWebElement countrySelectPopup1;

	private By countrySelectPopup = By.cssSelector("[data-testid='countrySelectorModal']");

	private By findOutMoreLink= By.cssSelector("[data-testid='findOutMoreLink'] a");

	@FindBy(css = "[data-testid='changeSettings']")
	private ExtWebElement changeSettingBtn;

	@FindBy(css = "[data-testid='country_selector_btn']")
	private ExtWebElement countrySelectorBtn;

	private By countrySearchInput = By.cssSelector("input[data-testid='countrySearchInput']");

	@FindBy(css="[data-testid='countriesList'] li")
	private List<ExtWebElement> countriesListRows;

	@FindBy(css="[data-testid='country-select'] option")
	private List<ExtWebElement> countriesListRowsMobile;

	@FindBy(css="[data-testid='countriesList'] li")
	private ExtWebElement countriesList;

	@FindBy(css="[data-testid='bb-3']")
	private ExtWebElement countryBbBtn;

	@FindBy(css="[data-testid='closeModalIcon']")
	private ExtWebElement closeDeliveryCountryPopup;

	@FindBy(css="[data-testid='changeSettings']")
	private ExtWebElement changeSettingsButton;

	@FindBy(css="[data-testid='paymentLogoWrapper'] div")
	private List<ExtWebElement> payment_types;

	@FindBy(css="ul[data-testid='footerLinkListUL'] li:nth-child(1)")
	private ExtWebElement copyRightFooter;

	private final String countrySelection = "[data-testid*='%s']";

	private final String countrySelectionMobile = "[data-testid='country-select'] option[value='%s']";

//	@FindBy(css = "[data-testid='linkList'] ul li [href]")
//	private List<ExtWebElement> allLinkListUrlList;
	@FindBy(css = "[data-testid='linkList'] ul li a")
	private List<ExtWebElement> allLinkListUrlList;

	@FindBy(css = "[data-testid='footerLinkList'] ul li")
	private List<ExtWebElement> allBottomFooterLinkList;

	@FindBy(css="[data-testid='linkList']")
	private List<ExtWebElement> linkListColumns;

	@FindBy(css = "[data-testid='footerLinkList'] ul li a")
	private List<ExtWebElement> otherBottomFooterLinkUrlList;

	@FindBy(css="[data-testid='showMoreIcon']")
	private List<ExtWebElement> showMoreIcons;

	@FindBy(css="[data-testid='showMoreIcon'] svg g g g line")
	private List<ExtWebElement> verticalLines;

	@FindBy(css="[data-testid='apiErrorMessage'] div div span")
	private ExtWebElement apiErrorMessageTitle;

	@FindBy(css="[data-testid='apiErrorMessage']:nth-child(1) div div span")
	private ExtWebElement apiErrorMessageTitleMobile;

	@FindBy(css="[data-testid='apiErrorMessage'] div ul li")
	private List<ExtWebElement> apiErrorMessages;

	@FindBy(css="[data-testid='apiErrorMessage']:nth-child(1) div ul li")
	private List<ExtWebElement> apiErrorMessagesMobile;

	@FindBy(css="[data-testid='apiErrorRetryButton'] span")
	private ExtWebElement apiErrorRetryButton;

	@FindBy(css="[data-testid='apiErrorMessage']:nth-child(1) button")
	private ExtWebElement apiErrorRetryButtonMobile;

	@FindBy(css="[data-testid='loader']")
	private ExtWebElement loaderImage;
	
    @FindBy(css = "[data-testid='newsletterHeading']")
    private ExtWebElement newsLetterHeader;

    private By newsLetterHeaderBy = By.cssSelector("[data-testid='newsletterHeading']");

    @FindBy(css = "[data-testid='newsletterHelperText']")
    private ExtWebElement newsLetterDescription;

    @FindBy(css = "[data-testid='newsletterInput']")
    private ExtWebElement newsLetterEmailInput;

    private By newsLetterEmailInputBy = By.cssSelector("[data-testid='newsletterInput']");

    @FindBy(css = "[data-testid='newsletterButton']")
    private ExtWebElement newsLetterSignUpButton;

    @FindBy(css = "[data-testid='newsletterError']")
    private ExtWebElement newsletterErrorMessage;
    
    @FindBy(css = "[data-testid='noteHeading']+p")
    private ExtWebElement warningMessage;
       
    @FindBy(css = "[data-testid='findOutMoreLink']")
    private ExtWebElement findOutMoreLinkMessage;

	public void checkFooterIconsLinks() {

		SoftAssert softly = new SoftAssert();
		softly.assertEquals(beSocialTitle.getText(), PropertyConfig.getValue("footer.title.beSocial"), "Be Social title missing");
		softly.assertEquals(joinTheConversationTitle.getText(), PropertyConfig.getValue("footer.title.joinTheConversation"),"Join the conversation title missing");

		softly.assertEquals(facebookIcon.getAttribute("target"), "_blank","Click facebook icon links will not open in a new tab.");
		softly.assertEquals(facebookIcon.getAttribute("href"), PropertyConfig.getValue("url","facebooklink"),"Click facebook icon links url not correct.");

		softly.assertEquals(instagramIcon.getAttribute("target"), "_blank","Click instagram icon links will not open in a new tab.");
		softly.assertEquals(instagramIcon.getAttribute("href"), PropertyConfig.getValue("url","instagramLink"),"Click instagram icon links url not correct.");

		softly.assertEquals(pinterestIcon.getAttribute("target"), "_blank","Click pinterest icon links will not open in a new tab.");
		softly.assertEquals(pinterestIcon.getAttribute("href"), PropertyConfig.getValue("url","pinterestLink"),"Click pinterest icon links url not correct.");

		softly.assertEquals(twitterIcon.getAttribute("target"), "_blank","Click twitter icon links will not open in a new tab.");
		softly.assertEquals(twitterIcon.getAttribute("href"), PropertyConfig.getValue("url","twitterLink"),"Click twitter icon links url not correct.");

		softly.assertEquals(youtubeIcon.getAttribute("target"), "_blank","Click youtube icon links will not open in a new tab.");
		softly.assertEquals(youtubeIcon.getAttribute("href"), PropertyConfig.getValue("url","youtubeLink"),"Click youtube icon links url not correct.");
		softly.assertAll();
	}

	public void checkAppStoresIcons() {
		scrollToBottom();
		SoftAssert softly = new SoftAssert();
		softly.assertTrue(appLinksTitle.getText().equals("Get the App"), "Get the App title missing.");
		softly.assertTrue(googleStoreIcon.getAttribute("href").equals(PropertyConfig.getValue("url","googleStoreLink")),"Google store url not correct.");
		softly.assertTrue(appleStoreIcon.getAttribute("href").equals(PropertyConfig.getValue("url","appleStoreLink")),"Apple store link url not correct.");
		softly.assertAll();
	}

	public void checkTopCountries() {
		openDeliveryCountryPopup();
		checkDeliveryCountryPopup();
		Assert.assertTrue(coutrySelectModal.findBy(findOutMoreLink).isPresent());
		if (isMobile()) {
			countryDropDownMobile.click();
		} else {
			jsClick(countryDropDown);
		}

		final String actualCountry;

		if (isMobile())
		{
			actualCountry = countryDropDownMobileOptions.stream()
														.filter(ExtWebElement::isSelected)
														.map(ExtWebElement::getText)
														.findFirst()
														.orElse("");
		}
		else
		{
			actualCountry = countryDropDown.getText();
		}
//		allCountriesDisplayed();
		Assert.assertEquals(PropertyConfig.getValue("country"), actualCountry);
	}

	public void checkDeliveryCountryPopup() {
		SoftAssert softly = new SoftAssert();
		softly.assertEquals(deliveryCountryPopupTitle.getText(), PropertyConfig.getValue("footer.deliveryCountryTitle"),"Delivery country pop up title not correct.");
		softly.assertTrue(deliveryCountryPopupCloseBtn.isVisible(),"Delivery country pop up close button is missing.");
		AssertUtils.assertEqualsIgnoreCase(softly, "change setting btn name not correct.", PropertyConfig.getValue("footer.changeSettings"), changeSettingBtn.getText());
		softly.assertEquals(coutrySelectModal.findBy(noteHeadingText).getText(), PropertyConfig.getValue( "footer.noteHeading"));
		softly.assertEquals(coutrySelectModal.findBy(By.cssSelector("p")).getText(), PropertyConfig.getValue("footer.deliveryCountryInfo"));
		softly.assertAll();
	}

	public void checkDeliveryCountryPopupTimeOut() {
		if (!isMobile())
		{
			SoftAssert softly = new SoftAssert();
			softly.assertEquals(deliveryCountryPopupTitle.getText(), PropertyConfig.getValue( "footer.deliveryCountryTitle"),"Delivery country pop up title not correct.");
			softly.assertTrue(deliveryCountryPopupCloseBtn.isVisible(),"Delivery country pop up close button is missing.");
			softly.assertEquals(coutrySelectModal.findBy(noteHeadingText).getText(), PropertyConfig.getValue( "footer.noteHeading"));
			softly.assertEquals(coutrySelectModal.findBy(By.cssSelector("p")).getText(),PropertyConfig.getValue( "footer.deliveryCountryInfo"));
			softly.assertAll();
			countrySelectPopup1.waitUntilNotVisible(DurationUtil.LONG2SEC);
		}
	}

	public void checkDeliveryCountryPopupError() {
		Assert.assertEquals("Delivery country pop up title not correct.", PropertyConfig.getValue("footer.deliveryCountryTitle"), deliveryCountryPopupTitle.getText());
	}

	public void allCountriesDisplayed(){
		List<String> actualCountriesList = (isMobile()?countriesListRowsMobile:countriesListRows).stream().map(WebElement::getText).collect(Collectors.toList());
		List<String> expectedCountriesList = Stream.of(PropertyConfig.getValue( "countriesList").split(",")).collect(Collectors.toList());
		actualCountriesList.remove(actualCountriesList.indexOf("Croatia") + 1);
		expectedCountriesList.remove(expectedCountriesList.indexOf("Croatia") + 1);
//		Assert.assertTrue("\n   actualCountriesList is:"+actualCountriesList + "\n expectedCountriesList is:"+expectedCountriesList,actualCountriesList.containsAll(expectedCountriesList));
	}

	public void checkFooterDeliveryCountry(String country){
		untilElementWithTextIsPresent(Duration.ofMillis(600), CountryCode.getLanguage(CountryCode.valueOf(country)));		
		AssertUtils.assertContains(countrySelectorBtn.getText(),CountryCode.getCountry(CountryCode.valueOf(country)));
		AssertUtils.assertContains(countrySelectorBtn.getText(),CountryCode.getLanguage(CountryCode.valueOf(country)));
		AssertUtils.assertContains(countrySelectorBtn.getText(),CountryCode.getCurrency(CountryCode.valueOf(country)));
	}

	public void openDeliveryCountryPopup()
	{
		scrollToBottom();
		jsClick(countrySelectorBtn);
	}
	public void openCloseDeliveryCountryPopupByClickOutside()
	{
		checkFooterDeliveryCountry("gb");
		openDeliveryCountryPopup();
		coutrySelectModal.sendKeys(Keys.ESCAPE);
	}

	public void openCloseDeliveryCountryPopup()
	{
		checkFooterDeliveryCountry("gb");
		openDeliveryCountryPopup();
		closeDeliveryCountryPopup.click();
	}

	public By switchToCountrySuccess(String country)
	{
		By countrySelectionBySuccess = switchToCountry(country);
//		waitTillCountrySelectPopupInvisible();
		return countrySelectionBySuccess;
	}

	public By switchToCountry(String country)
	{
		By countrySelectionBy = By.cssSelector(String.format(isMobile() ? countrySelectionMobile : countrySelection,
															 country));
		if (isMobile())
		{
			click(countrySelectionBy);
		}
		else
		{
			jsClick(countrySelectionBy);
		}
		jsClick(changeSettingBtn);
		return countrySelectionBy;
	}

	public void waitTillCountrySelectPopupInvisible()
	{
		if(isElementPresent(countrySelectPopup))
			coutrySelectModal.waitUntilNotVisible(DurationUtil.LONG1SEC);
	}

	public void searchDeliveryCountryOnPopup(String c, boolean appendSearchText) {
		sentKeys(countrySearchInput, c, appendSearchText);
	}

	public void openDeliveryCountryPopupAndSearch()
	{
		jsClick(countrySelectorBtn);

		if (isMobile())
		{
			waitForCondition().until(ExpectedConditions.visibilityOf(countryDropDownMobile));
			countryDropDownMobile.click();
		}
		else
		{
			waitForCondition().until(ExpectedConditions.visibilityOf(countryDropDown));
			countryDropDown.click();
		}
	}

	public void displayedCountries(int count) {
		if(count==0){
			Assert.assertEquals(countriesListRows.get(0).getText(),PropertyConfig.getValue( "footer.noCountryFound"));
			count++;
		}
		Assert.assertEquals(count,countriesListRows.size());
	}

	public void verifyDisplayedCountry(String country) {
		Assert.assertEquals(country, countriesListRows.get(0).getText());
	}

	public void clearCountrySearchBox() {
		jsMoveTo(countrySearchInput);
		clear(find(countrySearchInput));
//		while(find(countrySearchInput).getText().length()>0){
//			find(countrySearchInput).sendKeys(Keys.BACK_SPACE);
//		}
	}

	public void arePaymentTypesInOrder() {
		final List<String> expectedPaymentTypes = Arrays.asList(PropertyConfig.getValue( "payment.types").split(","));
		final List<String> actualPaymentTypes = payment_types.stream().map(p -> p.getAttribute("id")).collect(Collectors.toList());
		Assert.assertEquals(expectedPaymentTypes, actualPaymentTypes);

	}

	public void copyrightDisplayed() {
		String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		Assert.assertTrue(copyRightFooter.getText().contains(PropertyConfig.getValue( "footer.copyright").replace("year", currentYear)));
	}

	public void checkFooterLinks(){
		scrollToBottom();
		if(isMobile())
		{
			checkHeadingsCollapsed();
			clickAllPlusSymbol();
			checkHeadingsExpanded();
			clickAllPlusSymbol();
			checkHeadingsCollapsed();
			clickAllPlusSymbol();
		}
		else
		{
			checkFooterColumnStructure();
		}
		checkColumnsVerticalAligned();
		checkFooterLinksUrls();
	}

	public void checkFooterLinksUrls()
	{
		//List<String> actualFooterLinksUrlList = allLinkListUrlList.stream().map(link -> link.getAttribute("href")).collect(Collectors.toList());
		List<String> actualFooterLinksUrlList = allLinkListUrlList.stream().map(ExtWebElement::getText).collect(Collectors.toList());

		System.out.println(actualFooterLinksUrlList);
		IntStream.range(0,actualFooterLinksUrlList.size()).forEach(i->Assert.assertFalse("Footer links Url"+actualFooterLinksUrlList.get(i)+" is empty",actualFooterLinksUrlList.get(i).isEmpty()));
		List<String> expectedFooterLinksUrlList = Stream.of(FooterLinks.values()).map(FooterLinks::getUrl).map(s->s.replace("/","")).collect(Collectors.toList());
		System.out.println("---------"+ expectedFooterLinksUrlList);
		Assert.assertEquals("Footer links URLs are part missing.", actualFooterLinksUrlList.size(), expectedFooterLinksUrlList.size());
	}
	public void checkColumnsVerticalAligned(){
		IntStream.range(0,linkListColumns.size()).forEach(i -> Assert.assertTrue("All links in all columns are not in vertical aligned.", linkListColumns.get(i).findElements(By.cssSelector("ul li a span")).stream().allMatch(row -> row.getLocation().getX()==linkListColumns.get(i).findElements(By.cssSelector("ul li a span")).get(0).getLocation().getX())));
	}

	public void checkFooterColumnStructure(){
		Assert.assertTrue("All footer columns not structured under headings.", linkListColumns.stream().allMatch(column -> column.getLocation().getY()==linkListColumns.get(0).getLocation().getY()));
	}
	public void checkHeadingsCollapsed()
	{
		IntStream.range(0,showMoreIcons.size()).forEach(i -> Assert.assertTrue("Some link headings are not collapsed.", showMoreIcons.get(i).findElements(By.cssSelector("svg g g g")).stream().anyMatch(item -> item.findElements(By.cssSelector("line:nth-child(2)")).size()>0)));
	}

	public void checkHeadingsExpanded()
	{
		IntStream.range(0,showMoreIcons.size()).forEach(i -> Assert.assertTrue("Some + symbol cannot click and expanded.", showMoreIcons.get(i).findElements(By.cssSelector("svg g g g")).stream().anyMatch(item -> item.findElements(By.cssSelector("line:nth-child(2)")).size()==0)));
	}

	public void clickAllPlusSymbol()
	{
		IntStream.range(0,showMoreIcons.size()).forEach(i -> showMoreIcons.get(i).click());
	}

	public void checkBottomFooterLinks(){
		scrollToBottom();
		if(isMobile()) {
			checkBottomFooterLinksMobile();
		}
		else
		{
			checkBottomFooterHorizontalAlign();
			checkBottomFooterLinksUrl();
		}
	}

	public void selectCountry(String country)
	{
		By countrySelectionBy = By.cssSelector(String.format(isMobile()?countrySelectionMobile:countrySelection, country));
		scrollAndClick(countrySelectionBy);
	}

	public void CountryDisplayInDeliveryCountryField(String country)
	{
		Assert.assertEquals("The selected country "+country+" not display in the Delivery Country field.",country, countryDropDown.getText());
	}

	public void checkDropdownListCollapsed(){
		Assert.assertFalse("Dropdown list not collapsed.", coutrySelectModal.findElements(By.cssSelector("div:nth-child(3) div:nth-child(1) div:nth-child(1)")).size()>2);
	}

	public void checkBottomFooterHorizontalAlign()
	{
		Assert.assertTrue("All bottom footer links not horizontal alignment.", allBottomFooterLinkList.stream().allMatch(column -> column.getLocation().getY()==allBottomFooterLinkList.get(0).getLocation().getY()));
	}

	public void checkBottomFooterLinksUrl()
	{
		List<String> actualOthersBottomFooterLinksUrlList = otherBottomFooterLinkUrlList.stream().map(link -> link.getAttribute("href")).collect(Collectors.toList());
		IntStream.range(0,actualOthersBottomFooterLinksUrlList.size()).forEach(i->Assert.assertFalse("Bottom footer links Url"+actualOthersBottomFooterLinksUrlList.get(i)+" is empty",actualOthersBottomFooterLinksUrlList.get(i).isEmpty()));
		List<String> expectedOthersBottomFooterLinksUrlList = Stream.of(BottomFooterLinks.values()).map(BottomFooterLinks::getUrl).collect(Collectors.toList());
		Assert.assertEquals("Others bottom footer links urls are incorrect.", actualOthersBottomFooterLinksUrlList.size(), expectedOthersBottomFooterLinksUrlList.size());
	}

	public void checkBottomFooterLinksMobile(){
		final int x = allBottomFooterLinkList.get(0).getLocation().getX();
		final int linkWidth = allBottomFooterLinkList.get(0).getSize().getWidth();
		final int leftmostPixel = x - linkWidth / 2;

		Assert.assertTrue("The footer links are not left-aligned.",
						  leftmostPixel < 3);
	}

	public void closeDeliveryCountrySelector()
	{
		deliveryCountryPopupCloseBtn.click();
	}

	public void clickRetryBtn()
	{
		apiErrorRetryButton.click();
	}

	public void checkErrorMessage(){
		Sleeper.sleep(1500);
		Assert.assertFalse("Missing error message title. ", isMobile()? apiErrorMessageTitleMobile.getText().isEmpty():apiErrorMessageTitle.getText().isEmpty());
		IntStream.rangeClosed(0,1).forEach(i->Assert.assertFalse("Missing error messages. ", isMobile()?apiErrorMessagesMobile.get(i).getText().isEmpty():apiErrorMessages.get(i).getText().isEmpty()));
		Assert.assertFalse("Missing try again link.", isMobile()?apiErrorRetryButtonMobile.getText().isEmpty():apiErrorRetryButton.getText().isEmpty());
	}

	public void checkPageLoadingCTA(){
		Assert.assertTrue("Missing loader image", loaderImage.isDisplayed());
	}
	
    /**
     * method to check the sign up news letter footer displaying with defined title and description
     */
    public void checkTitleNewsletter() {
        waitForPageLoad();
        scrollToBottom();
        untilPresent(Duration.ofMillis(1000), newsLetterHeaderBy);
		Sleeper.sleep(1000);
        Assert.assertEquals("Sign up to our newsletter header displaying in footer", PropertyConfig.getValue("footer.headerNewsletter"), newsLetterHeader.getText());
        Assert.assertEquals("Be the first to hear about the latest trends, new arrivals and exclusive offers. You can unsubscribe at any time is displaying in footer as description", PropertyConfig.getValue("footer.descriptionNewsletter"), newsLetterDescription.getText());
    }

    /**
     * method to check with valid email id user able to navigate to next URL of news letter
     */
    public void checkEmailIdEnteredAndSignUpButtonDisplayed() {
        scrollToBottom();
        newsLetterEmailInput.clear();
        newsLetterEmailInput.sendKeys(PropertyConfig.getValue("footer.newsletterSignUpEmailId"));
        Assert.assertEquals("Sign up button is displaying", PropertyConfig.getValue("footer.signUpButtonText"), newsLetterSignUpButton.getText());
        clickButton(newsLetterSignUpButton);
        DeviceUtils.waitIfIphone(3000);
        DeviceUtils.waitIfIpad(3000);
        waitForPageLoad();
        AssertUtils.assertContains(getCurrentUrl(), PropertyConfig.getValue("footer.signedUpURL"));
        AssertUtils.assertContains(getCurrentUrl(), PropertyConfig.getValue("footer.signedUpURLEmail"));
        AssertUtils.assertContains(getCurrentUrl(), PropertyConfig.getValue("footer.signedUpURLSourceSite"));
        AssertUtils.assertContains(getCurrentUrl(), PropertyConfig.getValue("footer.signedUpURLStatus"));
        AssertUtils.assertContains(getCurrentUrl(), PropertyConfig.getValue("footer.signedUpURLSource"));
        AssertUtils.assertContains(getCurrentUrl(), PropertyConfig.getValue("footer.signedUpURLLatestSource"));
    }

    /**
     * method to validate error message while entering invalid format email id
     */
    public void checkInvalidEmailIdDisplayingError() {
        waitForPageLoad();
        scrollToBottom();
        untilPresent(Duration.ofMillis(1000), newsLetterEmailInputBy);
        newsLetterEmailInput.sendKeys(PropertyConfig.getValue("footer.newsletterSignUpInvalidEmailId"));
        clickButton(newsLetterSignUpButton);
        DeviceUtils.waitIfIphone(1000);
        Assert.assertEquals("Sign up error message is displaying", FooterProperties.getNewsletterSignUpErrorMessage(), newsletterErrorMessage.getText());
    }
    
	/**
	 * method to check language displaying in footer
	 */
	public void checkLanguageInfo()
	{
	   waitForPageLoad();
	   scrollToBottom();
	   untilElementWithTextIsPresent(Duration.ofMillis(500), PropertyConfig.getValue("footer.languageInfo"));
	   AssertUtils.assertContains(countrySelectorBtn.getText(), (PropertyConfig.getValue("footer.languageInfo")));
	}
	
	/**
	 * method to check the warning message displaying while country selection pop up appears
	 */
	public void checkWarningMessage()
	{
	   scrollToBottom();
	   clickButton(countrySelectorBtn);
       Assert.assertEquals("Warning message is displaying", PropertyConfig.getValue("footer.warningMessage"), warningMessage.getText());
       Assert.assertEquals("find Out more link message is displaying", PropertyConfig.getValue("footer.findOutMoreLinkMessage"), findOutMoreLinkMessage.getText());
	}
}