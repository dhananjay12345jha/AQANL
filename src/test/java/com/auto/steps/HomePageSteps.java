package com.auto.steps;

import com.auto.pages.HomePage;
import com.auto.pages.MyAccountHomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageSteps {

    @Autowired
    HomePage homePage;

    @Autowired
    MyAccountHomePage myAccountHomePage;

    @Then("verify the details on homepage")
    public void verifyTheDetailsOnHomepage() throws ParseException {
        homePage.verifyHomepageElements();
    }

    @When("^User clicks on (De|En) button$")
    public void userClickOnDeButton(String language) {
        homePage.clickLanguageButton(language);
    }

    @Then("^page language changes to (de|en)$")
    public void pageLanguageChanges(String language) {
        homePage.verifyLanguage(language);
    }

}