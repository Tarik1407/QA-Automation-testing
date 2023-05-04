package pages.SportdirectShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportdirectHomePage extends BaseHelper {
    WebDriver driver;

    public SportdirectHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtSearch") WebElement inputFieldSearch;
    @FindBy(id = "cmdSearch") WebElement searchButton;

    private void navigateToPage(String url) {
        driver.get(url);
    }

    private void acceptCookies() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> cookiesButton = driver.findElements(By.id("onetrust-accept-btn-handler"));
        if (cookiesButton.size() != 0) {
            wdWait.until(ExpectedConditions.elementToBeClickable(cookiesButton.get(0)));
            cookiesButton.get(0).click();
            wdWait.until(ExpectedConditions.invisibilityOf(cookiesButton.get(0)));
        }
        System.out.println("Accept cookie:" + cookiesButton.size());
    }

    private void inputSearchTerm(String searchTerm) {
        inputFieldSearch.sendKeys(searchTerm);
    }
    private void clickOnSearchButton(){
        searchButton.click();
    }

    public void sportdirectHomeTesting(String url, String searchTerm) throws InterruptedException {
        navigateToPage(url);
        acceptCookies();
        inputSearchTerm(searchTerm);
        clickOnSearchButton();
    }
}
