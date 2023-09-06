package com.auto.steps;

import com.auto.config.PropertyConfig;
import com.auto.pages.MyDeliveryAddressesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class MyDeliveryAddressesPageSteps {

	@Autowired
	MyDeliveryAddressesPage myDeliveryAddressesPage;

	@Then("I see the empty address page and add address button")
	public void checkEmptyAddressPage() {
		myDeliveryAddressesPage.checkEmptyAddressPage();
	}

	@And("^user able to see  My Address title$")
	public void userAbleToSeeTitle() {
		myDeliveryAddressesPage.checkMyDeliveryTitle();
	}

	@Then("^user is informed of the error and a try again link is displayed on page$")
	public void userIsInformedOfTheErrorAndATryAgainLinkIsDisplayed(){

		myDeliveryAddressesPage.errorDisplayedWithRetryLink();

	}
	@Then("^click try again link to pull MyaddressPage again$")
	public void clickTryAgainBtnAndCheckPage() {
		myDeliveryAddressesPage.clickTryAgainBtn();
	}


	@Then("The this is your default address message is visible")
	public void theThisIsYourDefaultAddressMessageIsVisible()
	{
		myDeliveryAddressesPage.thisIsYourDefaultAddressMessageIsVisible();
	}

	@And("The set as default address button is visible")
	public void theSetAsDefaultAddressButtonIsVisible()
	{
		myDeliveryAddressesPage.setAsDefaultAddressButtonIsVisible();
	}

	@And("The Add Address button is visible")
	public void theAddAddressButtonIsVisible() {
		myDeliveryAddressesPage.setAddAddressButtonIsVisible();

	}

	@And("The delete address link is visible on all addresses")
	public void theDeleteAddressLinkIsVisibleOnAllAddresses()
	{
		myDeliveryAddressesPage.deleteAddressLinkIsVisibleOnAllAddresses();
	}

	@When("I click on the delete address button under my default address")
	public void iClickOnTheDeleteAddressButtonUnderMyDefaultAddress()
	{
		myDeliveryAddressesPage.clickDeleteAddressButtonUnderDefaultAddress();
	}

	@Then("The delete address popup is visible")
	public void theDeleteAddressPopupIsVisible()
	{
		myDeliveryAddressesPage.deleteAddressPopupIsVisible();
	}

	@And("The delete address popup is populated with my default address")
	public void theDeleteAddressPopupIsPopulatedWithMyDefaultAddress()
	{
		myDeliveryAddressesPage.deleteAddressPopupIsPopulatedByAddress("default");
	}

	@When("I click on the cancel button on the delete address popup")
	public void iClickOnTheCancelButtonOnTheDeleteAddressPopup()
	{
		myDeliveryAddressesPage.clickDeletePopupCancelButton();
	}

	@Then("The delete address popup is not visible")
	public void theDeleteAddressPopupIsNotVisible() {
		myDeliveryAddressesPage.deleteAddressPopupIsNotVisible();
	}

    @When("^user chooses to add new address with (.*)$")
    public void userChoosesToAddNewAddressWithNew_country(String new_country) {
		myDeliveryAddressesPage.addAddress();
		myDeliveryAddressesPage.chooseCountry(PropertyConfig.getValue(new_country));
    }

	@Then("^the Add address form is updated with (.*)$")
	public void theAddAddressFormIsUpdatedWithNewCountry(String new_country) {
		myDeliveryAddressesPage.checkCountryIsDisplayed(PropertyConfig.getValue(new_country));
	}

	@And("^current delivery (.*) is not changed$")
	public void currentDeliverySiteIsNotChanged(String country) {
		myDeliveryAddressesPage.checkCurrentDeliverySite(country);

	}

	@And("^Address finder search field is not present if (.*) is not UK$")
	public void addressFinderSearchFieldIsNotPresentIfNewCountryIsNotUK(String new_country) {
		myDeliveryAddressesPage.checkAddressFinder(PropertyConfig.getValue(new_country));
	}


	@When("click add address button")
	public void clickAddAddressButton() {
		myDeliveryAddressesPage.clickAddAddressButton();
	}

	@When("click enter address manually link")
	public void clickEnterAddressManuallyLink() {
		myDeliveryAddressesPage.clickEnterAddressManuallyLink();
	}

	@Then("able to see ‘Add Address’ in page form")
	public void ableToSeeAddAddressInPageForm() {
		myDeliveryAddressesPage.ableToSeeAddAddressInPageForm();
	}

	@And("^check the Country field is mandatory and editable pre-populated with current Country$")
	public void checkTheCountryFieldIsMandatoryAndEditablePrePopulatedWithCountrySite() {
		myDeliveryAddressesPage.checkTheCountryFieldEditable();
	}

	@And("check the Title, First Name and Last Name as a mandatory and editable fields pre-populated")
	public void checkTheTitleFirstNameAndLastNameAsAMandatoryAndEditableFieldsPrePopulated() {
		myDeliveryAddressesPage.checkMyDeliveryTitle();
		myDeliveryAddressesPage.checkSubTitleOfMyAddresses();
		myDeliveryAddressesPage.checkFirstNameAndLastNamePrePopulated();
		myDeliveryAddressesPage.checkFirstNameAndLastNameEditable();
	}

	@And("check the Address Line {int} of the address")
	public void checkTheAddressLineOfTheAddressAsAMandatoryField(int order) {
		myDeliveryAddressesPage.checkAddressLineEditable(order);
	}

	@And("check the Town City of the address")
	public void checkTheTownCityOfTheAddress() {
		myDeliveryAddressesPage.checkTheTownCityOfTheAddress();
	}

	@And("check the County of the address")
	public void checkTheCountyOfTheAddress() {
		myDeliveryAddressesPage.checkTheCountyOfTheAddress();
	}

	@And("check the Postcode of the address")
	public void checkThePostcodeOfTheAddress() {
		myDeliveryAddressesPage.checkThePostcodeOfTheAddress();
	}

	@And("check able to select and add another address line")
	public void checkAbleToSelectAndAddAnotherAddressLine() {
		myDeliveryAddressesPage.clickAddMoreLine3NotDisplayed();
		myDeliveryAddressesPage.clickAddMoreLinesLink();
		myDeliveryAddressesPage.checkAddressLineEditable(3);
	}

	@And("check all mandatory fields")
	public void checkAllMandatoryFields() {
		//Todo: Will update this part once bug fixed
		myDeliveryAddressesPage.checkAllMandatoryFields();
	}

	@And("click Back to address search and go back to address search")
	public void clickBackToAddressSearchAndGoBackToAddressSearch() {
		myDeliveryAddressesPage.clickBackToAddressSearchAndGoBackToAddressSearch();
	}

    @When("click edit address button to enter Edit Address page")
    public void clickEditAddressButton() {
		myDeliveryAddressesPage.clickEditAddressButton();
		myDeliveryAddressesPage.inEditAddressPage();
    }

	@When("click edit addresses button in Edit Address page")
	public void clickEditAddressesButtonInEditAddressPage() {
		myDeliveryAddressesPage.clickEditAddressesButton();
	}

	@Then("click Cancel CTA and redirect to page My Addresses page")
	public void clickCancelCTAAndRedirectToPageMyAddressesPage() {
		myDeliveryAddressesPage.clickCancelCTA();
		myDeliveryAddressesPage.checkRedirectToPageMyAddressesPage();
	}

	@Then("check all fields limitation")
	public void checkAllFieldsLimitation() {
		myDeliveryAddressesPage.clickAddMoreLinesLink();
		myDeliveryAddressesPage.checkAllFieldsLimitation();
	}

	@When("user click on Set as default address button")
	public void userClickOnSetAsDefaultAddressButton() {
		myDeliveryAddressesPage.clickSetAsDefaultAddressButton();

	}
}