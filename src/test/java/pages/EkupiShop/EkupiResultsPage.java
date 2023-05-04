package pages.EkupiShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EkupiResultsPage extends BaseHelper {
    WebDriver driver;

    public EkupiResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product__listing")
    WebElement searchResults;

    public String headlineTitle;

    private void clickOnButtonAvaiableNow(int indexPosition) {
        wdWait.until(ExpectedConditions.visibilityOf(searchResults));
        List<WebElement> listArticle = searchResults.findElements(By.className("product-item"));
        WebElement targetArticle = listArticle.get(indexPosition - 1).findElement(By.tagName("a"));
        headlineTitle = targetArticle.getText();
        js.executeScript("arguments[0].scrollIntoView();", targetArticle);
        targetArticle.click();
    }

    public void resultsSearch(int indexPosition) {
        clickOnButtonAvaiableNow(indexPosition);

    }
}
