package com.auto.steps;

import com.auto.pages.CommonPage;
import com.auto.pages.MyAccountHomePage;
import com.auto.props.MyAccountProperties;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class MyAccountPageSteps {

	@Autowired
	MyAccountHomePage myAccountHomePage;

	@Autowired
	CommonPage commonPage;

	@Then("page displayed with no recent orders")
	public void verifyMyAccountPage() {
		myAccountHomePage.verifyMyAccountPageNoOrders();
	}

	@Then("^page displayed with (recent|all) orders in descending order$")
	public void verifyMyAccountPageOrders(String type) {
		commonPage.verifyMyAccountPageOrders(type);
	}

	@When("user clicks on first view order link")
	public void userClicksOnFirstViewOrderLink() {
		myAccountHomePage.clickFirstViewOrderLink();
	}

	@Then("order details page displayed")
	public void orderDetailsDisplayed() {
		myAccountHomePage.orderDetailsPageDisplayed();
	}

	@And("orders table has order details Columns")
	public void recentOrdersTableHasDesktopColumns() {
		myAccountHomePage.verifyColumns();
	}

	@Then("user is informed of the error and a try again link is displayed")
	public void userIsInformedOfTheErrorAndATryAgainLinkIsDisplayed() {
		myAccountHomePage.errorDisplayedWithRetry();
	}

	@And("dispatched order displayed")
	public void dispatchedOrderDisplayed() {
		myAccountHomePage.dispatchedOrderDisplayed();
	}

    @Then("orders page displayed with no orders with shop now button displayed")
    public void ordersPageDisplayedWithNoOrders() {
		myAccountHomePage.noOrdersDisplayed();
    }

	@When("^user clicks and verifies homepage icons$")
	public void userClicksOnHomepageIconLink(DataTable table) {
		myAccountHomePage.clickAndVerifyHomePageLink(table);
	}

	@And("all homepage links displayed")
	public void allHomepageLinksDisplayed(DataTable table) {
		myAccountHomePage.verifyHomePageLinks(table);
	}
	
	/**
	 * step to check the display of find the store link and new look header
	 */
	@Then("I see the find store text with icon and newlook logo as header along with go to my account text")
	public void checkNewLookLogoAndFindStoreText() {
		myAccountHomePage.verifyLinkAndHeader();
	}
	
	/**
	 * step to click on find the store link and navigate to correct page
	 */
	@When("I click on find store link or icon and navigate to new look store finder page")
	public void clickOnFindStoreLink() {
		myAccountHomePage.clickOnFindStoreLink();
	}
	
	/**
	 * step to click on new look title and navigate to correct page
	 */
	@When("I click on new look title and navigate to new look page")
	public void clickOnNewLookTitle() {
		myAccountHomePage.clickOnNewLookTitle();
	}
	
	/**
	 * step to my address and save point option appears on account page
	 */
	@When("I see the MyAddress and SavedCollectionPoints text on page")
	public void checkTheLinkOnMyAccountPage() {
		myAccountHomePage.checkLink();
	}
	
	@Then("I navigate to search page and I see the text response on the page")
	public void verifyTheResponseOfSearchText() {
		myAccountHomePage.verifyTheResponseOfSearchText();
	}

	@Then("I see My Account links")
	public void iSeeMyAccountLinks() {
		myAccountHomePage.checkMyAccountLinks();
	}

	@When("^I click on the (.*) account link$")
	public void iClickOnTheAccountLink(final String link)
	{
		myAccountHomePage.clickAccountLinkWithText(MyAccountProperties.getLinkName(link));
	}

	@And("orders heading is present")
	public void ordersHeadingIsPresent() {
		myAccountHomePage.ordersHeadingIsPresent();
	}

    @Then("click try again link to pull page again for my-account")
    public void clickTryAgainLinkToPullPageAgainForMyAccount() {
		myAccountHomePage.clickTryAgainBtnAndCheckPage();
    }

    @And("user able to see the title of my-account page")
    public void userAbleToSeeTheTitleOfMyAccountPage() {
		myAccountHomePage.checkTitleInSlowInternet();

    }
}
