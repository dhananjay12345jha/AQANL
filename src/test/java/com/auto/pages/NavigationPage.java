package com.auto.pages;

import com.auto.base.BasePage;
import com.automation.core.base.ExtWebElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


@PropertySource("file:src/test/resources/env/${env:dev}.properties")
public class NavigationPage extends BasePage {

    @Value("#{systemProperties['hostName']}")
    protected String baseURL;

    @FindBy(css = "[data-testid='link'] a")
    private ExtWebElement homeLink;


    public void verifyPageNameAndHomeLink(String pageName){
        Assert.assertTrue(find(By.cssSelector(String.format("[data-testid='%s']",pageName))).getText().contains(pageName));
        Assert.assertEquals("/", homeLink.getAttribute("href"));
    }

}
