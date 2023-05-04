package pages.LimundoShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LimundoHomePage extends BaseHelper {
    WebDriver driver;

    public LimundoHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "txtPretraga")
    WebElement inputSearchField;
    @FindBy(id = "button-addon2")
    WebElement submitButton;


    private void navigateToPage(String url) {
        driver.get(url);
    }

    private void inputSearchTerm(String url) {
        inputSearchField.sendKeys(url);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("autocomplete")));
    }

    private void clickOnSubmit() {
        submitButton.click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("accordion")));
    }


    public void searchLimundoTest(String url, String searchTerm) {
        navigateToPage(url);
        inputSearchTerm(searchTerm);
        clickOnSubmit();

    }
}
