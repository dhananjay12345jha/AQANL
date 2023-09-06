package com.auto.steps;

import com.auto.pages.CommonPage;
import com.auto.pages.MyOrdersPage;
import com.auto.utils.DeviceUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class MyOrdersPageSteps {

	@Autowired
	MyOrdersPage myOrdersPage;

	@Autowired
	CommonPage commonPage;

//	@Then("structure of my order page not compromised")
//	public void checkPageStructureNotCompromised() {
//		myOrdersPage.checkLeftNav();
//		commonPage.verifyMyAccountPageOrders("all");
//	}

	@Then("^structure of my (.*) is not compromised$")
	public void structureOfMyPageIsNotCompromised(String page) {
		myOrdersPage.checkLeftNav();
		if (page.equals("my-account-orders")) {
			commonPage.verifyMyAccountPageOrders("all");
		}
	}

	@Then("click try again link to pull page again")
	public void clickTryAgainBtnAndCheckPage() {
		myOrdersPage.clickTryAgainBtnAndCheckPage();
	}

	@Then("^inflight animation skeleton is displayed$")
	public void checkPageStatus() {
		commonPage.skeletonDisplayed();
	}

	@Then("check the Collection Address details")
	public void checkCollectionAddressDetails() {
		myOrdersPage.checkCollectionAddressDetails();
	}

	@Then("check opening hours and temporary opening hours displayed")
	public void checkOpeningHoursDisplayed() {
		myOrdersPage.openingHoursDisplayed();
		myOrdersPage.tempOpeningHoursDisplayed();
	}

	@Then("verify Collection From contents")
	public void verifyCollectionFromContents() {
		myOrdersPage.checkCollectionTitles();
		myOrdersPage.verifyCollectionFromContents();
	}

    @Then("my Account Side Menu is displayed")
    public void myAccountSideMenuIsDisplayed() {
		myOrdersPage.myAccountMenuLinksDisplayedAsPerSite();
    }

	@And("The contact us button is visible")
	public void theContactUsButtonIsVisible()
	{
		myOrdersPage.isContactUsButtonVisible();
	}

	@When("I click on the contact us button")
	public void iClickOnTheContactUsButton()
	{
		myOrdersPage.clickContactUsButton();
	}

	@Then("check customer facing order status in order detail page")
	public void checkCustomerFacingOrderStatusInOrderDetailPage() {
		myOrdersPage.checkOrderStatusInOrderDetailPage();
	}

	@When("^I click on an order with a (.*) status$")
	public void iClickOnAnOrderWithAStatus(final String deliveryMethod)
	{
		DeviceUtils.waitIfIphone(1000);
		myOrdersPage.clickOrderWithAnyStatusOfDeliveryType(deliveryMethod);
	}

	@When("^I click on an order with the (.*) status$")
	public void iClickOnAnOrderWithTheStatus(final String status)
	{
		DeviceUtils.waitIfIphone(1000);
		DeviceUtils.waitIfIpad(1000);
		myOrdersPage.clickOrderWithStatus(status);
	}

	@Then("^verify Collection Details contents$")
	public void verifyCollectionDetailsContents() {
		myOrdersPage.verifyCollectionDetailsContents();
	}
	
	@Then("Verify purged item not visible and not clickable")
	public void verifyPurgedItem() {
		myOrdersPage.checkPurgedItem();
	}

	@And("Clicking each side menu link takes me to the corresponding account page")
	public void clickingEachSideMenuLinkTakesMeToTheCorrespondingAccountPage()
	{
		myOrdersPage.clickingEachSideMenuLinkTakesMeToTheCorrespondingAccountPage();
	}

}
