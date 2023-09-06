package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.auto.data.TestData;
import com.auto.utils.DeviceUtils;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import com.automation.core.utilities.assertion.AssertUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyAccountHomePage extends BasePage {

	@Autowired
	PropertyConfig props;

	@Autowired
	TestData testData;

	@Autowired
	OrderDetailsPage orderDetailsPage;

	@FindBy(css="[data-testid='apiErrorRetryButton']")
	private ExtWebElement tryAgainLink;

	@FindBy(css="[data-testid='apiErrorMessage']")
	private ExtWebElement errorMsg;

	@FindBy(css="[data-testid='myAccountNoOrders'] div")
	private List<ExtWebElement> noOrdersInfo;

	@FindBy(css="[data-testid='viewMyOrdersButton']")
	private ExtWebElement viewMyOrdersButton;

	@FindBy(css="[data-testid='myAccountOrdersTable'] tr")
	private List<ExtWebElement> ordersTableRows;

	@FindBy(css="[data-testid='myAccountOrdersTableId_0']")
	private ExtWebElement firstOrderId;

	@FindBy(css="[data-testid='myAccountOrdersTableTotal_0']")
	private ExtWebElement firstOrderTotal;

	@FindBy(css="[data-testid='myAccountOrdersTableStatus_0'] p:nth-child(1)")
	private ExtWebElement firstOrderStatus;

	@FindBy(css="[data-testid='myAccountOrdersTableViewOrder_0'] [data-testid='viewOrderLink']")
	private ExtWebElement firstViewOrder;

	@FindBy(css="td[data-testid*='myAccountOrdersTableDate']")
	private List<ExtWebElement> datesList;

	@FindBy(css="td[class*='orderId']")
	private ExtWebElement orderIds;

	@FindBy(css="[data-testid='pageTitle']")
	private ExtWebElement myOrdersHeader;

	@FindBy(css="[data-testid='title']")
	private List<ExtWebElement> recentOrderHeader;

	@FindBy(linkText="View Order")
	private ExtWebElement viewOrderLink;

	@FindBy(css="[data-testid='myAccountOrdersTableStatus_0'] p")
	private  List<ExtWebElement> dispatchedOrder;

	@FindBy(css="[data-testid='noOrdersMesage']")
	private ExtWebElement noOrdersMsg;

	@FindBy(css="[data-testid='shopNowButton']")
	private ExtWebElement shopNowBtn;
	
	@FindBy(css="[data-testid='findStoreText']")
	private ExtWebElement findStoreText;
	
	@FindBy(css="[data-testid='findStoreIconMobile']")
	private ExtWebElement findStoreIconMobile;
	
	@FindBy(css="[data-testid='findStoreText']")
	private ExtWebElement findStoreIcon;
	
	@FindBy(css="[data-testid='headerLogo'] > title")
	private ExtWebElement newLookLogo;
	
	@FindBy(css="[data-testid='headerLogo']")
	private ExtWebElement newLookHeader;
	
	@FindBy(css="[data-testid='findStoreIcon']>title")
	private ExtWebElement findStoreIconHoverText;
	
	@FindBy(css="[data-testid='headerAccountIcon'] > title")
	private ExtWebElement goToMyAccountText;
	
	@FindBy(css="[data-testid='myAccount_link_1']")
	private ExtWebElement myAddress;
	
	@FindBy(css="[data-testid='myAccount_link_4']")
	private ExtWebElement mySavePoints;
	
	@FindBy(css="[class='search__headline']")
	private ExtWebElement searchMessageInResponse ;

	private final String homePageLink = "button[data-testid*='myAccount_link_%s']";

	private final String placeHolderPageElement = "[data-testid='%s']";

	@FindBy(css="button[data-testid*='myAccount_link']")
	private List<ExtWebElement> myAccountMenuLinks;

	@FindBy(css="[data-testid='myAccountOrdersTableDate']")
	private ExtWebElement OrderDate;
	@FindBy(css="[data-testid='myAccountOrdersTableId']")
	private ExtWebElement OrderNumber;
	@FindBy(css="[data-testid='myAccountOrdersTableTotal']")
	private ExtWebElement total;
	@FindBy(css="[data-testid='myAccountOrdersTableStatus']")
	private ExtWebElement orderstatus;
	@FindBy(css="[data-testid='newsletterHeading']")
	private ExtWebElement newsLetterHeading;
	@FindBy(css="[data-testid='newsletterHelperText']")
	private ExtWebElement newsLetterHelperText;
	@FindBy(css="[data-testid='title']")
	private ExtWebElement title;

	@FindBy(css="[data-testid='apiErrorRetryButton']")
	private ExtWebElement apiErrorRetryButton;

	public void checkMyAccountLinks() {
		List<String> expectedList= Stream.of(PropertyConfig.getValue("myAccount.menuLinks").split(",")).collect(Collectors.toList());
		List<String> actualList= new ArrayList<>();
		try {
			// Unusual regex gets rid of non-breaking space that appears on Mac
			myAccountMenuLinks.forEach(link -> actualList.add(link.getText().replaceAll("(^\\h*)|(\\h*$)","").trim()));
		} catch(final StaleElementReferenceException e){
			myAccountMenuLinks.forEach(link -> actualList.add(link.getText().replaceAll("(^\\h*)|(\\h*$)","").trim()));
		}

		Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
		checkCssValues(myAccountMenuLinks.get(0), "myAccount.myOrder");
		checkCssValues(myAccountMenuLinks.get(myAccountMenuLinks.size() - 1), "myAccount.contactPreference");
	}

	public void clickAccountLinkWithText(final String linkName)
	{
		myAccountMenuLinks.stream()
						  .filter(link-> link.getText().equalsIgnoreCase(linkName))
						  .findAny()
						  .orElseThrow(() -> new NotFoundException("No my account link with text: " + linkName))
						  .click();
		Sleeper.sleep(1000);
		waitForPageLoad();
	}

	private enum Links {
		MY_ORDERS("0"),
		MY_ADDRESSES("1"),
		MY_PAYMENT_CARDS("2"),
		MY_PERSONAL_DETAILS("3"),
		SAVED_COLLECTION_POINTS("4"),
		MY_SAVED_ITEMS("5"),
		MY_DELIVERY_PASS("6"),
		MY_CONTACT_PREFERENCES("7");

		public String links;
		Links(String links) {
			this.links = links;
		}
		public static String getLinks(Links links) {
			return links.links;
		}
	}

	public void clickAndVerifyHomePageLink(DataTable icons) {
		icons.asList(String.class).forEach(icon-> {
			verifyLinkDisplayed(icon.toString()).click();
			verifyPageUrl(icon.toString());
			browserBack();
		});
	}
	public void verifyHomePageLinks(DataTable icons) {
		icons.asList(String.class).forEach(icon-> verifyLinkDisplayed(icon.toString()));
	}
	public WebElement verifyLinkDisplayed(String linkName) {
		WebElement element = find(By.cssSelector(String.format(homePageLink, Links.getLinks(Links.valueOf(linkName.toUpperCase())))));
		Assert.assertEquals(element.getText(), linkName.replace("_", " "));
		return  element;
	}
	public void verifyPageUrl(String linkName) {
		String[] pageText = PropertyConfig.getValue("url",linkName).split(",");
		waitForCondition().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(String.format(placeHolderPageElement,pageText[1]))));
		Assert.assertTrue(getDriver().getCurrentUrl().contains(pageText[0]));
	}

	public void verifyMyAccountPageNoOrders()
	{
		Assert.assertEquals(PropertyConfig.getValue( "myAccount.recentOrders"), noOrdersInfo.get(0).getText());
		Assert.assertEquals(PropertyConfig.getValue( "myAccount.viewOrders"), viewMyOrdersButton.getText());
		String ActualOrdersMsg = PropertyConfig.getValue( "myAccount.noOrders");
		Assert.assertTrue("Expected:"+ActualOrdersMsg+" \n -Actual:"+noOrdersInfo.get(1).getText(),noOrdersInfo.get(1).getText().contains(ActualOrdersMsg));
	}

	public void clickFirstViewOrderLink() {
		testData.setFirstViewOrder(firstOrderId.getText(), firstOrderTotal.getText(), firstOrderStatus.getText());
		firstViewOrder.click();
	}

	public void orderDetailsPageDisplayed() {
		ordersHeadingIsPresent();
	}

	public void ordersHeadingIsPresent() {
		Sleeper.sleep(1000);
		Assert.assertEquals(myOrdersHeader.getText(), PropertyConfig.getValue("header.myOrders.title"));
		checkCssValues(myOrdersHeader, "myOrders");
	}
	public void verifyColumns() {
		List<String> actualColumns = ordersTableRows.get(0).findElements(By.cssSelector("td")).stream().map(WebElement::getText).collect(Collectors.toList());
		String columns = isMobile() || isTablet() ? "orders.mobileColumns" : "orders.desktopColumns";
		List<String> expectedColumns = Stream.of(PropertyConfig.getValue( columns).split(",")).collect(Collectors.toList());
		expectedColumns.add("");
		AssertUtils.assertContainsAll(actualColumns, expectedColumns);
		checkCssValues(OrderDate,"myAccount.orderDate");
		checkCssValues(OrderNumber,"myAccount.orderNumber");
		checkCssValues(total,"myAccount.orderTotal");
		checkCssValues(orderstatus,"myAccount.orderStatus");
		checkCssValues(newsLetterHeading,"myAccount.newsHeading");
		checkCssValues(newsLetterHelperText,"myAccount.newsHeadingHelper");

	}

	public void errorDisplayedWithRetry() {
		browserRefresh();
		waitForPageLoad();
		untilElementWithTextIsPresent(Duration.ofMillis(600), PropertyConfig.getValue("orders.tryAgain.link"));
		AssertUtils.assertContains(errorMsg.getText().replaceAll("\n", ""),PropertyConfig.getValue("orders.error.message"));
		AssertUtils.assertContains(tryAgainLink.getText(),PropertyConfig.getValue("orders.tryAgain.link"));		
	}


	public void dispatchedOrderDisplayed() {
		Assert.assertTrue(dispatchedOrder.get(0).getText().contains( "Dispatched"));
		Assert.assertEquals(dispatchedOrder.get(1).getText(), "Track Order");
	}

    public void noOrdersDisplayed() {
		Assert.assertEquals("You don’t have any orders right now.\nTime to go shopping.", noOrdersMsg.getText());
		Assert.assertTrue(shopNowBtn.isDisplayed());
    }
    
	/**
	 * method to check the display of find the store link and new look header
	 */
    public void verifyLinkAndHeader() {
		waitForPageLoad();	
    	untilElementWithTextIsPresent(Duration.ofMillis(600), PropertyConfig.getValue("myAccount.newLookHeader"));
    	if (!isMobile()) {
		    Assert.assertEquals(PropertyConfig.getValue("myAccount.findStoreText"), findStoreText.getText());
		    Assert.assertTrue(findStoreIcon.isDisplayed());
    	}		
	 Assert.assertEquals(PropertyConfig.getValue("myAccount.newLookHeader"), newLookLogo.getTextContent());
	 Assert.assertEquals(PropertyConfig.getValue("myAccount.goToMyAccountText"), goToMyAccountText.getTextContent());
	 Assert.assertTrue(newLookLogo.getTextContent().contains(PropertyConfig.getValue("myAccount.newLookTitle")));
	 Assert.assertEquals(PropertyConfig.getValue("myAccount.findStoreIconHoverText"), findStoreIconHoverText.getTextContent());
    }
    
	/**
	 * method to click on find the store link and navigate to correct page
	 */
    public void clickOnFindStoreLink() {  	
		if (isMobile()) {
			clickButton(findStoreIconMobile);
		} else {
			clickButton(findStoreText);
		}
    	waitForPageLoad();
    	DeviceUtils.waitIfIphone(4000);
    	DeviceUtils.waitIfIpad(4000);
    	AssertUtils.assertContains(getCurrentUrl(), PropertyConfig.getValue("myAccount.findstore.navigation.url"));
    }
  
	/**
	 * method to click on new look title and navigate to correct page
	 */
    public void clickOnNewLookTitle() {  
    	waitForPageLoad();
	    clickButton(newLookHeader);
    	waitForPageLoad();
    	DeviceUtils.waitIfIphone(4000);
    	Assert.assertTrue(getCurrentUrl().contains(PropertyConfig.getValue("myAccount.newLookLogo.navigation.url")));  
    }   
    
    /**
     * method to my address and save point option appears on account page
     */
    public void checkLink() { 
		waitForPageLoad();
		untilElementWithTextIsPresent(Duration.ofMillis(500), PropertyConfig.getValue("myAccount.myAddress"));
    	Assert.assertTrue(myAddress.isDisplayed());
    	Assert.assertEquals(PropertyConfig.getValue("myAccount.myAddress"), myAddress.getText());
    	Assert.assertTrue(mySavePoints.isDisplayed());
    	Assert.assertEquals(PropertyConfig.getValue("myAccount.savedCollectionPoints"), mySavePoints.getText());
    }
    
    public void verifyTheResponseOfSearchText() {
    	DeviceUtils.waitIfIpad(2000);
    	waitForPageLoad();
    	Assert.assertEquals(PropertyConfig.getValue("myAccount.searchMessageInResponse"), getCurrentUrl());
    }
	public void clickTryAgainBtnAndCheckPage()
	{
		apiErrorRetryButton.click();

	}
	public void checkTitleInSlowInternet()
	{
		Assert.assertEquals("No title is displayed",
				PropertyConfig.getValue("myAccount.title"),
				title.getText());

	}
}