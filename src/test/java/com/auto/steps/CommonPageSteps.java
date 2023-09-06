package com.auto.steps;

import com.auto.config.PropertyConfig;
import com.auto.data.TestData;
import com.auto.pages.CommonPage;
import com.auto.props.UrlProperties;
import com.auto.props.UserProperties;
import com.auto.utils.LocaleUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonPageSteps {

    @Autowired
    CommonPage commonPage;

    @Autowired
    TestData testData;

    @When("^user navigates to (.*) page$")
    public void iNavigateToPagePage(String page) {
        iNavigateToPageOnSiteAsUser(page, LocaleUtils.DEFAULT_SITE,"multipleOrders");
    }

    @When("^user navigates to (.*) page on (.*) site$")
    public void iNavigateToPageOnSite(String page, String site) {
        iNavigateToPageOnSiteAsUser(page, site,"multipleOrders");
    }

    @When("^user navigates to (.*) page on (.*) site as user with (.*)$")
    public void iNavigateToPageOnSiteAsUser(String page, String site, String userType) {
        testData.setSite(site);
        LocaleUtils.setSite(site);
        if (!page.equals("homepage") && !page.equals("pdppage") ){
            iLogInAsAUserWithMultipleOrders(userType);
        }
        commonPage.openPage(page, site, userType);
    }

    @When("^user navigates to (.*) page with slow internet connection$")
    public void userNavigatesToMyAccountPageWithSlowInternetConnection(String page) {
        testData.setSite(LocaleUtils.DEFAULT_SITE);
        LocaleUtils.setSite(LocaleUtils.DEFAULT_SITE);
        iLogInAsAUserWithMultipleOrders("multipleOrders");
        commonPage.setNetworkSpeedTo3G();
        commonPage.openPage(page, "uk");
    }

    @When("^user navigates to (.*) page as user with (.*)$")
    public void userNavigatesToPageAsUser(String page, String userType) {
        iNavigateToPageOnSiteAsUser(page, LocaleUtils.DEFAULT_SITE,userType);
    }

    @When("^user navigates to (.*) page from mobile$")
    public void iNavigateToMobilePage(String page) {
        commonPage.openMobilePage(page);
    }

    @Then("^verify user on the (.*) site$")
    public void checkUrlSiteInfo(String site)
    {
        commonPage.checkUrlSiteInfo(site);
    }

    @And("I get pageoffset")
    public void iGetPageoffset() {
        testData.setOffset(commonPage.getPageYOffset());
    }

    @And("verify pageoffset")
    public void verifyPageoffset() {
        Assert.assertEquals(testData.getOffset(), commonPage.getPageYOffset());
    }

    @Then("^External (.*) URL is opened$")
   	public void externalURLIsOpened(final String urlId)
   	{
   	    commonPage.waitForPageLoad();
   		Assert.assertEquals(PropertyConfig.getValue("url", urlId), commonPage.getCurrentUrl());
   	}

    @Then("^verify user on website (.*)")
    public void checkUrlInfo(String url)
    {
        commonPage.waitForPageLoad();
        Assert.assertEquals(PropertyConfig.getValue(url), commonPage.getCurrentUrl());
    }

    public void iLogInAsAUserWithMultipleOrders(String userType)
    {
        commonPage.setJsessionCookie(UserProperties.getJsessionId(userType));
    }

    @But("^the site has issues with the order on page (.*)$")
    public void theSiteHasIssuesWithTheOrder(String page) {
        commonPage.blockSiteUrl("errorResponse.urlToBlock."+page);
    }
    
    @But("^the site has issues with change setting footer on page (.*)$")
    public void theSiteHasIssuesWithChangeSettingFooter(String page) {
        commonPage.blockSiteUrl("errorResponse.changeSetting.urlToBlock."+page);
    }
    
    @But("the site has payment cards page issue")
    public void theSiteaHasNoPaymentCards() {
        commonPage.blockSiteUrl("errorResponsePaymentCardsPage.urlToBlock");
    }
    
	@Then("^I am on the (.*) page$")
	public void iAmOnThePage(final String page)
	{
		commonPage.iAmOnThePage(UrlProperties.getUrlProperty(page));
	}

    @Then("the saved items page slides open as side panel")
    public void theSavedItemsPageSlidesOpenAsSidePanel() {
        commonPage.checkSidePanelOpens();
    }

    @And("the side panel is closed when closed")
    public void theSidePanelIsClosedWhenClosed() {
        commonPage.sidePanelCloses();
    }

    @Then("The {int} error page is visible")
   	public void theErrorPageIsVisible(final int code)
   	{
   		commonPage.errorPageIsVisible(code);
   	}

	@When("^I append (.*) to the current URL$")
	public void iAppendToTheCurrentURL(final String appended)
	{
		commonPage.waitForPageLoad();
		commonPage.goTo(commonPage.getCurrentUrl() + appended);
	}
	
    @But("the site has issues with the recent searches")
    public void theSiteHasIssuesWithTheRecentSearchesr() {
        commonPage.blockSiteUrl("errorResponse.urlRecentSearchToBlock");
    }

    @And("page has slow internet connection issue")
    public void pageHasSlowInternetConnectionIssue() {
        commonPage.setNetworkSpeedTo3G();
    }

    @And("refresh page")
    public void refreshPage() {
        commonPage.browserRefresh();
    }

    @But("the site having issue with loading details on my-account page")
    public void theSiteHavingIssueWithLoadingDetailsOnMyAccountPage() {
        commonPage.blockSiteUrl("errorResponse.urlToBlock.my-accounts");
    }
}