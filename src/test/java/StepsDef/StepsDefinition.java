package StepsDef;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;

public class StepsDefinition extends Base{

    @Given("I open the BBC Sport Grand Prix home page")
    public void i_open_the_bbc_sport_grand_prix_home_page() {
        homePage.verifyHomePage();
    }
    @When("I click on search icon")
    public void i_click_on_search_icon() {
        homePage.clickSearchIcon();
    }
    @When("I search for {string}")
    public void i_search_for(String searchText) {
        searchPage.searchFor(searchText);
    }

    @Then("I should see {string} in First place")
    public void iShouldSeeInFirstPlace(String expectedTitle) {
        searchPage.verifyFirstPlaceResult(expectedTitle);
    }

    @And("I should see {string} in Second place")
    public void iShouldSeeInSecondPlace(String expectedTitle) {
        searchPage.verifySecondPlaceResult(expectedTitle);
    }

    @And("I should see {string} in Third place")
    public void iShouldSeeInThirdPlace(String expectedTitle) {
        searchPage.verifyThirdPlaceResult(expectedTitle);
    }

    @Then("I should see at least {int} relevant search results")
    public void i_should_see_at_least_relevant_search_results(Integer expectedMinimum) {
        searchResults.verifySearchResultsCount(expectedMinimum);
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

//    @After
//    public void quitBrowser() {
//        driver.quit();
//    }


}
