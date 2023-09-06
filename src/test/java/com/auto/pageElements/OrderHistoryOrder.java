package com.auto.pageElements;

import com.automation.core.base.ExtWebElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@AllArgsConstructor
@Getter
@Setter
public class OrderHistoryOrder
{
	private static final By DATE_LOCATOR = By.cssSelector("[data-testid^='myAccountOrdersTableDate']");
	private static final By ID_LOCATOR = By.cssSelector("[data-testid^='myAccountOrdersTableId']");
	private static final By ITEM_COUNT_LOCATOR = By.cssSelector("[data-testid^='myAccountOrdersTableItems']");
	private static final By PRICE_LOCATOR = By.cssSelector("[data-testid^='myAccountOrdersTableTotal']");
	private static final By STATUS_LOCATOR = By.cssSelector("[data-testid*='myAccountOrdersTableStatus']");
	private static final By VIEW_ORDER_LOCATOR = By.cssSelector("[data-testid^='viewOrderLink']");

	private ExtWebElement date;
	private ExtWebElement id;
	private ExtWebElement itemCount;
	private ExtWebElement price;
	private ExtWebElement status;
	private ExtWebElement viewOrderLink;

	public static OrderHistoryOrder generate(ExtWebElement element)
	{
		final ExtWebElement date = element.findBy(DATE_LOCATOR);
		final ExtWebElement id = element.findBy(ID_LOCATOR);
		final ExtWebElement itemCount = element.findBy(ITEM_COUNT_LOCATOR);
		final ExtWebElement price = element.findBy(PRICE_LOCATOR);
		final ExtWebElement status = element.findBy(STATUS_LOCATOR);
		final ExtWebElement viewOrderLink = element.findBy(VIEW_ORDER_LOCATOR);

		return new OrderHistoryOrder(date, id, itemCount, price, status, viewOrderLink);
	}
}
