package pages.KosnicaShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KosnicaShopHomePage extends BaseHelper {
    WebDriver driver;

    public KosnicaShopHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "button-wrap") WebElement spanContainer;
    @FindBy(id="64529a3abe3df") WebElement inputField;
    private void navigateToPage(String url){
        driver.get(url);
    }
    private void inputSearchTerm(String searchTerm){
        inputField.sendKeys(searchTerm);
        inputField.sendKeys(Keys.ENTER);
    }
//    private void clickOnSearchButton(){
//    WebElement searchButton=spanContainer.findElement(By.tagName("button"));
//    searchButton.click();
//    }
    public void dotshopHomeTesting(String url,String searchTerm){
        navigateToPage(url);
        inputSearchTerm(searchTerm);
//        clickOnSearchButton();
    }
}
