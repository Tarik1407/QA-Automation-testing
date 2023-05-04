package pages.OlxShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OlxHomePage extends BaseHelper {
    WebDriver driver;

    public OlxHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "notASearchField") WebElement inputField;
    @FindBy(className = "searchbar-dropdown") WebElement searchButtonDropdownContainer;
    private void navigateToPage(String url){
        driver.get(url);
    }
    private void acceptCookie() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> cookieButton=driver.findElements(By.className("cookie-consent-compliance"));
        if(cookieButton.size()!=0){
            wdWait.until(ExpectedConditions.elementToBeClickable(cookieButton.get(0)));
            cookieButton.get(0).click();
            wdWait.until(ExpectedConditions.invisibilityOf(cookieButton.get(0)));
        }
        System.out.println("Accept cookie: " + cookieButton.size());
    }
    private void inputSearchTerm(String searchTerm){
        inputField.sendKeys(searchTerm);

    }
    private void clickOnSearchButton(){
        inputField.sendKeys(Keys.ENTER);
    }
    public void olxHomeTestingPage(String url,String searchTerm) throws InterruptedException {
        navigateToPage(url);
        acceptCookie();
        inputSearchTerm(searchTerm);
        clickOnSearchButton();
        Thread.sleep(2000);
    }
}
