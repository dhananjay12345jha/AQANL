package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.auto.data.TestData;
import com.auto.props.SiteProperties;
import com.auto.props.UrlProperties;
import com.auto.utils.CookieUtils;
import com.auto.utils.DeviceUtils;
import com.auto.utils.LocaleUtils;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import com.automation.core.utilities.assertion.AssertUtils;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v91.network.Network;
import org.openqa.selenium.devtools.v91.network.model.ConnectionType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.auto.props.UrlProperties.getUrlProperty;


@PropertySource("file:src/test/resources/env/${env:dev}.properties")
public class CommonPage extends BasePage {

    private static final By LOADING_SPINNER_LOCATOR = By.cssSelector("[class*='MuiCircularProgress-svg']");

    @Autowired
    TestData testData;

    @Value("#{systemProperties['hostName']}")
    protected String baseURL;

    @FindBy(css="[data-testid='title']")
    private List<ExtWebElement> recentOrderHeader;

    @FindBy(css="[data-testid='viewMyOrdersButton']")
    private ExtWebElement viewMyOrdersButton;

    @FindBy(css="[data-testid='title']")
    private ExtWebElement recentOrdersHeader;

    @FindBy(css="[data-testid='pageTitle']")
    private ExtWebElement myOrdersHeader;

    @FindBy(css="td[data-testid*='myAccountOrdersTableDate']")
    private List<ExtWebElement> datesList;

    @FindBy(css="[data-testid='skeleton']")
    private ExtWebElement skeleton;

    @FindBy(css="[data-testid='side-panel-saved-item-container']")
    private ExtWebElement sidePanel;

    @FindBy(css="[data-testid='side-panel-close-button']")
    private ExtWebElement sidePanelCloseButton;

    @Autowired
    PropertyConfig props;

    public void openHomePage(){
        open(baseURL+"/uk");
    }

    public void openPdpPage(){
        open(baseURL+"/uk/Categories/Accessories/Belts/Handshake-Belt/p/3620420");
    }

    public void openPage(String page, String user){
        openPage(page,"uk",user);
    }
    public void openPage(String page, String site, String user){
        String uri = PropertyConfig.getValue("url",page);
        if(Objects.nonNull(PropertyConfig.getValue("url", page)) &&
           PropertyConfig.getValue("url", page).contains("HY"))
        {
            testData.setFirstViewOrder("HY"+uri.split("HY")[1]);
        }
        open(baseURL+"/"+site+uri);
        DeviceUtils.waitIfIpad(1000);
        waitForPageLoad();
        DeviceUtils.waitIfIphone(1000);
        if (!page.equals("collection-locations") && !page.equals("saved-items") && !user.equals("anonymouslogin") && !user.equals("softlogin")) {
        	untilElementWithTextIsPresent(Duration.ofMillis(10000), PropertyConfig.getValue("myAccount.newLookHeader"));
        }

        // Sometimes the loading spinner takes a long time to disappear
        final List<WebElement> spinners = findAll(LOADING_SPINNER_LOCATOR);
        if (!spinners.isEmpty())
        {
            fluentWait().until(ExpectedConditions.invisibilityOfAllElements(spinners));
        }
    }

    public void openPageWithOrder(String page, String orderNumber){
        open(baseURL+PropertyConfig.getValue("url",page).replace("<orderNumber>",PropertyConfig.getValue(orderNumber)));
    }

    public void openMobilePage(String page){
        open(baseURL+PropertyConfig.getValue("url",page));
    }

    public void checkUrlSiteInfo(String site)
    {
        waitFor(1500);
        DeviceUtils.waitIfIphone(2000);
        AssertUtils.assertContains(getCurrentUrl(), site);
    }

    public void verifyMyAccountPageOrders(String type)
    {
        waitForPageLoad();
        if(type.equals("recent")) {
            Assert.assertEquals(recentOrderHeader.get(1).getText(), PropertyConfig.getValue( "myAccount.recentOrders"));
            AssertUtils.assertEqualsIgnoreCase(PropertyConfig.getValue("myAccount.viewOrders"), viewMyOrdersButton.getText());
        }
        else{
            Assert.assertEquals(myOrdersHeader.getText(),PropertyConfig.getValue("header.myOrders.title"));
        }
        List<String> dates = datesList.stream().map(ExtWebElement::getText).filter(ds1 -> !ds1.equals(PropertyConfig.getValue("orders.orderDate.heading"))).collect(Collectors.toList());
//        Adding this until we get date translation confirmation
        if (!(LocaleUtils.getSite().equals("fr")||LocaleUtils.getSite().equals("de"))){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        List<String> dateTimeList = dates.stream().map(ds1 -> LocalDate.parse(ds1, formatter)).sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new)).stream().map(formatter::format).collect(Collectors.toList());
        Assert.assertEquals("expected dates:"+dateTimeList+" doesnt match "+" Actual dates:"+dates, dateTimeList, dates);
        }
    }

    
    
    public void setJsessionCookie(final String value)
    {
        // We cannot add cookies for the who-am-i domain, so we have to navigate there to set Jsession cookie
        DeviceUtils.waitIfIphone(500);
        getDriver().navigate().to(UrlProperties.getJsessionIdWhoAmI());
        getDriver().manage().deleteCookieNamed(CookieUtils.JSESSIONID);
        getDriver().manage().addCookie(CookieUtils.generateJsessionIdCookie(value));
        DeviceUtils.waitIfIphone(500);
        browserRefresh();
    }

    public void setNetworkSpeedTo3G(){

        getDriver().getDevtools()
                   .send(Network.emulateNetworkConditions(
                           false,
                           25,
                           7000,
                           5000,
                           Optional.of(ConnectionType.CELLULAR3G)
        ));
    }

    public void skeletonDisplayed() {
        try
        {
            Assert.assertTrue("Loading animation not displayed", skeleton.waitUntilPresent().isPresent());
        }
        catch (final StaleElementReferenceException ignored)
        {
            Assert.assertTrue("Loading animation not displayed", skeleton.waitUntilPresent().isPresent());
        }
    }

    public void blockSiteUrl(String URL) {
         String urlToBlock = getUrlProperty(URL);
         getDriver().getDevtools().send(Network.setBlockedURLs(ImmutableList.of(urlToBlock)));
     }
    
	public void iAmOnThePage(final String url)
	{
        Sleeper.sleep(1000);
	    waitForPageLoad();
		final String formattedUrl = String.format("%s/%s%s",
												  baseURL,
												  LocaleUtils.getSite(),
												  url);
		Assert.assertEquals(formattedUrl, getCurrentUrl());
	}

    public void checkSidePanelOpens() {
        Assert.assertTrue( "Side panel is not present", sidePanel.isDisplayed());
    }

    public void sidePanelCloses() {
        sidePanelCloseButton.click();
        waitFor(500);
        Assert.assertFalse( "Side panel is still present", isElementVisible(sidePanel));
    }

    public void errorPageIsVisible(final int code)
   	{
   	    DeviceUtils.waitIfIphone(1000);
   		Assert.assertEquals(SiteProperties.getErrorPageTitle(code), getTitle());
   	}
}
