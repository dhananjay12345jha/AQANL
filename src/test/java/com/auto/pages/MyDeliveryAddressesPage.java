package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.auto.props.AddressProperties;
import com.auto.utils.LocaleUtils;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import com.automation.core.utilities.assertion.AssertUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyDeliveryAddressesPage extends BasePage
{

	@FindBy(css = "[data-testid='noDataTitle']")
	private ExtWebElement noAddressesSavedMessage;

	@FindBy(css = "[data-testid='noDataBtn']")
	private ExtWebElement noDataBtn;

	@FindBy(css = "[data-testid='pageTitle']")
	private ExtWebElement pageTitle;

	@FindBy(css = "[data-testid='apiErrorMessage']")
	private ExtWebElement errorMsg;
	@FindBy(css = "[data-testid='apiErrorRetryButton']")
	private ExtWebElement tryAgainLink;

	@FindBy(css = "[data-testid='defaultAddressText']")
	private ExtWebElement defaultAddressMessage;

	@FindBy(css = "[data-testid='setDefaultAddressText']")
	private ExtWebElement setAsDefaultAddressButton;

	@FindBy(css="[data-testid='addAddressBtn']")
	private ExtWebElement setAddAddressButton;

	@FindBy(css = "[data-testid^='addressBookItem_']")
	private List<ExtWebElement> addresses;

	@FindBy(css="[data-testid='addressFinderManualBtn']")
	private ExtWebElement addressFinderManualBtn;

	@FindBy(css="[data-testid='addAnotherLine']")
	private ExtWebElement addMoreLinesLink;

	@FindBy(css="[data-testid='testline1-input']")
	private ExtWebElement addressLine1;

	@FindBy(css = "[data-testid='addressBookItemDeleteBtn']")
	private List<ExtWebElement> deleteAddressLinks;

	@FindBy(css = "[data-testid='confirmBox_test']")
	private ExtWebElement deleteAddressPopup;

	@FindBy(css = "[data-testid='confirmBox_test'] h3")
	private ExtWebElement deleteAddressPopupTitle;

	@FindBy(css = "[data-testid='confirmBox_test'] p")
	private ExtWebElement deleteAddressPopupDescription;

	@FindBy(css = "[data-testid='confirmBoxConfirmButton_test']")
	private ExtWebElement deleteAddressPopupConfirmButton;

	@FindBy(css = "[data-testid='confirmBoxCancelButton_test']")
	private ExtWebElement deleteAddressPopupCancelButton;

	@FindBy(css = "[data-testid='confirmBox_test'] [data-testid^='addressBookAddress'] [data-testid$='_name']")
	private ExtWebElement deleteAddressPopupAddressName;

	@FindBy(css = "[data-testid='confirmBox_test'] [data-testid^='addressBookAddress'] [data-testid*='_line']")
	private List<ExtWebElement> deleteAddressPopupAddressLines;

	@FindBy(css = "[data-testid='confirmBox_test'] [data-testid^='addressBookAddress'] [data-testid$='_town']")
	private ExtWebElement deleteAddressPopupAddressTown;

	@FindBy(css = "[data-testid='confirmBox_test'] [data-testid^='addressBookAddress'] [data-testid$='_postalCode']")
	private ExtWebElement deleteAddressPopupAddressPostcode;

	@FindBy(css = "[data-testid='confirmBox_test'] [data-testid^='addressBookAddress'] [data-testid$='_country']")
	private ExtWebElement deleteAddressPopupAddressCountry;

	@FindBy(css = "[id='default-select']")
	private ExtWebElement addressCountryDropdownTitle;

	@FindBy(css = "[data-testid='countrySelect']")
	private ExtWebElement addressCountryDropdown;

	@FindBy(css = "[data-testid='country-select']")
	private ExtWebElement addressCountryDropdownMobile;

	@FindBy(css = "[data-testid='countriesList']")
	private ExtWebElement addressCountryDropdownList;

	@FindBy(css = "[data-testid='addressTitle-label']")
	private ExtWebElement addressTitleLabel;

	@FindBy(css = "[id='mui-component-select-titleCode']")
	private ExtWebElement addressTitleDropdown;

	@FindBy(css = "[data-testid='testfirstName-label']")
	private ExtWebElement firstNameLabel;

	@FindBy(css = "[data-testid='testlastName-label']")
	private ExtWebElement lastNameLabel;

	@FindBy(css = "[data-testid='testfirstName-input']")
	private ExtWebElement firstNameInput;

	private By firstNameInputBy=By.cssSelector("[data-testid='testfirstName-input']");

	@FindBy(css = "[data-testid='testlastName-input']")
	private ExtWebElement lastNameInput;

	@FindBy(css = "[data-testid='testline1-label']")
	private ExtWebElement addressLine1Label;

	@FindBy(css = "[data-testid='testline2-label']")
	private ExtWebElement addressLine2Label;

	@FindBy(css = "[data-testid='testline3-label']")
	private ExtWebElement addressLine3Label;

	@FindBy(css = "[data-testid='testline1-input']")
	private ExtWebElement addressLine1Input;

	@FindBy(css = "[data-testid='testline2-input']")
	private ExtWebElement addressLine2Input;

	@FindBy(css = "[data-testid='testline3-input']")
	private ExtWebElement addressLine3Input;

	@FindBy(css = "[data-testid='testtown-label']")
	private ExtWebElement townCityLabel;

	@FindBy(css = "[data-testid='testtown-input']")
	private ExtWebElement townCityInput;

	@FindBy(css = "[data-testid='testcounty-label']")
	private ExtWebElement countyLabel;

	@FindBy(css = "[data-testid='testcounty-input']")
	private ExtWebElement countyInput;

	@FindBy(css = "[data-testid='testpostalCode-label']")
	private ExtWebElement postalLabel;

	@FindBy(css = "[data-testid='testpostalCode-label'] ~ p span")
	private ExtWebElement postalErrorMessage;

	@FindBy(css = "[data-testid='testpostalCode-input']")
	private ExtWebElement postalInput;

	private By addressLine1InputBy=By.cssSelector("[data-testid='testline1-input']");

	private By addressLine2InputBy=By.cssSelector("[data-testid='testline2-input']");

	private By addressLine3InputBy=By.cssSelector("[data-testid='testline3-input']");

	private By townCityInputBy=By.cssSelector("[data-testid='testtown-input']");

	private By postalInputBy=By.cssSelector("[data-testid='testpostalCode-input']");

	@FindBy(css = "[data-testid='addressFinderBackBtn']")
	private ExtWebElement addressFinderBackLink;

	@FindBy(css = "[data-testid='submit-btn']")
	private ExtWebElement addAddressButton;

	@FindBy(css = "[data-testid='submit-btn']")
	private ExtWebElement editAddressButton;

	@FindBy(css = "[data-testid='cancel-save-address-details-btn']")
	private ExtWebElement cancelButton;

	@FindBy(css = "[data-testid='pageContent'] h4")
	private ExtWebElement subTitle;

	@FindBy(css = "[data-testid='addressFinder-label']")
	private ExtWebElement addressFinderLabel;

	@FindBy(css = "[data-testid='error']")
	private List<ExtWebElement> errors;

	private By errorsBy=By.cssSelector("[data-testid='error']");

	@FindBy(css = "[id='mui-component-select-regionIsoCode']")
	private ExtWebElement provinceDropdown;

	private ExtWebElement label, input;

	@FindBy(css = "[data-testid='countrySelect']")
	private ExtWebElement countrySelect;

	@FindBy(css = "[data-testid='countriesList'] [data-testid^='fr-']")
	private ExtWebElement france;

	@FindBy(css = "[data-testid='countriesList'] [data-testid^='gb-']")
	private ExtWebElement uk;

	@FindBy(css = "[data-testid='country_selector_btn']")
	private ExtWebElement countrySelectorBtn;

	@FindBy(css = "[data-testid='addressFinder-input']")
	private ExtWebElement addressFinderInput;

	@FindBy(css = "[data-testid='addressBookItemEditBtn']")
	private ExtWebElement addressBookItemEditBtn;

	@FindBy(css = "[data-testid='address-form'] h4")
	private ExtWebElement editAddressSubTitle;

	public void checkEmptyAddressPage()
	{
		Assert.assertEquals("No address saved message is displaying",
							PropertyConfig.getValue("addresses.noAddresses.saved.Message"),
							noAddressesSavedMessage.getText());
		Assert.assertTrue(isElementVisible(noDataBtn));
		AssertUtils.assertEqualsIgnoreCase("Add new address button text is incorrect",
										   PropertyConfig.getValue("addresses.addNewAddressButton.visibleText"),
										   noDataBtn.getText());
	}

	public void checkMyDeliveryTitle()
	{
		Assert.assertEquals("No title is displayed",
							PropertyConfig.getValue("address.titleMyAddress"),
							pageTitle.getText());

	}

	public void errorDisplayedWithRetryLink()
	{
		browserRefresh();
		waitForPageLoad();
		untilElementWithTextIsPresent(Duration.ofMillis(600), PropertyConfig.getValue("address.tryAgain.link"));
		AssertUtils.assertContains(errorMsg.getText().replaceAll("\n", ""),
								   PropertyConfig.getValue("address.error.message"));
		AssertUtils.assertContains(tryAgainLink.getText(), PropertyConfig.getValue("address.tryAgain.link"));
	}

	public void clickTryAgainBtn()
	{
		// need to work on this method again since wiremock ticket is still pending and tryagain button is not working,
		//tryAgainLink.click();
	}

	public void thisIsYourDefaultAddressMessageIsVisible()
	{
		Assert.assertTrue(defaultAddressMessage.isVisible());
		Assert.assertEquals(AddressProperties.getDefaultAddressMessage(), defaultAddressMessage.getText());
	}

	public void setAsDefaultAddressButtonIsVisible()
	{
		Assert.assertTrue(setAsDefaultAddressButton.isVisible());
		Assert.assertEquals(AddressProperties.getSetAsDefaultAddressMessage(), setAsDefaultAddressButton.getText());
	}

	public void setAddAddressButtonIsVisible()
	{
		Assert.assertTrue(setAddAddressButton.isVisible());
		Assert.assertEquals(AddressProperties.getAddAddressMessage(), setAddAddressButton.getText().trim());
	}

	public void deleteAddressLinkIsVisibleOnAllAddresses()
	{
		Assert.assertTrue(deleteAddressLinks.stream().allMatch(ExtWebElement::isVisible));
		AssertUtils.assertEqualsIgnoreCase(AddressProperties.getDeleteAddressLink(),
										   deleteAddressLinks.get(0).getText());
		Assert.assertEquals("The number of delete address links does not match the number of addresses",
							addresses.size(),
							deleteAddressLinks.size());
	}

	public void clickDeleteAddressButtonUnderDefaultAddress()
	{
		deleteAddressLinks.get(0).click();
	}

	public void deleteAddressPopupIsVisible()
	{
		final SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(deleteAddressPopup.isVisible(), " * Delete address popup is not visible");
		AssertUtils.assertEqualsIgnoreCase(softAssert,
										   " * Delete address title is incorrect",
										   AddressProperties.getDeleteAddressPopupTitle(),
										   deleteAddressPopupTitle.getText());
		AssertUtils.assertEqualsIgnoreCase(softAssert,
										   " * Delete address popup description is incorrect",
										   AddressProperties.getDeleteAddressPopupDescription(),
										   deleteAddressPopupDescription.getText());
		AssertUtils.assertEqualsIgnoreCase(softAssert,
										   " * Delete address popup confirm button is incorrect",
										   AddressProperties.getDeleteAddressPopupConfirm(),
										   deleteAddressPopupConfirmButton.getText());
		AssertUtils.assertEqualsIgnoreCase(softAssert,
										   " * Delete address popup cancel button is incorrect",
										   AddressProperties.getDeleteAddressPopupCancel(),
										   deleteAddressPopupCancelButton.getText());
		softAssert.assertAll();
	}

	public void deleteAddressPopupIsPopulatedByAddress(final String address)
	{
		final SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(deleteAddressPopupAddressName.getText(), AddressProperties.getAddressName(address));
		AssertUtils.assertListEquals("Some address lines are not correct",
									 AddressProperties.getAddressLines(address),
									 deleteAddressPopupAddressLines.stream()
																   .map(ExtWebElement::getText)
																   .collect(Collectors.toList()));
		softAssert.assertEquals(deleteAddressPopupAddressTown.getText(), AddressProperties.getAddressTown(address));
		softAssert.assertEquals(deleteAddressPopupAddressPostcode.getText(),
								AddressProperties.getAddressPostcode(address));
		softAssert.assertEquals(deleteAddressPopupAddressCountry.getText(),
								AddressProperties.getAddressCountry(address));
		softAssert.assertAll();
	}

	public void clickDeletePopupCancelButton()
	{
		deleteAddressPopupCancelButton.click();
	}

	public void deleteAddressPopupIsNotVisible()
	{
		Assert.assertFalse(isElementVisible(deleteAddressPopup));
	}

    public void clickAddAddressButton() {
		setAddAddressButton.click();
    }

	public void clickAddMoreLinesLink() {
		addMoreLinesLink.click();
	}

	public void clickAddMoreLine3NotDisplayed() {
		Assert.assertFalse(isElementVisible(addressLine3Input));
	}

	public void clickEnterAddressManuallyLink() {
		waitFor(500);
		if (LocaleUtils.getSite().equals("uk")) {
			clickButton(addressFinderManualBtn);
		}
	}

	public void ableToSeeAddAddressInPageForm() {
		Assert.assertTrue(addressLine1.isVisible());
	}

    public void checkTheCountryFieldEditable() {
		Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.country.title"), addressCountryDropdownTitle.getText());
		if (isMobile()) {
			Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.country.defaultValue.mobile"), addressCountryDropdownMobile.findBy(By.cssSelector("option:nth-child(1)")).getText());
			addressCountryDropdownMobile.findBy(By.cssSelector("option:nth-child(3)")).click();
		} else {
			Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.country.defaultValue.desktop"), addressCountryDropdown.getText());
			addressCountryDropdown.click();
			Assert.assertTrue(addressCountryDropdownList.isVisible());
			String albaniaCss="[data-testid='"+PropertyConfig.getValue("addresses.addNew.county.albania.css")+"']";
			find(By.cssSelector(albaniaCss)).click();
		}
    }

	public void checkSubTitleOfMyAddresses() {
		Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.subTitle"), subTitle.getText());
	}

	public void checkFirstNameAndLastNameEditable() {
		Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.firstName.title"), firstNameLabel.getText());
		firstNameInput.sendKeybyKey("1");
		Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.firstName.text")+"1", firstNameInput.getValue());
		Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.lastName.title"), lastNameLabel.getText());
		lastNameInput.sendKeybyKey("2");
		Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.lastName.text")+"2", lastNameInput.getValue());
	}

	public void checkFirstNameAndLastNamePrePopulated() {
		waitFor(500);
		Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.firstName.text"), firstNameInput.getValue());
		Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.lastName.text"), lastNameInput.getValue());
	}

	public void checkAddressLineEditable(int order) {
		switch (order) {
			case 1:
				label = addressLine1Label;
				input = addressLine1Input;
				break;
			case 2:
				label = addressLine2Label;
				input = addressLine2Input;
				break;
			default:
				label = addressLine3Label;
				input = addressLine3Input;
		}
		String property="addressLine"+order;
		checkInputFieldsOfTheAddress(label, input, property);
	}

	public void checkInputFieldsOfTheAddress(ExtWebElement labelElement, ExtWebElement inputElement, String propertyName) {
		String labelProperty="addresses.addNew."+propertyName+".title";
		Assert.assertEquals(PropertyConfig.getValue(labelProperty), labelElement.getText());
		inputElement.sendKeybyKey("test");
		Assert.assertEquals("test", inputElement.getValue());
	}

	public void checkTheTownCityOfTheAddress() {
		checkInputFieldsOfTheAddress(townCityLabel, townCityInput, "townCity");
	}

	public void checkTheCountyOfTheAddress() {
	    //Todo will add below code for uk after error fixed
//		if (LocaleUtils.getSite().equals("uk")) {
//			checkInputFieldsOfTheAddress(countyLabel, countyInput, "county");
//		}
//		else
//		{
			Assert.assertTrue(provinceDropdown.isDisplayed());
//		}
	}

	public void checkThePostcodeOfTheAddress() {
		checkInputFieldsOfTheAddress(postalLabel, postalInput, "postcode");
	}

	public void checkAllMandatoryFields() {
		if(isMobile())
		{
			while(!firstNameInput.getValue().isEmpty()) {
				firstNameInput.sendKeys(new CharSequence[]{Keys.BACK_SPACE});
			}
			firstNameInput.sendKeys(Keys.ARROW_UP);
		}
		else {
			clear(find(firstNameInputBy));
			// this below code added as per new change, proper postal code regex validation will cover on new ticket 581
			clear(find(postalInputBy));			
		}
		addAddressButton.click();
		IntStream.range(0,errors.size()).forEach(i -> Assert.assertEquals(PropertyConfig.getValue("addresses.addNew.mandatory.error"),errors.get(i).getText()));
		firstNameInput.sendKeybyKey(PropertyConfig.getValue("addresses.addNew.firstName.text"));
	}
	

	public void clickBackToAddressSearchAndGoBackToAddressSearch() {
		clickBackToAddressSearchLink();

	}

	public void clickBackToAddressSearchLink()
	{
		addressFinderBackLink.click();
		Assert.assertTrue(addressFinderManualBtn.isDisplayed());
	}

	public void addAddress() {
		setAddAddressButton.click();
	}

	public void chooseCountry(String new_country) {
		countrySelect.click();
		if (new_country.equalsIgnoreCase(PropertyConfig.getValue("address.country.france"))) {
			france.click();
		} else if (new_country.equalsIgnoreCase(PropertyConfig.getValue("address.country.uk"))) {
			uk.click();
		}
	}

	public void checkCountryIsDisplayed(String new_country) {
		Assert.assertEquals("Chosen country is not selected", new_country, countrySelect.getText());
	}

	public void checkCurrentDeliverySite(String country) {
		Assert.assertTrue("Current delivery site is not as expected", countrySelectorBtn.getText().contains(PropertyConfig.getValue("country")));
	}

	public void checkAddressFinder(String new_country) {
		if (new_country.equalsIgnoreCase(PropertyConfig.getValue("address.addressFinder.country"))) {
			Assert.assertTrue("Address Finder is expected but its not found", addressFinderInput.isVisible());
		} else {
			Assert.assertFalse(isElementVisible(addressFinderInput));
		}
	}

	public void clickEditAddressButton() {
		addressBookItemEditBtn.click();
	}

	public void clickEditAddressesButton() {
		editAddressButton.click();
	}

	public void inEditAddressPage() {
		Assert.assertEquals(PropertyConfig.getValue("addresses.edit.subTitle"), editAddressSubTitle.getText());
	}

	public void clickCancelCTA() {
		cancelButton.click();
	}

	public void checkRedirectToPageMyAddressesPage() {
		Assert.assertTrue(setAddAddressButton.isVisible());
	}

	public void checkAllFieldsLimitation() {
		clear(find(addressLine1InputBy));
		checkFieldsLimitation(addressLine1Input,61,2);
		clear(find(addressLine2InputBy));
		checkFieldsLimitation(addressLine2Input,61,3);
		clear(find(addressLine3InputBy));
		checkFieldsLimitation(addressLine3Input,61,4);
		clear(find(townCityInputBy));
		checkFieldsLimitation(townCityInput,51,5);
		clear(find(postalInputBy));
		checkFieldsLimitation(postalInput,11,LocaleUtils.getSite().equals("uk")?6:7);
	}

	public void checkFieldsLimitation(ExtWebElement fieldElement, int limit, int errorIndex)
	{
		String expectedValue="";
		if(errorIndex==6||errorIndex==7)
		{
			expectedValue=PropertyConfig.getValue("addresses.edit.postcode.error");
		}
		else
		{
			expectedValue=PropertyConfig.getValue("addresses.edit.general.error")+" "+(limit-1);
		}
		fieldElement.sendKeybyKey(RandomStringUtils.randomAlphanumeric(limit));
		Assert.assertEquals(expectedValue, errors.get(errorIndex).getText());
	}

	public void clickSetAsDefaultAddressButton()
	{
		Assert.assertTrue(setAsDefaultAddressButton.isVisible());
		setAsDefaultAddressButton.click();
	}
}