package pages.OlxShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OlxSearchResultsPage extends BaseHelper {
    WebDriver driver;

    public OlxSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "sortGroupFilter")
    WebElement filterGroupContainer;
    @FindBy(className = "search-title")
    WebElement productNumber;
    @FindBy(className = "cities")
    WebElement locationContainer;
    @FindBy(className = "refresh")
    WebElement refreshButton;
    @FindBy(className = "artikli")
    WebElement articleList;
//    @FindBy(xpath = "//input[@placeholder='od']")
//    WebElement odInputField;
//    @FindBy(xpath = "//input[@placeholder='do']")
//    WebElement doInputField;


    private void selectCategory(String category) {
        wdWait.until(ExpectedConditions.visibilityOf(articleList));
        wdWait.until(ExpectedConditions.visibilityOf(filterGroupContainer));
        wdWait.until(ExpectedConditions.visibilityOf(productNumber));
        String numberOfProduct = productNumber.getText();   WebElement ulContainer = filterGroupContainer.findElement(By.className("main-ul"));
        List<WebElement> liCategoryElement = ulContainer.findElements(By.tagName("li"));
        for (WebElement categoryItem : liCategoryElement) {
            if (categoryItem.getText().contains(category)) {
                categoryItem.click();
                break;
            }
        }
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("search-title"), numberOfProduct));
    }

    private void selectLocation(String location) {
        wdWait.until(ExpectedConditions.visibilityOf(locationContainer));
        String numberOfProduct = productNumber.getText();

        WebElement selectContainer = locationContainer.findElement(By.tagName("select"));
        Select dropdownItems = new Select(selectContainer);

        dropdownItems.selectByVisibleText(location);


        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("search-title"), numberOfProduct));
    }


    private void scrollToPriceContainer() throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView({block:'center'})",locationContainer);
        Thread.sleep(2000);
    }
    private void inputStartPrice(String startPrice) {
        WebElement inputElement = driver.findElement(By.cssSelector("input[placeholder='od']"));
        inputElement.click();
        inputElement.sendKeys(startPrice);
    }

    private void inputEndPrice(String endPrice) {
        WebElement inputElement = driver.findElement(By.cssSelector("input[placeholder='do']"));
        inputElement.click();
        inputElement.sendKeys(endPrice);
        wdWait.until(ExpectedConditions.elementToBeClickable(refreshButton));
    }

    private void applyButton() {
        wdWait.until(ExpectedConditions.visibilityOf(refreshButton));
        refreshButton.click();
    }
    public void olxSearchResultsTesting(String category, String location, String startPrice, String endPrice) throws InterruptedException {
        selectCategory(category);
        selectLocation(location);
        scrollToPriceContainer();
        inputStartPrice(startPrice);
        inputEndPrice(endPrice);
        applyButton();
        Thread.sleep(3000);
    }
}
