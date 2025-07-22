package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BBCHomePage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='ssrcss-1u47p8g-LinkTextContainer eis6szr1' and text()='Home']")
    WebElement TabHome_xpath;

    @FindBy(xpath = "//*[@id=\"global-navigation\"]/div[3]")
    WebElement SearchIcon_xpath;
    public BBCHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    public void verifyHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(TabHome_xpath));
        TabHome_xpath.isDisplayed();
    }
    public void clickSearchIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(SearchIcon_xpath));
        SearchIcon_xpath.click();
    }

}
