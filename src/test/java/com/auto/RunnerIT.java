package com.auto;

import com.automation.core.allure.Report;
import com.automation.core.config.CoreConfig;
import com.automation.core.driver.CoreAppiumDriver;
import com.automation.core.driver.CoreDriver;
import com.automation.core.driver.CoreIOSDriver;
import com.automation.core.driver.CoreWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"com.auto"},
        strict = true
)

public class RunnerIT extends AbstractTestNGCucumberTests {

    private static Integer count = 0;
    @Autowired(required = false)
    CoreDriver coreDriver;
    @Autowired(required = false)
    CoreIOSDriver coreiOSDriver;
    @Autowired(required = false)
    CoreAppiumDriver coreAppiumDriver;

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Parameters(value = {"config", "environment"})
    @BeforeClass
    public void setUpScenario(String configFile, String environment) throws Exception {

        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/config/" + configFile));
        JSONObject envs = (JSONObject) config.get("environments");

        setCaps((Map<String, Object>) envs.get(environment), "core_ENV#");
        setCaps((Map<String, Object>) config.get("capabilities"), "core_ENV#");
        setCaps((Map<String, Object>) config.get("configuration"), "");

        if(System.getenv("BUILD_TAG") != null)
            System.setProperty("core_ENV#build", System.getenv("BUILD_TAG"));

        if (System.getProperty("mode").equalsIgnoreCase("browserstack") &&
                System.getProperty("core_ENV#deviceType").equalsIgnoreCase("desktop")) {
            System.setProperty("core_ENV#browserName", System.getProperty("core_ENV#browser"));
        }
    }

    private void setCaps(Map<String, Object> caps, String prefix) {
        if (caps != null) {
            for (Map.Entry<String, Object> entry : caps.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue().toString();
                System.setProperty(prefix + k, v);
            }
        }
    }

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("Currently executing -> " + ++count + "." + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        CoreDriver driver = coreiOSDriver == null ?  (coreAppiumDriver == null ? coreDriver:coreAppiumDriver) : coreiOSDriver;
        //ToDo: Need to use this method for something
        if ((System.getProperty("mode").equalsIgnoreCase("browserstack")) && System.getProperty("core_ENV#deviceType").equalsIgnoreCase("desktop")) {
            final String session = CoreWebDriver.sessionID.get();
            Report.addText("Session ID", session);
//            SauceLabsUtils.testPassesdesktop(session ,!scenario.isFailed(),System.getProperty("BROWSERSTACK_USERNAME"),System.getProperty("BROWSERSTACK_ACCESS_KEY"),scenario.getName());
        }

        if (scenario.isFailed()) {
            try {
                CoreConfig.takeScreenshot(driver);
            } catch (Throwable e) {
                driver.executeScript("window.scrollTo(0, 0)");
                byte[] imageInByte = ((TakesScreenshot) driver.getWrappedDriver()).getScreenshotAs(OutputType.BYTES);
                Report.addScreenshotAsImage("failure screen", imageInByte);
            }
        }
    }

    @Parameters(value = {"environment"})
    @AfterSuite
    public void prepareAllure(String environment) {
        String allure_env = "URL=" + System.getProperty("hostName") + "\nPlatform_Browser=" + environment + "\nEnvironment=" + System.getProperty("env") +
                    "\nTest_tags=" + System.getProperty("cucumber.filter.tags").substring(1);

        Path path = Paths.get("." + File.separator + "target" + File.separator + "allure-results" + File.separator + "environment.properties");
        Path category_sourcepath = Paths.get("." + File.separator + "categories.json");
        Path category_destinationepath = Paths.get("." + File.separator + "target" + File.separator + "allure-results" + File.separator + "categories.json");
        try {
            Files.write(path, allure_env.getBytes());
            Files.copy(category_sourcepath, category_destinationepath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
