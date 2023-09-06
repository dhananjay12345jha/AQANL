package com.auto.steps;

import com.auto.pages.DataLayerPage;
import com.auto.pages.HeaderPage;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

public class DataLayerStepsDef implements En  {

    @Autowired
    DataLayerPage dataLayerPage;

    @Autowired
	HeaderPage headerPage;

    public DataLayerStepsDef() {
        Then("^head.script tagmanager script is present in the innerhtml$", () -> dataLayerPage.verifyHeadGTMScriptInPage("head.script"));
        And("^body.noscript tagmanager script is present in the innerhtml$", () -> dataLayerPage.verifyHeadGTMNoscriptInPage("body.noscript"));
        Then("^The (.*) script is present in the (head|body) of the site$", (final String script, final String location) -> dataLayerPage.scriptIsPresent(script, location));
        Then("^The dataLayer is (enabled|disabled)$", (final String enabledOrDisabled) -> dataLayerPage.dataLayerIsEnabledOrDisabled(enabledOrDisabled));
		Then("^The data layer core variables are populated$", () -> dataLayerPage.coreVariablesArePopulated());
		Then("^The data layer breadcrumb property is updated$", () -> dataLayerPage.dataLayerBreadcrumbPropertyIsCorrect());
		And("^The data layer title property is updated$", () -> dataLayerPage.dataLayerTitlePropertyIsCorrect());
		And("^The data layer (.*) event is populated with the (.*) variables$", (final String event, final String variables) -> {dataLayerPage.eventIsPopulatedWithVariables(event, variables);});
	}
}
