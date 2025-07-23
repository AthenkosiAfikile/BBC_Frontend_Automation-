package Screens;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BBCSearchResults {
    WebDriver driver;
    Scenario scenario;
    @FindBy(xpath = "count(//ul[@role='list']/li)\n")
    List<WebElement> searchResults;
    public BBCSearchResults(WebDriver driver) {
        this.driver = driver;
    }

    public void verifySearchResultsCount(int expectedMinimum) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(searchResults));

            int actualCount = searchResults.size();
            String msg = "Found " + actualCount + " search results.";

            if (actualCount >= expectedMinimum) {
                scenario.attach((msg + "Meets minimum requirement: " + expectedMinimum).getBytes(), "text/plain", "Search Results Check");
            } else {
                msg += "Fewer results than expected: Required " + expectedMinimum;
                scenario.attach(msg.getBytes(), "text/plain", "Search Results Check");
                Assert.fail(msg);
            }

        } catch (Exception e) {
            String error = "Error verifying search results: " + e.getMessage();
            scenario.attach(error.getBytes(), "text/plain", "Exception");
            Assert.fail(error);
        }
    }



}
