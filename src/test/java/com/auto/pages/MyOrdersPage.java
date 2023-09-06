package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.auto.data.TestData;
import com.auto.pageElements.OrderHistoryOrder;
import com.auto.props.MyAccountProperties;
import com.auto.props.OrderProperties;
import com.auto.utils.DeviceUtils;
import com.auto.utils.LocaleUtils;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import com.automation.core.utilities.assertion.AssertUtils;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyOrdersPage extends BasePage {

	@Autowired
	PropertyConfig props;

	@Autowired
	TestData testData;

	//ToDo: Missing data-testid for top navigation menus
	@FindBy(css="[id='__next'] div div div div a")
	private List<ExtWebElement> topNavMenus;

	@FindBy(css="[data-testid='myAccountMenu']")
	private ExtWebElement leftNav;

	@FindBy(css="[data-testid='pageTitle']")
	private ExtWebElement pageTitle;

	private By apiErrorMessage = By.cssSelector("[data-testid='apiErrorMessage']");

	private By apiErrorRetryButton = By.cssSelector("[data-testid='apiErrorRetryButton']");

	@FindBy(css="[data-testid='order-error']")
	private ExtWebElement errorTable;
	
	@FindBy(css="[data-testid='pageContent']")
	private ExtWebElement pageContent;

	private By errorMsg = By.cssSelector("[data-testid='apiErrorMessage']");

	@FindBy(css="img[data-testid='orderLocationLogo']")
	private ExtWebElement collectionAddressLogo;

	@FindBy(css="[data-testid='orderAddress']")
	private ExtWebElement collectionAddressDetail;

	@FindBy(css="[data-testid='orderCollectionDetails'] [data-testid='orderDetailsHeading']")
	private ExtWebElement collectionDetailsTitle;

	@FindBy(css="[data-testid='user-name-value']")
	private ExtWebElement collectionDetailsNames;

	@FindBy(css="[data-testid='orderCollectionDetails'] div div:nth-child(2)")
	private ExtWebElement collectionDetailsTitleText;

	@FindBy(css="[data-testid='orderCollectionDetails'] div div")
	private ExtWebElement collectionDetailsTitleTextDEFR;

	@FindBy(css="[data-testid='orderCollectionFrom'] [data-testid='orderCollectionFrom']")
	private ExtWebElement collectionFromTitle;

	@FindBy(css="[data-testid='orderCollectionFrom']")
	private ExtWebElement collectionFromTable;

	@FindBy(css="[data-testid='orderCollectionFrom'] div div")
	private ExtWebElement collectDateTime;

	@FindBy(css="[data-testid='orderCollectionFrom'] div")
	private ExtWebElement collectOrderMessage;

	@FindBy(css="[data-testid='orderCollectionFrom'] div strong")
	private ExtWebElement collectDays;

	@FindBy(css="[data-testid='openingHoursTitle']")
	private ExtWebElement openingHoursTitle;

	@FindBy(css="[data-testid='temporaryHoursTitle']")
	private ExtWebElement temporaryHoursTitle;

	@FindBy(css="[data-testid*='myAccountMenuLinkItem']")
	private List<ExtWebElement> myAccountMenuLinks;

	private By  myAccountMenuLink0 = By.cssSelector("[data-testid*='myAccountMenuLinkItem_0']");

	@FindBy(css="[data-testid='myAcccountMenuControl']")
	private ExtWebElement mobileMyAccountNavigationBar;

	@FindBy(css="[data-testid^='myAccountOrdersTableStatus_']")
	private List<ExtWebElement> orderStatus;

	@FindBy(css="[data-testid='stepperOrderStatus'] div[data-testid^='step']")
	private List<ExtWebElement> orderStatusInDetail;

	@FindBy(css="[data-testid='myAccountOrdersTable'] tbody tr")
	private List<ExtWebElement> orders;

	private final String openingHourRow = "[data-testid='openingHourRow_%s']";

	private final String temporaryHourRow = "[data-testid='temporaryHourRow_%s']";

	private final String collectionAddress = "div:nth-child(%s)";

	private By firstChild = By.cssSelector("div:nth-child(1)");

	@FindBy(css="[data-testid*='needHelpButton']")
	private ExtWebElement contactUsButton;

	@FindBy(css="[data-testid='needHelpHeading']")
	private ExtWebElement contactUsHeading;
	
	@FindBy(css="[data-testid='itemTitleUrl1'] > img")
	private ExtWebElement purgedItem;

	public void checkLeftNav()
	{
		Assert.assertTrue("The left navigation bar is missing. ", leftNav.isDisplayed());
	}

	public void openingHoursDisplayed() {
		Assert.assertEquals("Opening hours title is missing", openingHoursTitle.getText(),"Opening Hours:");
		checkOpenDateTimeValue("collection.store.openingDate",openingHourRow);
		checkOpenDateTimeValue("collection.store.openingHours",openingHourRow);
		int startDay = Integer.parseInt(PropertyConfig.getValue("collection.store.workingDays"));
		int endDay = Integer.parseInt(PropertyConfig.getValue("collection.store.totalDays"));
		checkDateTimeNotEmpty(startDay,endDay,"date",openingHourRow);
		checkDateTimeNotEmpty(startDay,endDay,"time",openingHourRow);
	}

	public void tempOpeningHoursDisplayed() {
		Assert.assertEquals("Temporary Opening Hours title is missing", temporaryHoursTitle.getText(),"Temporary Opening Hours:");
		checkOpenDateTimeValue("collection.store.temporaryOpeningDate",temporaryHourRow);
		checkOpenDateTimeValue("collection.store.temporaryOpeningHours",temporaryHourRow);
		int tempStartDay = Integer.parseInt(PropertyConfig.getValue("collection.store.temporaryWorkingDays"));
		int tempEndDay = Integer.parseInt(PropertyConfig.getValue("collection.store.temporaryTotalDays"));
		checkDateTimeNotEmpty(tempStartDay,tempEndDay,"date",temporaryHourRow);
		checkDateTimeNotEmpty(tempStartDay,tempEndDay,"time",temporaryHourRow);
	}

	public void checkOpenDateTimeValue(String key, String root)
	{
		List<String> expectedList = Stream.of(PropertyConfig.getValue( key).split(",")).collect(Collectors.toList());
		List<String> actualList= new ArrayList<>();
		IntStream.range(0,key.contains("Temporary")?1:5).forEach(i-> actualList.add(find(By.cssSelector(String.format(root,i)+" div:nth-child("+(key.contains("Date")?1:2)+")")).getText()));
		Assert.assertEquals("Opening date time not match "+key,actualList,expectedList);
	}

	public void checkDateTimeNotEmpty(int start, int end, String dateTime, String root)
	{
		IntStream.rangeClosed(start,end).forEach(i-> Assert.assertFalse("Missing the "+i+"th "+root,find(By.cssSelector(String.format(root,i)+" div:nth-child("+(dateTime.equals("date")?1:2)+")")).getText().isEmpty()));
	}

	public void clickTryAgainBtn()
	{
		find(apiErrorRetryButton).click();
	}
	public void clickTryAgainBtnAndCheckPage()
	{
		clickTryAgainBtn();
		checkErrorOnOrdersPage();
	}

	public void checkErrorOnOrdersPage(){	
		AssertUtils.assertContains(pageContent.findBy(apiErrorRetryButton).getText(),PropertyConfig.getValue("orders.tryAgain.link"));
		AssertUtils.assertContains(pageContent.findBy(apiErrorMessage).getText().replaceAll("\n", ""),PropertyConfig.getValue("orders.error.message"));
	}

	public void checkCollectionAddressDetails()
	{
		checkCollectionTitles();
		checkCollectionLogo();
		checkCollectionName();
		checkCollectionAddress();
	}

	public void checkCollectionTitles()
	{
		waitForPageLoad();
		Assert.assertEquals("Collection details title is missing.",collectionDetailsTitle.getText(),PropertyConfig.getValue("collection.detailsTitle"));
		Assert.assertEquals("Collection from title is missing.",collectionFromTitle.getText(),PropertyConfig.getValue("collection.fromTitle"));
	}

	public void checkCollectionName()
	{
		Assert.assertFalse("Collection address name is missing.",collectionAddressDetail.findElement(firstChild).getText().isEmpty());
	}

	public void checkCollectionAddress()
	{
		IntStream.rangeClosed(2,Integer.parseInt(PropertyConfig.getValue("collection.store.workingDays"))).forEach(i -> Assert.assertFalse("The number "+i+"th collection address element is missing.",collectionAddressDetail.findElement(By.cssSelector(String.format(collectionAddress,i))).getText().isEmpty()));
	}

	public void checkCollectionLogo() {
		Assert.assertTrue("Collection address logo is missing.",collectionAddressLogo.isDisplayed());
	}

	public void verifyCollectionFromContents()
	{
		Pattern pattern = Pattern.compile("^(\\d{1,2}(?:am|pm))(\\s[A-Za-z.,À-ü]{3,4}\\s\\d{2}){2}$");
		Matcher matcher = pattern.matcher(collectDateTime.getText());
		Assert.assertTrue("The date "+collectDateTime.getText()+" not meet the format",matcher.matches());
		Assert.assertEquals("The "+PropertyConfig.getValue("collection.days")+" is missing",collectDays.getText(),PropertyConfig.getValue("collection.days"));
		Assert.assertEquals("Missing localised message.",collectOrderMessage.getText().replace(collectDateTime.getText(),"").replace(collectDays.getText(),""),PropertyConfig.getValue("collection.message"));
	}

	public void myAccountMenuLinksDisplayedAsPerSite(){
		Sleeper.sleep(1000);
		if(isMobile()){
			Assert.assertFalse("Side menu was open by default", isElementVisible(myAccountMenuLink0));
			mobileMyAccountNavigationBar.click();
			Assert.assertFalse("Side menu did not open when toggled", myAccountMenuLinks.isEmpty());
			mobileMyAccountNavigationBar.click();
			Assert.assertFalse("Side menu did not close when toggled", isElementVisible(myAccountMenuLink0));
			mobileMyAccountNavigationBar.click();
		}
		List<String> expectedList= Stream.of(PropertyConfig.getValue("myAccount.sideMenuLinks").split(",")).collect(Collectors.toList());
		List<String> actualList= new ArrayList<>();
		try {
			myAccountMenuLinks.forEach(link -> actualList.add(link.getText().replaceAll("(^\\h*)|(\\h*$)","").trim()));
		} catch(final StaleElementReferenceException e){
			myAccountMenuLinks.forEach(link -> actualList.add(link.getText().replaceAll("(^\\h*)|(\\h*$)","").trim()));
		}
		Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	public void isContactUsButtonVisible()
	{
		Assert.assertEquals("Missing need help heading",contactUsHeading.getText(),PropertyConfig.getValue("orders.contactUs.head"));
		Assert.assertTrue(contactUsButton.isVisible());
		Assert.assertEquals("Missing need help button text",PropertyConfig.getValue( "orders.contactUs"), contactUsButton.getText());
	}

	public void clickContactUsButton()
	{
		contactUsButton.click();
	}

	public List<OrderHistoryOrder> getOrders()
	{
		DeviceUtils.waitIfSafari(1000);
		final List<OrderHistoryOrder> list = new ArrayList<>();
		IntStream.rangeClosed(1,orders.size()-1).forEach(i->list.add(OrderHistoryOrder.generate(orders.get(i))));
		return list;
	}

	private OrderHistoryOrder getOrderWithStatus(final List<String> statuses)
	{
		return getOrders().stream()
						  .filter(order -> statuses.contains(order.getStatus().getText().trim()))
						  .findAny()
						  .orElseThrow(() -> new NotFoundException("No orders found with statuses: " +
																   statuses));
	}

	public void clickOrderWithAnyStatusOfDeliveryType(final String deliveryMethod)
	{
		getOrderWithStatus(OrderProperties.getOrderStatuses(deliveryMethod))
				.getViewOrderLink()
				.click();
	}

	public void clickOrderWithStatus(final String status)
	{
		getOrderWithStatus(Lists.newArrayList(OrderProperties.getOrderStatus(status)))
				.getViewOrderLink()
				.click();
	}

	public void verifyCollectionDetailsContents(){
		checkOrderStatusInOrderDetailPage();
		checkCollectorOfOrder();
	}

	public void checkOrderStatusInOrderDetailPage()
	{
		List<String> expectedStatusList = Stream.of(PropertyConfig.getValue("orders.status").split(",")).collect(Collectors.toList());
		DeviceUtils.waitIfIphone(1000);
		DeviceUtils.waitIfIpad(2500);
		List<String> actualStatusList=orderStatusInDetail.stream().map(ExtWebElement::getText).collect(Collectors.toList());
		Assert.assertEquals(expectedStatusList, actualStatusList);
//		IntStream.range(0,actualStatusList.size()).forEach(i->Assert.assertTrue("Order status not match with "+actualStatusList.get(i),expectedStatusList.stream().anyMatch(p->p.equals(actualStatusList.get(i)))));
	}

	public void checkCollectorOfOrder()
	{
		Assert.assertFalse("Missing title in collection details", (LocaleUtils.getSite().equals("de")||LocaleUtils.getSite().equals("fr"))?collectionDetailsTitleText.getText().isEmpty():collectionDetailsTitleText.getText().isEmpty());
		Assert.assertFalse("Missing first name and last name in collection details", collectionDetailsNames.getText().isEmpty());
	}
	
	public void checkPurgedItem()
	{
		  Assert.assertTrue("purged item not visible and not clickable", purgedItem.isPresent());		
	}

	public void clickingEachSideMenuLinkTakesMeToTheCorrespondingAccountPage()
	{
		final List<String> pages = MyAccountProperties.getExpectedSideMenuLinks();
		for (int i = 0; i < myAccountMenuLinks.size(); i++)
		{

			final String expectedUrl = PropertyConfig.getValue("url", pages.get(i));
			// Links to the current page do nothing - no point testing them
			if (!getCurrentUrl().contains(expectedUrl))
			{
				myAccountMenuLinks.get(i).click();
				Sleeper.sleep(2000);
				waitForPageLoad();
				AssertUtils.assertContains(getCurrentUrl(), expectedUrl);
				browserBack();
				waitForPageLoad();
				if (isMobile())
				{
					mobileMyAccountNavigationBar.click();
				}
			}
		}
	}
}
