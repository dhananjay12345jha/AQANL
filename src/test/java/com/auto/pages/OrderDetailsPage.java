package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.auto.data.TestData;
import com.auto.props.OrderProperties;
import com.auto.props.SiteProperties;
import com.auto.props.UrlProperties;
import com.auto.utils.CurrencyUtils;
import com.auto.utils.DateUtils;
import com.auto.utils.DeviceUtils;
import com.auto.utils.LocaleUtils;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import com.automation.core.utilities.assertion.AssertUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.auto.utils.DeviceUtils.isCatalina;

public class OrderDetailsPage extends BasePage {

	@Autowired
	TestData testData;

	@FindBy(css="[data-testid='trackMyOrderButton']")
	private ExtWebElement trackOrderButton;

	@FindBy(css="[data-testid='pageContent'] div:nth-child(1)")
	private ExtWebElement orderHeader;

	@FindBy(css="[data-testid='paymentHeading']")
	private ExtWebElement paymentHeading;

	@FindBy(css="[data-testid='paymentHeading']")
	private List<ExtWebElement> paymentHeadings;

	@FindBy(css="[data-testid='paymentType']")
	private ExtWebElement paymentType;

	@FindBy(css="[data-testid='paymentPaid']")
	private ExtWebElement paymentPaid;

	@FindBy(css="[data-testid='paymentDate']")
	private ExtWebElement paymentDate;

	@FindBy(css="[data-testid='paymentBillingAddress']")
	private ExtWebElement paymentBillingAddress;

	@FindBy(css="[data-testid='paymentAddressName']")
	private ExtWebElement paymentAddressName;

	@FindBy(css="[data-testid='paymentAddressLine1']")
	private ExtWebElement paymentAddressLine1;

	@FindBy(css="[data-testid='paymentAddressLine2']")
	private ExtWebElement paymentAddressLine2;

	@FindBy(css="[data-testid='paymentAddresstown']")
	private ExtWebElement paymentAddresstown;

	@FindBy(css="[data-testid='paymentAddressPostalCode']")
	private ExtWebElement paymentAddressPostalCode;

	@FindBy(css="[data-testid='paymentAddressCountry']")
	private ExtWebElement paymentAddressCountry;

	@FindBy(css="[data-testid='refundHeading']")
	private ExtWebElement refundHeading;

	@FindBy(css="[data-testid='refundType']")
	private ExtWebElement refundPaymentType;

	@FindBy(css="[data-testid='refundRefunded']")
	private ExtWebElement refundPaymentRefunded;

	@FindBy(css="[data-testid='refundDate']")
	private ExtWebElement refundPaymentDate;

	@FindBy(css="[data-testid='refundBillingAddress']")
	private ExtWebElement refundBillingAddress;

	@FindBy(css="[data-testid='refundAddressName']")
	private ExtWebElement refundAddressName;

	@FindBy(css="[data-testid='refundAddressLine1']")
	private ExtWebElement refundAddressLine1;

	@FindBy(css="[data-testid='refundAddressLine2']")
	private ExtWebElement refundAddressLine2;

	@FindBy(css="[data-testid='refundAddresstown']")
	private ExtWebElement refundAddresstown;

	@FindBy(css="[data-testid='refundAddressPostalCode']")
	private ExtWebElement refundAddressPostalCode;

	@FindBy(css="[data-testid='refundAddressCountry']")
	private ExtWebElement refundAddressCountry;

	private final String paymentTypeIconDetail="[data-testid='paymentType_%s'] div svg";

	@FindBy(css="[data-testid='paymentType_0']")
	private ExtWebElement cardType;

	@FindBy(css="[data-testid='howToReturnHeading']")
	private ExtWebElement howToReturnHeading;

	@FindBy(css="[data-testid='howToReturnButton'] span")
	private ExtWebElement howToReturnBtnText;

	@FindBy(css="[data-testid^='itemDetailsContainer_'] [data-testid^='itemPriceContainer_'] span[data-testid*='rice']")
	private List<ExtWebElement> productPrices;

	@FindBy(css="[data-testid^='itemDetailsContainer_'] [data-testid^='itemDetails_']")
	private List<ExtWebElement> itemsProps;

	@FindBy(css="[data-testid^='itemDetailsContainer_'] [data-testid^='itemStatus_']")
	private List<ExtWebElement> itemsStatus;

	@FindBy(css="[data-testid^='itemDetailsContainer_'] [data-testid^='itemTitle_']")
	private List<ExtWebElement> itemsTitles;

	private final String paymentTypeDetail="[data-testid='paymentType_%s'] div";

	private final String paymentPaidDetail="[data-testid='paymentPaid_%s']";

	private final String paymentDateDetail="[data-testid='paymentDate_%s']";

	private final String paymentInfoDetail="[data-testid='paymentInfo_%s']";

	private String paymentInfoPatternVisa = null;

	private final String refundTypeIconDetail="[data-testid='refundType_%s'] div svg";

	private final String refundTypeDetail="[data-testid='refundType_%s'] div";

	private final String refundPaidDetail="[data-testid='refundPaid_%s']";

	private final String refundDateDetail="[data-testid='refundDate_%s']";

	private final String refundInfoDetail="[data-testid='refundInfo_%s']";

	private String refundInfoPatternVisa = null;

	private By orderHeaderNumber = By.cssSelector("[data-testid='order-heading-number']");

	private By itemCount = By.cssSelector("[data-testid='itemCount']");

	@FindBy(css="[data-testid='stepperOrderStatus'] > [data-testid*='step']")
	private List<ExtWebElement> orderStatuses;

	@FindBy(css="[data-testid='order-date-placed']")
	private ExtWebElement orderPlacedDate;

	private static final By ORDER_STATUS_TIMELINE_LOCATOR = By.cssSelector("[data-testid='stepperOrderStatus']");

	@FindBy(css="div[class*='MuiStepConnector-active'] + span[class*='MuiStepLabel-alternativeLabel']")
	private ExtWebElement currentOrderStatus;

	private static final By ORDER_STATUS_COLOUR_LOCATOR = By.cssSelector(".MuiStepLabel-iconContainer > div > *");

	@FindBy(css="[data-testid='txtOrderStatus']")
	private ExtWebElement orderStatus;

	@FindBy(css="[data-testid='txtStatusNotCollected']")
	private ExtWebElement statusDescription;

	private By promotionHeading = By.cssSelector("[data-testid='appliedPromotionsHeading']");

	private final String itemDiscountedPrice1item = "[data-testid='itemDiscountedTotalPrice_%s']";
	private final String itemDiscountedPriceValue = "[data-testid='itemDiscountedPrice_%s']";
	private final String pricePerItemValue = "[data-testid='pricePerItem_%s']";
	private final String itemWasPriceValue = "[data-testid='itemWasPrice_%s']";

	private By dicountMessage1st = By.cssSelector("div[data-testid='discount_0_0']");
	private By itemDiscountedPrice1st = By.cssSelector("[data-testid='itemDiscountedPrice_0']");
	private By pricePerItem1st = By.cssSelector("[data-testid='pricePerItem_0']");
	private By itemWasPrice1st = By.cssSelector("[data-testid='itemWasPrice_0']");

	@FindBy(css="div[data-testid^='promotions_']")
	private List<ExtWebElement> promotionMsg;

	@FindBy(css="div[data-testid^='discount_']")
	private List<ExtWebElement> discountMsg;

	@FindBy(css="div[data-testid^='itemTitle_']")
	private List<ExtWebElement> itemTitle;

	@FindBy(css="div[data-testid^='itemDiscountedPrice_']")
	private List<ExtWebElement> itemDiscountedPrice;

	@FindBy(css="div[data-testid^='pricePerItem_']")
	private List<ExtWebElement> pricePerItem;

	@FindBy(css="[data-testid^='itemWasPrice_']")
	private List<ExtWebElement> itemWasPrice;

	@FindBy(css="div[data-testid^='coupon_']")
	private List<ExtWebElement> couponMsg;

	@FindBy(css="img[src*='maps.googleapis.com']")
	private ExtWebElement staticCollectionPointMap;

	@FindBy(className="gm-style")
	private ExtWebElement dynamicCollectionPointMap;

	@FindBy(css="[data-testid='howToReturnButton']")
	private ExtWebElement returnsButton;

	@FindBy(css="[data-testid='stepplaced_0']")
	private ExtWebElement placedStep;

	@FindBy(css="[data-testid='itemListCount']")
	private ExtWebElement totalItems;

	@FindBy(css="[data-testid^='itemContainer_'] img[data-testid^='itemImg_']")
	private List<ExtWebElement> itemImage;

	@FindBy(css="[data-testid='orderSubTotalValue']")
	private ExtWebElement subtotal;

	@FindBy(css="[data-testid='orderSavingsValue']")
	private ExtWebElement totalSavings;

	private static final By TOTAL_SAVINGS_LOCATOR = By.cssSelector("[data-testid='orderSavingsValue']");

	@FindBy(css="[data-testid='orderDelivery']")
	private ExtWebElement deliveryMethod;

	@FindBy(css="[data-testid='orderDeliveryValue']")
	private ExtWebElement deliveryCost;

	@FindBy(css="[data-testid='orderTotalValue']")
	private ExtWebElement totalPrice;

	@FindBy(css="[data-testid='orderDeliveryDetails'] div > div:nth-child(1)")
	private ExtWebElement deliveryName;

	@FindBy(css="[data-testid='orderDeliveryDetails'] div > div:nth-child(2)")
	private ExtWebElement deliveryDetails;

	@FindBy(css=" [data-testid='orderAddress']")
	private ExtWebElement orderAddress;

	@FindBy(css="[data-testid='txtStatusNotCollected']")
	private ExtWebElement returnedMessage ;

	private static final By OPEN_MAP_CTA_LOCATOR = By.linkText(OrderProperties.getOpenMapText());

	private int initial=0;

	private Pattern infoPattern;

	private Pattern paidPattern;

	private Pattern itemDiscountedPricePattern;
	private Pattern pricePerItemPattern;
	private Pattern itemWasPricePattern;
	private String itemDiscount;



	public void orderDetailsDisplayed()
	{
		Assert.assertTrue(trackOrderButton.isEnabled());
		orderHeaderDetailsDisplayed(testData.getFirstViewOrder(), getItemCount());
	}

    public void verifyOrderDetailsOfFirstOrder() {
        orderHeaderDetailsDisplayed(testData.getFirstViewOrder(), testData.getFirstOrderTotal(), testData.getFirstOrderStatus(), getItemCount());
    }

    public void orderHeaderDetailsDisplayed(String orderNumber, String orderTotal, String orderStatus, int items) {
        orderHeaderDetailsDisplayed(orderNumber, items);
        Assert.assertEquals(orderTotal.replaceAll("\\D+", ""), totalPrice.getText().replaceAll("\\D+", ""));
		if (orderStatus == PropertyConfig.getValue("orders.status.cancelled")) {
			Assert.assertEquals(orderTotal, totalPrice.getText());
		} else {
            untilElementWithTextIsPresent(Duration.ofMillis(100), orderStatus);
        }
    }

	public void orderHeaderDetailsDisplayed(String orderNumber, int items)
	{
		DateUtils.parseDate("EEE dd MMM yyyy", orderPlacedDate.getText());
		Assert.assertEquals(OrderProperties.getOrderId(orderNumber), orderHeader.findBy(orderHeaderNumber).getText());
		Assert.assertEquals(OrderProperties.getItemCount(items), orderHeader.findBy(itemCount).getText());
		Assert.assertTrue(orderHeader.getText().contains(SiteProperties.getCurrencySymbol()));
	}


	private int getItemCount()
	{
		// TODO: Count number of items once they have been added to page
		return 4;
	}

	public void trackOrderButtonNotDisplayed(){
		Assert.assertFalse(isElementPresent(Duration.ofMillis(500), By.cssSelector("[data-testid='trackMyOrderButton']")));
	}

	public void orderStatusesAreVisibleInOrder(final String deliveryMethod)
	{
		final SoftAssert softAssert = new SoftAssert();
		final List<String> expectedStatuses = OrderProperties.getOrderStatuses(deliveryMethod);
		for (int i = 0; i < orderStatuses.size(); i++)
		{
			Sleeper.sleep(500);
			softAssert.assertEquals(orderStatuses.get(i).getText(), expectedStatuses.get(i));
		}
		softAssert.assertAll();
	}

	public void currentOrderStatusIsHighlighted()
	{
		Assert.assertTrue(currentOrderStatus.isVisible());
	}

	public void orderStatusTimelineIsNotVisible()
	{
		Assert.assertFalse(isElementPresent(Duration.ofMillis(500), ORDER_STATUS_TIMELINE_LOCATOR));
	}

	public void orderStatusIs(final String expectedStatus)
	{
		Assert.assertEquals(expectedStatus, orderStatus.getText());
	}

	public void statusDescriptionIsVisible(final String status)
	{
		Assert.assertTrue(statusDescription.isVisible());
		Assert.assertEquals(OrderProperties.getStatusDescription(status), statusDescription.getText());
	}

	public void collectionPointIsVisibleAsAStaticMap()
	{
		DeviceUtils.waitIfIphone(2000);
		DeviceUtils.waitIfIpad(2000);
		Assert.assertTrue(staticCollectionPointMap.isVisible());
	}

	public void openMapCtaIsVisible()
	{
		final WebElement openMapCta = find(OPEN_MAP_CTA_LOCATOR);
		Assert.assertTrue("Open map CTA is not visible", openMapCta.isDisplayed());
		Assert.assertEquals("Open map CTA text is incorrect", OrderProperties.getOpenMapText(), openMapCta.getText());
	}

	public void openMapCtaLinksToGoogleMaps()
	{
		// TODO: Extract the logic of this into core codebase as assertContains
		final String actualLink = find(OPEN_MAP_CTA_LOCATOR).getAttribute("href");
		final String expectedLink = UrlProperties.getOrderDetailsCollectionMapLink();
		final String errorMessage =
				String.format("Open map CTA does not link to Google Maps. \nExpected link: %s \nActual link: %s.",
							  expectedLink,
							  actualLink);
		Assert.assertTrue(errorMessage, actualLink.contains(expectedLink));
	}

	public void staticMapLinksToGoogleMaps()
	{
		final String actualLink = staticCollectionPointMap.findBy(By.xpath("..")).getAttribute("href");
		final String expectedLink = UrlProperties.getOrderDetailsCollectionMapLink();
		final String errorMessage =
				String.format("Map does not link to Google Maps. \nExpected link: %s \nActual link: %s.",
							  expectedLink,
							  actualLink);
		Assert.assertTrue(errorMessage, actualLink.contains(expectedLink));
	}

	public void collectionPointIsVisibleAsADynamicMap()
	{
		Assert.assertTrue(dynamicCollectionPointMap.isVisible());
	}

	public void checkOrderPaymentRecords(String type)
	{
		Boolean isHdPaymentMulti = getCurrentUrl().contains(PropertyConfig.getValue("url","orderDetails.homeDelivery.multiOrders"));
		Boolean isCcPaymentMulti = getCurrentUrl().contains(PropertyConfig.getValue("url","click-collect-order-paypal-giftCard"));
		if (isHdPaymentMulti || isCcPaymentMulti) {
			initial=1;
		}
		List<String> typeList = Arrays.stream(type.split(",")).collect(Collectors.toList());
		if(typeList.size()>1){
			checkOrderPaymentGeneral(typeList.get(0), 0);
			checkOrderPaymentGeneral(typeList.get(1), initial);
			checkOrderPayment(typeList.get(0),0);
			checkOrderPayment(typeList.get(1),initial);
		}
		else {
			checkOrderPaymentGeneral(type, initial);
			checkOrderPayment(type, initial);
		}
	}

	public void checkOrderRefundRecords(String type)
	{
		Boolean isHdRefundMulti = getCurrentUrl().contains(PropertyConfig.getValue("url","orderDetails.homeDelivery.returned.multiOrders"));
		Boolean isCcRefundMulti = getCurrentUrl().contains(PropertyConfig.getValue("url","orderDetails.parcelShop.returned.multiOrders"));
		if (isHdRefundMulti || isCcRefundMulti) {
			initial=1;
		}
		List<String> typeList = Arrays.stream(type.split(",")).collect(Collectors.toList());
		if(typeList.size()>1){
			checkOrderRefundGeneral(typeList.get(0), 0);
			checkOrderRefundGeneral(typeList.get(1), initial);
			checkOrderRefund(typeList.get(0),0);
			checkOrderRefund(typeList.get(1),initial);
		}
		else {
			checkOrderRefundGeneral(type, initial);
			checkOrderRefund(type, initial);
		}
	}

	public void checkOrderNoRefundRecords()
	{
		Assert.assertEquals("More payment section existing with "+paymentHeadings.size()+" records",paymentHeadings.size(),Integer.parseInt(PropertyConfig.getValue("payment.noRefund.record.number")));
		Assert.assertEquals("Payment header is not correct",paymentHeadings.get(0).getText(),PropertyConfig.getValue("payment.head"));
	}

	public void checkOrderPaymentGeneral(String type, Integer size)
	{
		SoftAssert softly = new SoftAssert();
		softly.assertTrue(paymentHeading.getText().equals(PropertyConfig.getValue("payment.head")),"Missing payment header");
		softly.assertTrue(paymentPaid.getText().equals(PropertyConfig.getValue("payment.paid")),"Missing payment paid");
		softly.assertTrue(paymentType.getText().equals(PropertyConfig.getValue("payment.type")),"Missing payment type");
		softly.assertTrue(paymentDate.getText().equals(PropertyConfig.getValue("payment.date")),"Missing payment date");
		if (!type.equals("Gift Card")) {
			softly.assertTrue(paymentBillingAddress.getText().equals(PropertyConfig.getValue("payment.billing")),"Missing payment billing address header");
			softly.assertFalse(paymentAddressName.getText().isEmpty(),"Missing payment billing address name");
			softly.assertFalse(paymentAddressLine1.getText().isEmpty(),"Missing payment billing address line 1");
			if(isElementVisible(paymentAddressLine2)) {
			    softly.assertFalse(paymentAddressLine2.getText().isEmpty(),"Missing payment billing address line 2");
			}
			softly.assertFalse(paymentAddresstown.getText().isEmpty(),"Missing payment billing address town");
			softly.assertFalse(paymentAddressPostalCode.getText().isEmpty(),"Missing payment billing address postal code");
			softly.assertFalse(paymentAddressCountry.getText().isEmpty(),"Missing payment billing address country");
		}
		IntStream.rangeClosed(0,size).forEach(i-> softly.assertTrue(find(By.cssSelector(String.format(paymentTypeIconDetail,size))).isDisplayed(),"Missing payment type icon " +type));
		IntStream.rangeClosed(0,size).forEach(i-> softly.assertTrue(find(By.cssSelector(String.format(paymentTypeDetail,size))).getText().equals(type),"Missing payment type text "+type));
		softly.assertAll();
	}

	public void checkOrderRefundGeneral(String type, Integer size)
	{
		SoftAssert softly = new SoftAssert();
		scrollToBottom();
		refundHeading.waitByUntilVisible();
		softly.assertTrue(refundHeading.getText().equals(PropertyConfig.getValue("refund.head")),"Missing refund header");
		softly.assertTrue(refundPaymentType.getText().equals(PropertyConfig.getValue("refund.type")),"Missing refund type");
		softly.assertTrue(refundPaymentDate.getText().equals(PropertyConfig.getValue("refund.date")),"Missing refund date");
		softly.assertTrue(refundPaymentRefunded.getText().equals(PropertyConfig.getValue("refund.refund")),"Missing refund refund");
		if (!type.equals("Gift Card")) {
			softly.assertTrue(refundBillingAddress.getText().equals(PropertyConfig.getValue("refund.billing")),"Missing refund billing address header");
			softly.assertFalse(refundAddressName.getText().isEmpty(),"Missing refund billing address name");
			softly.assertFalse(refundAddressLine1.getText().isEmpty(),"Missing refund billing address line 1");
			if(isElementVisible(refundAddressLine2)) {
			    softly.assertFalse(refundAddressLine2.getText().isEmpty(),"Missing refund billing address line 2");
			}
			softly.assertFalse(refundAddresstown.getText().isEmpty(),"Missing refund billing address town");
			softly.assertFalse(refundAddressPostalCode.getText().isEmpty(),"Missing refund billing address postal code");
			softly.assertFalse(refundAddressCountry.getText().isEmpty(),"Missing refund billing address country");
		}
		IntStream.rangeClosed(0,size).forEach(i-> softly.assertTrue(find(By.cssSelector(String.format(refundTypeIconDetail,size))).isDisplayed(),"Missing refund type icon " +type));
		IntStream.rangeClosed(0,size).forEach(i-> softly.assertTrue(find(By.cssSelector(String.format(refundTypeDetail,size))).getText().equals(type),"Missing refund type text "+type));
		softly.assertAll();
	}

	public String selectPaymentType(String type)
	{
		String paymentInforSelector;
		switch (type) {
			case "Visa":
				paymentInforSelector = PropertyConfig.getValue("payment.info.pattern.Visa");
				break;
			case "Gift Card":
				paymentInforSelector = PropertyConfig.getValue("payment.info.pattern.GiftCard");
				break;
			case "Klarna":
				paymentInforSelector = PropertyConfig.getValue("payment.info.pattern.Klarna");
				break;
			case "PayPal":
				paymentInforSelector = PropertyConfig.getValue("payment.info.pattern.PayPal");
				break;
			default:
				paymentInforSelector=PropertyConfig.getValue("payment.info.pattern.NewLookCard");
		}
		return paymentInforSelector;
	}

	public void checkOrderPayment(String type, Integer size)
	{
		infoPattern = Pattern.compile(selectPaymentType(type));
		paidPattern = Pattern.compile(PropertyConfig.getValue("payment.paid.pattern"));
		Pattern datePattern = Pattern.compile(PropertyConfig.getValue("payment.date.pattern"));
		Matcher infoMatcher = infoPattern.matcher(find(By.cssSelector(String.format(paymentInfoDetail,size))).getText());
		Matcher dateMatcher = datePattern.matcher(find(By.cssSelector(String.format(paymentDateDetail,size))).getText());
		Matcher paidMatcher = paidPattern.matcher(find(By.cssSelector(String.format(paymentPaidDetail,size))).getText().trim());
		if(!(type.equals("PayPal")||type.equals("New Look Card"))) {
			IntStream.rangeClosed(0, size).forEach(i -> Assert.assertTrue("The payment information not meet the format", infoMatcher.matches()));
		}
		IntStream.rangeClosed(0,size).forEach(i-> Assert.assertTrue("The payment date not meet the format", dateMatcher.matches()));
		IntStream.rangeClosed(0,size).forEach(i-> Assert.assertTrue("The payment paid not meet the format", paidMatcher.matches()));
	}

	public void returnsLinkIsDisplayed() {
		DeviceUtils.waitIfIphone(2000);
		Assert.assertTrue(returnsButton.isDisplayed());
		Assert.assertEquals("Missing how to return heading",howToReturnHeading.getText(),PropertyConfig.getValue("orders.returnsHelp.head"));
		AssertUtils.assertEqualsIgnoreCase("Missing how to return button text",howToReturnBtnText.getText(),PropertyConfig.getValue("orders.returnsHelp.button.name"));
	}

	public void clickReturnsButton() {
		Sleeper.sleep(1000);
		returnsButton.click();
	}

	public void verifyReturnsHelpUrl() {
		final String expectedLink = PropertyConfig.getValue( "orders.links.returnsHelp");
		DeviceUtils.waitIfIphone(2000);
		Sleeper.sleep(1000);
		Assert.assertEquals(expectedLink, getDriver().getCurrentUrl());
  }

	public void checkPaymentRecords() {
		checkOrderPaymentRecords(cardType.getText());
	}

	public void checkOrderRefund(String type, Integer size)
	{
		String paidPatternConfig="refund.refunded.pattern";
		String replacedStringForMac="";
		infoPattern = Pattern.compile(selectPaymentType(type));
		if (isDesktop()) {
			if (isCatalina() && LocaleUtils.getSite().equals("uk")) {
				paidPatternConfig = "refund.refunded.pattern.macUk";
				replacedStringForMac = "-";
			}
		}
		paidPattern = Pattern.compile(PropertyConfig.getValue(paidPatternConfig));
		Pattern datePattern = Pattern.compile(PropertyConfig.getValue("refund.date.pattern"));
		Matcher infoMatcher = infoPattern.matcher(find(By.cssSelector(String.format(refundInfoDetail,size))).getText());
		Matcher dateMatcher = datePattern.matcher(find(By.cssSelector(String.format(refundDateDetail,size))).getText());
		Matcher paidMatcher = paidPattern.matcher(find(By.cssSelector(String.format(refundPaidDetail,size))).getText().trim().replaceAll(replacedStringForMac,""));
		if(!(type.equals("PayPal")||type.equals("New Look Card"))) {
			IntStream.rangeClosed(0, size).forEach(i -> Assert.assertTrue("The refund information not meet the format", infoMatcher.matches()));
		}
		Assert.assertTrue("The refund date not meet the format", dateMatcher.matches());
		Assert.assertTrue("The refund paid not meet the format", paidMatcher.matches());
	}

	public void discountMsgDisplayed(String messageType) {
		SoftAssert softAssert = new SoftAssert();
		List<ExtWebElement> elementsList;
		if(messageType.equals("none")){
			softAssert.assertFalse(isElementPresent(promotionHeading),"Missing promotion heading");
			softAssert.assertFalse(isElementPresent(dicountMessage1st), "Missing first discount message");
			softAssert.assertFalse(isElementPresent(itemDiscountedPrice1st),"Missing first item discounted price ");
			softAssert.assertFalse(isElementPresent(pricePerItem1st), "Missing first price per item");
			softAssert.assertFalse(isElementPresent(itemWasPrice1st),"Missing first item was price");
		}
		else if (messageType.contains("productPromotion")){
			int discountItems = itemWasPrice.size();
			int productItems = itemTitle.size();
			itemDiscount=(productItems==1)?itemDiscountedPrice1item:itemDiscountedPriceValue;
			itemDiscountedPricePattern = Pattern.compile(OrderProperties.getOrderProperty("discount.pattern"));
			itemWasPricePattern = Pattern.compile(OrderProperties.getOrderProperty("price.pattern"));
			pricePerItemPattern = Pattern.compile(OrderProperties.getOrderProperty("price.pattern"));

			if(productItems>1) {
				IntStream.range(0, discountItems).forEach(i -> softAssert.assertTrue(pricePerItemPattern.matcher(find(By.cssSelector(String.format(pricePerItemValue, i))).getText()).matches(),"Price per item not meet the pattern."));
			}

			IntStream.range(0,discountItems).forEach(i-> softAssert.assertTrue(itemDiscountedPricePattern.matcher(find(By.cssSelector(String.format(itemDiscount,i))).getText()).matches(),"Item discounted price not match the pattern."));
			IntStream.range(0,discountItems).forEach(i-> softAssert.assertTrue(itemWasPricePattern.matcher(find(By.cssSelector(String.format(itemWasPriceValue,i))).getText()).matches(),"Item was price not match the pattern."));
			softAssert.assertTrue(discountMsg.stream().anyMatch(ExtWebElement->ExtWebElement.getText().contains(OrderProperties.getOrderProperty(messageType))),"Missing "+discountMsg.toString());
		}
		else{
			elementsList= messageType.contains("coupon") ? couponMsg : promotionMsg;
			softAssert.assertEquals(find(promotionHeading).getText(),OrderProperties.getOrderProperty("promotionsHeading"),"Missing promotion heading.");
			softAssert.assertTrue(elementsList.stream().anyMatch(ExtWebElement->ExtWebElement.getText().contains(OrderProperties.getOrderProperty(messageType))),"Missing "+elementsList.toString());
		}
		softAssert.assertAll();
	}

	public void verifyOrderItemsProps(int itemsCount, int orderStatus, int qty){
		SoftAssert softly = new SoftAssert();
		paidPattern = Pattern.compile(PropertyConfig.getValue("payment.paid.pattern"));
		orderHeaderDetailsDisplayed(testData.getFirstViewOrder(), qty*itemsCount);
		softly.assertEquals(itemsTitles.size(),itemsCount);
		softly.assertEquals(totalItems.getText(), String.format(OrderProperties.getOrderProperty("items"+itemsCount),(qty*itemsCount)));
		softly.assertTrue(IntStream.range(0,itemsCount-1).allMatch(i -> itemImage.get(i).getAttribute("src").contains(OrderProperties.getOrderProperty("image.source"))));
		productPrices.forEach(price-> softly.assertTrue(paidPattern.matcher(price.getText().replace(OrderProperties.getOrderProperty("each"),"").trim()).matches(),"Prices are not in right format for items"));
		softly.assertTrue(itemsStatus.stream().allMatch(status-> status.getText().equals(OrderProperties.getOrderProperty("status").split(",")[orderStatus])), "Order status against items is not "+orderStatus);
		itemsProps.forEach(props->{
			softly.assertEquals(props.getText().split("\\|")[2].trim(),OrderProperties.getOrderProperty("qty") +" "+qty, "Quantity is not "+qty);
			softly.assertTrue(props.getText().split("\\|")[1].trim().contains(OrderProperties.getOrderProperty("size")),"Size word is not displayed right");
		});
		softly.assertAll();
	}

	public void subtotalIsSumOfProductPrices()
	{
		final String expectedSubtotal = CurrencyUtils.formatCurrency(calculateSumOfProductPrices());
		final String actualSubtotal = subtotal.getText();
		Assert.assertEquals(expectedSubtotal, actualSubtotal);
	}

	private double calculateSumOfProductPrices()
	{
		return CurrencyUtils.sum(productPrices.stream()
											  .map(ExtWebElement::getText)
											  .collect(Collectors.toList()));
	}

	public void subtotalIsSumOfProductPricesAndSavings()
	{
		 final String expectedSubtotal = CurrencyUtils.formatCurrency(calculateSumOfProductPrices() -
																	  (isElementPresent(TOTAL_SAVINGS_LOCATOR)
																			  ? CurrencyUtils.getValue(totalSavings.getText())
																			  : 0));
		 final String actualSubtotal = subtotal.getText();
		 Assert.assertEquals(expectedSubtotal, actualSubtotal);
	}

	public void deliveryMethodIs(final String method)
	{
		final String expectedDeliveryMethod = OrderProperties.getDeliveryMethod(method);
		final String actualDeliveryMethod = deliveryMethod.getText();
		Assert.assertEquals(expectedDeliveryMethod, actualDeliveryMethod);
	}

	public void deliveryCostIsFree()
	{
		Assert.assertEquals(PropertyConfig.getValue("free"), deliveryCost.getText());
	}

	public void totalPriceIsSumOfSubtotalAndDelivery()
	{
		final String expectedTotal = CurrencyUtils.formattedSum(subtotal.getText(), deliveryCost.getText());
		final String actualTotal = totalPrice.getText();
		Assert.assertEquals(expectedTotal, actualTotal);
	}

	public void totalPriceIsSumOfSubtotalSavingsAndDelivery()
	{
		final String expectedTotal = CurrencyUtils.formattedSum(subtotal.getText(),
																deliveryCost.getText(),
																"-" + totalSavings.getText());
		final String actualTotal = totalPrice.getText();
		Assert.assertEquals(expectedTotal, actualTotal);
	}

	public void savingsAreVisible()
	{
		Assert.assertTrue("Savings are not visible", totalSavings.isVisible());
	}

	public void savingsAreNotVisible()
	{
		Assert.assertFalse("Savings are visible", isElementVisible(TOTAL_SAVINGS_LOCATOR));
	}

	public void deliveryCostIsVisible()
	{
		Assert.assertTrue("Delivery cost is not visible", deliveryCost.isVisible());
	}

	public void subtotalIsVisible()
	{
		Assert.assertTrue("Subtotal is not visible", subtotal.isVisible());
	}

	public void totalPriceIsVisible()
	{
		Assert.assertTrue("Total price is not visible", totalPrice.isVisible());
	}

	public void checkDeliveryDetails(String deliveryMode) {
		waitForPageLoad();
		final SoftAssert softAssert = new SoftAssert();
		if (deliveryMode.equals("orderDetails.homeDelivery.nominatedDeliveryGroup.dateAndTime")) {
			softAssert.assertTrue(deliveryName.getText().contains(PropertyConfig.getValue("orders.delivery.ukDpd")));
			softAssert.assertTrue(deliveryDetails.getText().contains(PropertyConfig.getValue("orders.delivery.ukDpdPrecise")));
			softAssert.assertTrue(deliveryDetails.getText().contains(PropertyConfig.getValue("orders.delivery.ukDpdTime")));
		} else if (deliveryMode.equals("orderDetails.homeDelivery.date")) {
			softAssert.assertTrue(deliveryName.getText().contains(PropertyConfig.getValue("orders.delivery.standard")));
			softAssert.assertTrue(deliveryDetails.getText().contains(PropertyConfig.getValue("orders.delivery.deliveredBy")));
		} else if (deliveryMode.equals("orderDetails.homeDelivery.deliveryPromise")) {
			softAssert.assertTrue(deliveryName.getText().contains(PropertyConfig.getValue("orders.delivery.standard")));
			softAssert.assertTrue(deliveryDetails.getText().contains(PropertyConfig.getValue("orders.delivery.deliveryPromise")));
		}
		softAssert.assertAll();
	}

    public void checkRecipientsNameAndAddress() {
		Assert.assertFalse(orderAddress.getText().isEmpty());
    }

	/**
	 * method to verify the text of Returned status is black or not
	 */
	public void colorForReturnedStatusIsBlack()
	{
		orderStatusColourIs("black");
	}

	/**
	 * method to verify the text of cancelled status is red or not
	 */
	public void colorForCancelledStatusIsRed()
	{
		orderStatusColourIs("red");
	}

	public void orderStatusColourIs(final String colour)
	{
		final String color = orderStatus.getCssValue("color");
		Assert.assertTrue("Color of cancelled status text",
						color.contains(PropertyConfig.getValue("orders.status." + colour)));
	}

	/**
	 * method to verify the track my order button is visible
	 */
	public void trackOrderButtonDisplayed() {
		// wait increased due to wiremock window opening before the main window, page taking time to load
		Assert.assertTrue(isElementPresent(Duration.ofMillis(1500),
				By.cssSelector("[data-testid='trackMyOrderButton']")));
	}

	/**
	 * method to click on track my order button
	 */
	public void clickOnTrackMyOrderButton() {
		clickButton(trackOrderButton);
	}

	/**
	 * method to verify the after click on track my order button its navigating to tracking page URL
	 */
	public void clickNavigationOnTrackingURL() {
		waitForPageLoad();
		DeviceUtils.waitIfIphone(4000);
		DeviceUtils.waitIfIpad(4000);
		AssertUtils.assertContains(getCurrentUrl(), PropertyConfig.getValue("orders.trackingPageUrl"));
	}

	private String getOrderStatusColour(final ExtWebElement status)
	{
		return status.findBy(ORDER_STATUS_COLOUR_LOCATOR).getCssValue("background-color");
	}

	public void orderStatusesHaveTheCorrectColours()
	{
		boolean passedCurrentStatus = false;
		for (final ExtWebElement status : orderStatuses)
		{
			if (!passedCurrentStatus)
			{
				if (status.getAttribute("class").contains("completed"))
				{
					// Before we have reached the current status, the status should be green
					Assert.assertTrue(String.format("Status %s is the wrong colour", status.getText()),
									  getOrderStatusColour(status).contains(PropertyConfig.getValue(
											  "orders.status.green")));

				}
				else
				{
					// If we get here, we are at the current status, which should be orange
					Assert.assertTrue(String.format("Status %s is the wrong colour", status.getText()),
									  getOrderStatusColour(status).contains(PropertyConfig.getValue(
											  "orders.status.orange")));
					passedCurrentStatus = true;
				}
			}
			else
			{
				// Once we have passed the current status, the status should be white
				Assert.assertTrue(String.format("Status %s is the wrong colour", status.getText()),
								  getOrderStatusColour(status).contains(PropertyConfig.getValue("orders.status.white")));
			}
		}
	}

    public void verifyTheReturnedNotCollectedMessage() {
    	Assert.assertEquals(PropertyConfig.getValue("orders.returned.notcollected.message"), returnedMessage.getText());
    }

    public void verifyTrackMyOrderText() {
    	Assert.assertEquals(PropertyConfig.getValue("orders.track.myorder.text"), trackOrderButton.getText());
    }
}
