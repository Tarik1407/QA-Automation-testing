package pages.SportdirectShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportdirectResultsPage extends BaseHelper {
    WebDriver driver;

    public SportdirectResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ProductContainer")
    WebElement productContainer;
    @FindBy(className = "totalProducts")
    WebElement totalProductsNumber;
    @FindBy(id = "filterlist")
    WebElement filterContainer;
    @FindBy(id = "navlist")
    WebElement articleListContainer;


    private void selectCategory(String category) {
        wdWait.until(ExpectedConditions.visibilityOf(productContainer));
        wdWait.until(ExpectedConditions.visibilityOf(totalProductsNumber));
        String totalnumberProductString = totalProductsNumber.getText();
        List<WebElement> listFilters = filterContainer.findElements(By.className("FilterListItem"));
        for (WebElement item : listFilters) {
            if (item.getText().contains(category)) {
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", item);
                item.click();
                break;
            }
            wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("totalProducts"), totalnumberProductString));
        }
    }
    private void selectGender(String gender){
        wdWait.until(ExpectedConditions.visibilityOf(productContainer));
        wdWait.until(ExpectedConditions.visibilityOf(totalProductsNumber));
        List <WebElement> filterList=filterContainer.findElements(By.className("FilterListItem"));
        for(WebElement item:filterList){
            if(item.getText().contains(gender)){
                js.executeScript("arguments[0].scrollIntoView({block:'center'});",item);
                item.click();
            }
        }
    }
    private void selectArticle(int indexPosition){
        List<WebElement> listDiv=productContainer.findElements(By.tagName("li"));
        WebElement targetLi=listDiv.get(indexPosition-1).findElement(By.tagName("a"));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",targetLi);
        targetLi.click();
    }
    public void sportdirectResultsTesting(String category,String gender,int indexPosition) {
        selectCategory(category);
        selectGender(gender);
        selectArticle(indexPosition);
    }
}
