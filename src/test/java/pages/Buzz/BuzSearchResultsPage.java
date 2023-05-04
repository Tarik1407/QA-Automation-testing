package pages.Buzz;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BuzSearchResultsPage extends BaseHelper {
    WebDriver driver;

    public BuzSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product-listing-filters")
    WebElement filterGroupContainer;
    @FindBy(className = "products-found")
    WebElement productNumber;
    @FindBy(className = "product-listing-items")
    WebElement articleList;
    @FindBy(id = "nb_f-attr-3")
    WebElement genderContainer;

    @FindBy(className = "filter-price-wrapper")
    WebElement priceContainer;

    private void selectGender() throws InterruptedException {
        wdWait.until(ExpectedConditions.visibilityOf(filterGroupContainer));
        wdWait.until(ExpectedConditions.visibilityOf(productNumber));
        wdWait.until(ExpectedConditions.visibilityOf(articleList));
        genderContainer.click();
        WebElement ulContainerGender = genderContainer.findElement(By.className("items-wrapper"));
        wdWait.until(ExpectedConditions.visibilityOf(ulContainerGender));
        List<WebElement> liElements = ulContainerGender.findElements(By.tagName("li"));
        WebElement targetGender = liElements.get(0);
        targetGender.click();
        Thread.sleep(3000);
    }

    private void selectPrice() throws InterruptedException {
        wdWait.until(ExpectedConditions.visibilityOf(filterGroupContainer));
        priceContainer.click();
        WebElement ulContainer = priceContainer.findElement(By.className("items-wrapper"));
        List<WebElement> liArticles = ulContainer.findElements(By.tagName("li"));
        WebElement targetPrice = liArticles.get(0);
        js.executeScript("arguments[0].scrollIntoView({block:'center'})", targetPrice);
        targetPrice.click();
        Thread.sleep(3000);
    }

    private void clickOnArticle() throws InterruptedException {
        wdWait.until(ExpectedConditions.visibilityOf(articleList));
        WebElement article = articleList.findElement(By.className("item-data"));
        article.click();
        Thread.sleep(2000);
    }

    public void buzResults() throws InterruptedException {
        selectGender();
        selectPrice();
        clickOnArticle();
    }
}
