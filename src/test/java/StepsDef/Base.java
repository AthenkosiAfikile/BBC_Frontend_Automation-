package StepsDef;

import Screens.BBCHomePage;
import Screens.BBCSearchPage;
import Screens.BBCSearchResults;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();

    WebDriver driver = browserFactory.startBrowser("chrome", "https://www.bbc.com/sport");
    BBCHomePage homePage = PageFactory.initElements(driver, BBCHomePage.class);
    BBCSearchPage searchPage = PageFactory.initElements(driver, BBCSearchPage.class);
    BBCSearchResults searchResults = PageFactory.initElements(driver, BBCSearchResults.class);

}
