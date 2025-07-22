package Screens;

import io.cucumber.messages.types.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;


public class BBCSearchPage {
    WebDriver driver;
    Scenario scenario;

    @FindBy(xpath = "//*[@id='searchInput']")
    WebElement SearchField_xpath;

    @FindBy(xpath = "//a[contains(@href, '67402152')]")
    WebElement firstPlaceResult;

    @FindBy(xpath = "//a[contains(@href, '60932994')]")
    WebElement secondPlaceResult;

    @FindBy(xpath = "//a[contains(@href, 'cp3n0kgqvv8o')]")
    WebElement thirdPlaceResult;

    public BBCSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String searchText) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(SearchField_xpath));
        SearchField_xpath.click();
        SearchField_xpath.sendKeys(searchText);
        SearchField_xpath.submit();
    }

    public void verifyFirstPlaceResult(String expectedTitle) {
        String actualTitle = firstPlaceResult.getText();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected first place: " + expectedTitle + ", but got: " + actualTitle);
        }
    }

    public void verifySecondPlaceResult(String expectedTitle) {
        String actualTitle = secondPlaceResult.getText();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected second place: " + expectedTitle + ", but got: " + actualTitle);
        }
    }

    public void verifyThirdPlaceResult(String expectedTitle) {
        String actualTitle = thirdPlaceResult.getText();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected third place: " + expectedTitle + ", but got: " + actualTitle);
        }
    }

}
