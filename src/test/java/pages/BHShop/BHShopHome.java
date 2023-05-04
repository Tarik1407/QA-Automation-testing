package pages.BHShop;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BHShopHome extends BaseHelper {
    WebDriver driver;
    public  BHShopHome(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "menu-item-644") WebElement shopItem;

    private void navigateToPage(String url){
        driver.get(url);
    }
    private void clickOnShop(){
        shopItem.click();
    }
    public void bhShopHome(String url){
        navigateToPage(url);
        clickOnShop();
    }
}
