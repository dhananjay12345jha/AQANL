package com.auto.steps;

import com.auto.pages.HomePage;
import com.auto.pages.PDPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

public class PDPageSteps {

    @Autowired
    PDPage pdPage;

    @Then("Page has the product details")
    public void pageHasTheProductDetails() throws ParseException {
        pdPage.verifyProductDetails();
    }
}