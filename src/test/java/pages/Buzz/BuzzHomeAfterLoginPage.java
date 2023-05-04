package pages.Buzz;

import helpers.BaseHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BuzzHomeAfterLoginPage extends BaseHelper {
    WebDriver driver;

    public BuzzHomeAfterLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search-text")
    WebElement searchField;
    @FindBy(className = "autocomplete-button-simple")
    WebElement searchContainer;

    private void clickOnSearchFieldContainer(String searchTerm) {
        searchContainer.click();
        wdWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

    }

    public void buzzAfterLoginTesting(String searchTerm) {
        clickOnSearchFieldContainer(searchTerm);
    }
}
