package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.automation.core.base.ExtWebElement;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("file:src/test/resources/env/${env:dev}.properties")
public class PDPage extends BasePage {


    @Value("#{systemProperties['hostName']}")
    protected String baseURL;

    @Autowired
    PropertyConfig props;

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(PDPage.class);

    @FindBy(css = "[data-testid='response']")
    private ExtWebElement response;

    @FindBy(css = "[data-testid='link'] a")
    private ExtWebElement homeLink;

    public void verifyProductDetails() throws ParseException {
        Assert.assertNotEquals(response.getText(),"{}");
        Assert.assertEquals("3620420",  ((JSONObject) new JSONParser().parse(response.getText())).get("code"));
        Assert.assertEquals(System.getProperty("hostName")+"/", homeLink.getAttribute("href"));
    }
}


