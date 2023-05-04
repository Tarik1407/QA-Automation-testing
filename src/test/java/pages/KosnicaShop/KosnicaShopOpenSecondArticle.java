package pages.KosnicaShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KosnicaShopOpenSecondArticle extends BaseHelper {
    public KosnicaShopOpenSecondArticle(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="main") WebElement mainContainerArticle;
    @FindBy(className = "cart") WebElement formContainer;
    @FindBy (id = "quantity_643b502ba0a4e") WebElement inputField;
    @FindBy(name = "add-to-cart") WebElement buttonAddToCart;

    private void waitToLoadElement(){
        wdWait.until(ExpectedConditions.visibilityOf(mainContainerArticle));
    }
    private void inputQuaintityNumber(String quantity){
        inputField.sendKeys(Keys.DELETE);
        inputField.sendKeys(quantity);
    }
    private void clickOnAddToCartButton(){
        buttonAddToCart.click();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",formContainer);
    }
    private void clickOnCart(){
        WebElement cartButton=formContainer.findElement(By.tagName("a"));
        cartButton.click();
    }
    public void openSecondArticle(String quantity){
        waitToLoadElement();
        inputQuaintityNumber(quantity);
        clickOnAddToCartButton();
        clickOnCart();
    }
}
