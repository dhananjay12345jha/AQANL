package com.auto.steps;

import com.auto.pages.CommonPage;
import com.auto.pages.NavigationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class PageNavigationSteps {

    @Autowired
    NavigationPage navigationPage;

    @Autowired
    CommonPage commonPage;



    @Then("^(.*) name is displayed$")
    public void pagenameNameIsDisplayed(String pageName) {
        navigationPage.verifyPageNameAndHomeLink(pageName);
    }
}