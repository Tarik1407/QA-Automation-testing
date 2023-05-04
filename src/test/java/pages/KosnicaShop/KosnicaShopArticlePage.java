package pages.KosnicaShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KosnicaShopArticlePage extends BaseHelper {
    public KosnicaShopArticlePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "product-summary-wrap") WebElement mainArticleContainer;
    @FindBy(id="quantity_643ba62c0932e") WebElement inputQuantityField;
    @FindBy(name = "add-to-cart") WebElement buttonAddToCart;
    @FindBy(className = "cart") WebElement formContainer;
    @FindBy(className = "wc-action-btn") WebElement buttonCart;

    private void scrollToButton(){
        wdWait.until(ExpectedConditions.visibilityOf(mainArticleContainer));
        wdWait.until(ExpectedConditions.elementToBeClickable(buttonAddToCart));
        js.executeScript("arguments[0].scrollIntoView({block:'center'})",formContainer);
    }
    private void inputQuantitiField(String quantity){
        inputQuantityField.sendKeys(Keys.DELETE);
        inputQuantityField.sendKeys(quantity);
    }
    private void clickOnAddToCart(){
        buttonAddToCart.click();
        js.executeScript("arguments[0].scrollIntoView({block:'center'})",formContainer);
    }
    private void clickOnCart(){
        wdWait.until(ExpectedConditions.elementToBeClickable(By.className("wc-action-btn")));
        buttonCart.click();
    }
    public void kosnicashopArticleTesting(String quantity){
        scrollToButton();
        inputQuantitiField(quantity);
        clickOnAddToCart();
        clickOnCart();
    }
}
