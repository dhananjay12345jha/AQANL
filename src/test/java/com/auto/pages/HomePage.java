package com.auto.pages;

import com.auto.base.BasePage;
import com.auto.config.PropertyConfig;
import com.automation.core.base.ExtWebElement;
import com.automation.core.utilities.Sleeper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class HomePage extends BasePage {
    @Autowired
    PropertyConfig props;

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(HomePage.class);
    private String languageButton = "[data-testId=changeLanguageTo%sButton]";

    @FindBy(css = "[data-testid='headerText']")
    private ExtWebElement headerText;

    @FindBy(css = "[data-testid='contentText']")
    private ExtWebElement contentText;

    @FindBy(css = "[data-testid='cmsData']")
    private ExtWebElement cmsDataResponse;

    @FindBy(css = "[data-testid='storeConfigOutput']")
    private ExtWebElement storeConfigResponse;

    @FindBy(css="[data-testid=cmsContent]")
    private ExtWebElement cmsComponents;

    public void verifyHomepageElements() throws ParseException {
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(find(By.cssSelector(String.format(languageButton,"De"))).isDisplayed());
        softly.assertTrue(find(By.cssSelector(String.format(languageButton,"En"))).isDisplayed());
//        JSONObject json = (JSONObject) new JSONParser().parse(( new JSONParser().parse(cmsDataResponse.getText())).toString());
//        softly.assertFalse(json.toString().equals("{}"),"CMS Data missing");
        softly.assertFalse(new JSONParser().parse(storeConfigResponse.getText()).toString().equals("{}"),"Store Config Json Data missing");
//        softly.assertTrue(cmsComponents.getText().contains("Component"),"components list missing at bottom of page");
        softly.assertAll();
    }

    public void clickLanguageButton(String language){
        click(By.cssSelector(String.format(languageButton,language)));
    }

    public void verifyLanguage(String  language){
        Sleeper.sleep(200);
        String header = language.equalsIgnoreCase("de") ? "Ein einfaches Beispiel [DE]" : "A simple example";
        String content = language.equalsIgnoreCase("de") ? "Hauptüberschrift" : "This is a main heading";
        Assert.assertEquals(content, contentText.getText());
        Assert.assertEquals(header,headerText.getText());
    }
}


