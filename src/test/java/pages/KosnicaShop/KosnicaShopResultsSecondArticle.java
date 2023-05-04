package pages.KosnicaShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class KosnicaShopResultsSecondArticle extends BaseHelper {
    public KosnicaShopResultsSecondArticle(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "er_ecom_result_count") WebElement numberProduct;
    @FindBy(id = "desk_category") WebElement filterContainer;
    @FindBy(id = "er_search_results") WebElement searchResultsContainer;
    @FindBy(id="er_main") WebElement mainContainer;

    private void selectCategory(String category){
        wdWait.until(ExpectedConditions.visibilityOf(mainContainer));
        wdWait.until(ExpectedConditions.visibilityOf(numberProduct));
        List<WebElement> listCategory= filterContainer.findElements(By.tagName("li"));
        String title=numberProduct.getText();
        for(WebElement filter:listCategory){
            if(filter.getText().contains(category)){
                js.executeScript("arguments[0].scrollIntoView({block:'center'});",filter);
                filter.click();
                break;
            }
//            wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("er_ecom_result_count"),title));

        }
    }
    private void selectArticle(int indexPosition){
        wdWait.until(ExpectedConditions.visibilityOf(mainContainer));
        wdWait.until(ExpectedConditions.visibilityOf(searchResultsContainer));
        List <WebElement> targetArticleList=searchResultsContainer.findElements(By.className("ecom_des_4"));
        WebElement targetArticle=targetArticleList.get(indexPosition-1).findElement(By.className("er_image_href"));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",targetArticle);
        wdWait.until(ExpectedConditions.elementToBeClickable(targetArticle));
        targetArticle.click();
    }
    public void kosnicaSecondResultsTesting(String category,int indexPosition){
        selectCategory(category);
        selectArticle(indexPosition);
    }
}
