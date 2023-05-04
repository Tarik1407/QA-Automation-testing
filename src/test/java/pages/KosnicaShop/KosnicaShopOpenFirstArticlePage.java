package pages.KosnicaShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KosnicaShopOpenFirstArticlePage extends BaseHelper {
    public KosnicaShopOpenFirstArticlePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "searchform-fields") WebElement inputFieldContainer;

    private void findSecondArticle(String searchSecondTerm){
        WebElement inputField=inputFieldContainer.findElement(By.tagName("input"));
        inputField.sendKeys(searchSecondTerm);
    }
    private void clickOnSearchButton(){
        WebElement searchButton=inputFieldContainer.findElement(By.tagName("button"));
        searchButton.click();
    }
    public void kosnicaShopOpeningFirstArticle(String searchSecondTerm){
        findSecondArticle(searchSecondTerm);
        clickOnSearchButton();
    }
}
