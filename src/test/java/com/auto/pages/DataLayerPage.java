package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.dataLayer.DataLayer;
import com.auto.props.DataLayerProperties;
import com.auto.props.FooterProperties;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import com.automation.core.utilities.assertion.AssertUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.testng.asserts.SoftAssert;
import org.testng.util.Strings;

import java.util.Objects;


@PropertySource("file:src/test/resources/env/${env:dev}.properties")
@Slf4j
public class DataLayerPage extends BasePage
{
	public static final String HEAD = "head";
	public static final String BODY = "body";

	@Value("#{systemProperties['hostName']}")
	protected String baseURL;

	@FindBy(css = "head")
	private ExtWebElement head;

	@FindBy(css = "head script")
	private ExtWebElement headScript;

	@FindBy(css = "body")
	private ExtWebElement body;

	@FindBy(css = "body noscript")
	private ExtWebElement bodyNoScript;

	private String getUserAgent()
	{
		return (String) executeScript("return navigator.userAgent;");
	}

	public void verifyHeadGTMScriptInPage(final String scriptType)
	{
		final String htmlCode = headScript.getInnerHtml();
		Assert.assertEquals("Head Script is not as in the properties file",
							DataLayerProperties.getDataLayerProperty(scriptType),
							htmlCode.replace("\n", ""));
	}

	public void verifyHeadGTMNoscriptInPage(final String scriptType)
	{
		final String htmlCode = bodyNoScript.getInnerHtml();
		Assert.assertEquals("Body Script is not as in the properties file",
							DataLayerProperties.getDataLayerProperty(scriptType),
							htmlCode.replace("\n", ""));
	}

	public void scriptIsPresent(final String script, final String location)
	{
		final String htmlCode;
		if (HEAD.equalsIgnoreCase(location))
		{
			htmlCode = head.getInnerHtml().replace("\n", "");
		}
		else if (BODY.equalsIgnoreCase(location))
		{
			htmlCode = body.getInnerHtml().replace("\n", "");
		}
		else
		{
			throw new IllegalArgumentException("Location not recognised: " + location);
		}

		Assert.assertTrue(String.format("Script is not present in %s: %s", location, script),
						  htmlCode.contains(DataLayerProperties.getDataLayerProperty(script)));
	}

	public boolean isDataLayerEnabled()
	{
		return Objects.nonNull(getDataLayerAfterJSScript(""));
	}

	public void dataLayerIsEnabledOrDisabled(final String enabledOrDisabled)
	{
		Assert.assertEquals("enabled".equals(enabledOrDisabled), isDataLayerEnabled());
	}

	public void coreVariablesArePopulated()
	{
		Sleeper.sleep(2000);
		final DataLayer expectedDataLayer = new DataLayer(DataLayerProperties.getDataLayerJson());
		populateDynamicVariables(expectedDataLayer);

		assertDataLayerContains(getDataLayer(), expectedDataLayer);
	}

	private void populateDynamicVariables(final DataLayer dataLayer)
	{
		// Breadcrumb
		final String expectedBreadcrumbProperty = Strings.join(" > ", getVisibleBreadcrumbLinks().toArray(String[]::new));
		dataLayer.put(DataLayerProperties.BREADCRUMB, expectedBreadcrumbProperty);

		// Page title
		dataLayer.put(DataLayerProperties.TITLE, getTitle());

		// User agent
		dataLayer.put(DataLayerProperties.USER_AGENT, getUserAgent());
	}

	private void populateDynamicVariables(final DataLayer dataLayer, final String variables)
	{
		// TODO: Find a nicer way to deal with dynamic/localised variables
		if ("formError".equalsIgnoreCase(variables))
		{
			dataLayer.put(DataLayerProperties.ERROR_MESSAGE, FooterProperties.getNewsletterSignUpErrorMessage());
		}
	}

	public void assertDataLayerContains(final DataLayer dataLayer,
										final DataLayer expected)
	{
		final SoftAssert softAssert = new SoftAssert();
		for (final String property : expected.getKeys())
		{
			softAssert.assertEquals(dataLayer.get(property),
									expected.get(property),
									"Property not correct: " + property);
		}
		softAssert.assertAll();
	}

	public void assertDataLayerMatches(final DataLayer dataLayer,
									   final DataLayer expected)
	{
		for (final String property : expected.getKeys())
		{
			AssertUtils.assertMatches(expected.get(property),
									  dataLayer.get(property));
		}
	}

	public void dataLayerBreadcrumbPropertyIsCorrect()
	{
		final String expectedBreadcrumbProperty = Strings.join(" > ", getVisibleBreadcrumbLinks().toArray(String[]::new));

		// If the breadcrumb is too long, we replace the start with ...
		if (expectedBreadcrumbProperty.startsWith("..."))
		{
			breadcrumbLinks.get(0).click();
			Assert.assertEquals(expectedBreadcrumbProperty.replaceAll("\\.\\.\\. /", expandedBreadcrumb.getText()),
								getDataLayer().get(DataLayerProperties.BREADCRUMB));
		}
		else
		{
			Assert.assertEquals(expectedBreadcrumbProperty, getDataLayer().get(DataLayerProperties.BREADCRUMB));
		}
	}

	public void dataLayerTitlePropertyIsCorrect()
	{
		Assert.assertEquals(getTitle(),
							getDataLayer().get(DataLayerProperties.TITLE));
	}

	public void eventIsPopulatedWithVariables(final String event, final String variables)
	{
		Sleeper.sleep(2000);
		final DataLayer expectedDataLayer = new DataLayer(DataLayerProperties.getDataLayerJson(event, variables));
		populateDynamicVariables(expectedDataLayer, variables);

		assertDataLayerMatches(getDataLayer(), expectedDataLayer);
	}
}
