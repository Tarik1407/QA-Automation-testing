package pages.Buzz;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BuzOpensArticlePage extends BaseHelper {
    WebDriver driver;

    public BuzOpensArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "product-attributes-two-sizes") WebElement ulContainer;
    @FindBy(id="nb_addToCartButton") WebElement cartButton;
    @FindBy(id="miniCartContent") WebElement cartShopping;

    private void choseSize(){
        wdWait.until(ExpectedConditions.visibilityOf(ulContainer));
        List<WebElement> liSizes=ulContainer.findElements(By.tagName("li"));
        for(WebElement size:liSizes){
            String classes=size.getAttribute("class");
            if(!classes.contains("disabled")){
                size.click();
                break;
            }
        }
    }
    private void clickOnCart() throws InterruptedException {
        cartButton.click();
        Thread.sleep(3000);
    }
    private void goToCart(){
        cartShopping.click();
    }
    public void buzOpenArticle() throws InterruptedException {
        choseSize();
        clickOnCart();
        goToCart();
    }
}
