package pages.KosnicaShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class KosnicashopResultsPage extends BaseHelper {
    WebDriver driver;

    public KosnicashopResultsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="er_main") WebElement mainContainer;
    @FindBy(className = "er_ecom_result_count") WebElement numberOfProduct;
    @FindBy(id="desk_category") WebElement filterContainer;
    @FindBy(id="er_search_results") WebElement searchResults;

    private void selectCategory(String category){
        wdWait.until(ExpectedConditions.visibilityOf(mainContainer));
        wdWait.until(ExpectedConditions.visibilityOf(numberOfProduct));
        List<WebElement> listCategory=filterContainer.findElements(By.tagName("li"));
        String title=numberOfProduct.getText();
       for(WebElement categoryItem:listCategory){
           if(categoryItem.getText().contains(category)){
               js.executeScript("arguments[0].scrollIntoView({block:'center'});",categoryItem);
               categoryItem.click();
               break;
           }
           wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("er_ecom_result_count"),title));
       }
    }
    private void selectArticle(int indexPosition){
        wdWait.until(ExpectedConditions.visibilityOf(mainContainer));
        wdWait.until(ExpectedConditions.visibilityOf(numberOfProduct));
        List<WebElement> listArticle=searchResults.findElements(By.className("ecom_des_4"));
        WebElement targetArticle=listArticle.get(indexPosition-1).findElement(By.tagName("a"));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",targetArticle);
        targetArticle.click();
    }
    public void resultsPageTesting(String category,int indexPosition){
        selectCategory(category);
        selectArticle(indexPosition);
    }
}
