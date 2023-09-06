package com.auto.steps;


import com.auto.pages.OrderDetailsPage;
import com.auto.props.OrderProperties;
import com.auto.utils.DeviceUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailsStepsDef implements En {

    @Autowired
    OrderDetailsPage orderDetailsPage;

    public OrderDetailsStepsDef() {

        And("^Order Details displayed$", () -> orderDetailsPage.orderDetailsDisplayed());
        And("^track my order link is not displayed$", () -> orderDetailsPage.trackOrderButtonNotDisplayed());
        Then("^applied (.*) message is displayed$", (String messageType) -> orderDetailsPage.discountMsgDisplayed(messageType));
        Then("^check order payment records of (.*)$", (String type) -> orderDetailsPage.checkOrderPaymentRecords(type));
        And("^I see the recipients full name and address$", () -> orderDetailsPage.checkRecipientsNameAndAddress());
		Then("^I see the delivery details of the order for (.*)$", (String deliveryMode) -> orderDetailsPage.checkDeliveryDetails(deliveryMode));
        Then("^check order refund records of (.*)$", (String type) -> orderDetailsPage.checkOrderRefundRecords(type));
        Then("^check order with no refund records$", () -> orderDetailsPage.checkOrderNoRefundRecords());
        And("^track my order link is displayed$", () -> orderDetailsPage.trackOrderButtonDisplayed());
		And("^Order Details match the first order$", () -> orderDetailsPage.verifyOrderDetailsOfFirstOrder());
	}

	@When("^The (.*) order statuses are visible in order$")
	public void theOrderStatusesAreVisibleInOrder(final String deliveryMethod)
	{
		DeviceUtils.waitIfIphone(1000);
		orderDetailsPage.orderStatusesAreVisibleInOrder(deliveryMethod);
	}

	@And("The current order status is highlighted")
	public void theCurrentOrderStatusIsHighlighted()
	{
		orderDetailsPage.currentOrderStatusIsHighlighted();
	}

	@Then("The order status timeline is not visible")
	public void theOrderStatusTimelineIsNotVisible()
	{
		orderDetailsPage.orderStatusTimelineIsNotVisible();
	}

	@And("^The order status is (.*)$")
	public void theOrderStatusIs(final String status)
	{
		orderDetailsPage.orderStatusIs(OrderProperties.getOrderStatus(status));
	}

	@And("^The description of (.*) status is visible$")
	public void theDescriptionOfStatusIsVisible(final String status)
	{
		orderDetailsPage.statusDescriptionIsVisible(status);
	}

	@Then("The map with the collection point is visible as a static image")
	public void theMapWithTheCollectionPointIsVisibleAsAStaticImage()
	{
		orderDetailsPage.collectionPointIsVisibleAsAStaticMap();
	}

	@And("The open map CTA is visible")
	public void theOpenMapCTAIsVisible()
	{
		orderDetailsPage.openMapCtaIsVisible();
	}

	@And("The open map CTA links to Google Maps")
	public void theOpenMapCTALinksToGoogleMaps()
	{
		orderDetailsPage.openMapCtaLinksToGoogleMaps();
	}

	@And("The static map links to Google Maps")
	public void theStaticMapLinksToGoogleMaps()
	{
		orderDetailsPage.staticMapLinksToGoogleMaps();
	}

	@Then("The map with the collection point is visible as a dynamic map")
	public void theMapWithTheCollectionPointIsVisibleAsADynamicMap()
	{
		orderDetailsPage.collectionPointIsVisibleAsADynamicMap();
	}

	@Then("The map with the collection point is visible")
	public void theMapWithTheCollectionPointIsVisible()
	{
		if (orderDetailsPage.isMobile() || orderDetailsPage.isTablet())
		{
			theMapWithTheCollectionPointIsVisibleAsAStaticImage();
		}
		else
		{
			theMapWithTheCollectionPointIsVisibleAsADynamicMap();
		}
	}

	@And("returns link is displayed")
	public void returnsLinkIsDisplayed() {
		orderDetailsPage.returnsLinkIsDisplayed();
	}

	@And("returns help page is opened on clicking returns link")
	public void returnsHelpPageIsOpenedOnClickingReturnsLink() {
		orderDetailsPage.clickReturnsButton();
		orderDetailsPage.verifyReturnsHelpUrl();
	}
    @And("check order payment records")
    public void checkOrderPaymentRecords() {
		orderDetailsPage.checkPaymentRecords();
    }

	@Then("The subtotal is the sum of all product prices")
	public void theSubtotalIsTheSumOfAllProductPrices()
	{
		orderDetailsPage.subtotalIsSumOfProductPrices();
	}

	@Then("The subtotal is the sum of all product prices and savings")
	public void theSubtotalIsTheSumOfAllProductPricesAndSavings()
	{
		orderDetailsPage.subtotalIsSumOfProductPricesAndSavings();
	}

	@And("^The delivery method is (.*)$")
	public void theDeliveryMethodIs(final String deliveryMethod)
	{
		orderDetailsPage.deliveryMethodIs(deliveryMethod);
	}

	@And("The delivery cost is free")
	public void theDeliveryCostIsFree()
	{
		orderDetailsPage.deliveryCostIsFree();
	}

	@And("The total price is the sum of subtotal and delivery")
	public void theTotalPriceIsTheSumOfSubtotalAndDelivery()
	{
		orderDetailsPage.totalPriceIsSumOfSubtotalAndDelivery();
	}

	@And("The savings are visible")
	public void theSavingsAreVisible()
	{
		orderDetailsPage.savingsAreVisible();
	}

	@And("The delivery cost is visible")
	public void theDeliveryCostIsVisible()
	{
		orderDetailsPage.deliveryCostIsVisible();
	}

	@And("The savings are not visible")
	public void theSavingsAreNotVisible()
	{
		orderDetailsPage.savingsAreNotVisible();
	}

	@And("The subtotal is visible")
	public void theSubtotalIsVisible()
	{
		orderDetailsPage.subtotalIsVisible();
	}

	@And("The total price is visible")
	public void theTotalPriceIsVisible()
	{
		orderDetailsPage.totalPriceIsVisible();
	}

	@Then("^(\\d+) items displayed with  image, size, (.*) and (\\d+)$")
	public void itemsItemsDisplayedWithImageSizeStatusAndQuantity(int itemsCount, int status, int qty) {
		orderDetailsPage.verifyOrderItemsProps(itemsCount,status,qty);
	}

	@And("^The order status colour is (.*)$")
	public void theOrderStatusColourIs(final String colour)
	{
		orderDetailsPage.orderStatusColourIs(colour);
	}
	
	/**
	 * step to click on track my order button
	 */
	@And("click on track my order link")
	public void clickOnTrackMyOrderButton()
	{
		orderDetailsPage.clickOnTrackMyOrderButton();
	}
	
	/**
	 * step to check after click on track my order button its navigating to tracking page URL
	 */
	@And("I see my orders delivery tracking page as per the URL")
	public void checkNavigationOnTrackingURL()
	{
		orderDetailsPage.clickNavigationOnTrackingURL();
	}

	@And("The order statuses have the correct colours")
	public void theOrderStatusesHaveTheCorrectColours()
	{
		orderDetailsPage.orderStatusesHaveTheCorrectColours();
	}
	
	@Then("I see the returned not collected  message displaying")
	public void verifyTheReturnedNotCollectedMessage() {
		orderDetailsPage.verifyTheReturnedNotCollectedMessage();
	}
	
	@Then("I see the track my order traslation per selected language")
	public void verifyTrackMyOrderText() {
		orderDetailsPage.verifyTrackMyOrderText();
	}

}
