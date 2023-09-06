package com.auto.base;

import com.auto.dataLayer.DataLayer;
import com.auto.props.CssProperties;
import com.auto.utils.DeviceUtils;
import com.auto.utils.DurationUtil;
import com.automation.core.base.ExtWebElement;
import com.automation.core.common.Page;
import com.automation.core.utilities.assertion.AssertUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasePage extends Page {

    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    @FindBy(css = ".MuiBox-root > span > a")
    protected List<ExtWebElement> breadcrumbLinks;

    @FindBy(css = "[role='menuitem']")
    protected ExtWebElement expandedBreadcrumb;

    public void clickButton(ExtWebElement element){
        try{
            moveTo(element);
            element.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException exception) {
            element.jsClick();
        }
    }

    public void moveAndClickElement(By element){
        until(Duration.ofSeconds(DurationUtil.LONG1SEC), ExpectedConditions.elementToBeClickable(element));
        moveAndClick(element);
    }

    public void setValue(By by, String text){
            clear(find(by));
            find(by).sendKeys(text);
    }


    public void scrollToCenter(WebElement element){
        jsExecutor("arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"}))",element);
    }


    public void moveAndClickElement(ExtWebElement element){
       moveAndClick(element);
    }

    public void moveToElement(By by){
        moveTo(by);
    }

    public void moveToElement(ExtWebElement webElement){
        moveTo(webElement);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    // Data layer code

    public List<Map<String, Object>> getDataLayerAfterJSScript(final String prescript)
    {
        waitForPageLoad();
        try
        {
            return (List<Map<String, Object>>) getDriver().executeScript(prescript + "return dataLayer;");
        }
        catch (final JavascriptException ex)
        {
            LOG.debug("Data layer not loaded", ex);
            return null;
        }
    }

    public DataLayer getDataLayer()
    {
        return getDataLayerMap("");
    }

    public DataLayer getDataLayerMap(final String prescript)
    {
        return new DataLayer(getDataLayerAfterJSScript(prescript));
    }

    protected List<String> getVisibleBreadcrumbLinks()
    {
        return breadcrumbLinks.stream()
                              .map(ExtWebElement::getText)
                              .collect(Collectors.toList());
    }
    protected void checkCssValues(final ExtWebElement element, final String style)
    {
        // Safari treats colours slightly differently - it uses RGB rather than RGBA
        final String prefix;
        if (DeviceUtils.isSafari())
        {
            prefix = ".safari";
        }
        else
        {
            prefix = "";
        }

        if (isMobile())
        {
            Assert.assertEquals(CssProperties.getCssMobileProperty(style + prefix + ".colour"), element.getCssValue("color"));
            Assert.assertEquals(CssProperties.getCssMobileProperty(style + ".font-size"), element.getCssValue("font-size"));
            AssertUtils.assertContains(element.getCssValue("font-family"), CssProperties.getCssMobileProperty(style + ".font-family"));
        }
        else
        {
            Assert.assertEquals(CssProperties.getCssProperty(style + prefix + ".colour"), element.getCssValue("color"));
            Assert.assertEquals(CssProperties.getCssProperty(style + ".font-size"), element.getCssValue("font-size"));
            AssertUtils.assertContains(element.getCssValue("font-family"), CssProperties.getCssProperty(style + ".font-family"));
        }
    }

    public void clickWithinElementWithXYCoordinates(int x, int y) {
        Actions builder = new Actions(getDriver());
        builder.moveByOffset(x, y);
        builder.click();
        builder.perform();
    }
}
