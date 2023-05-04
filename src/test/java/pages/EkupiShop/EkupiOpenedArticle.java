package pages.EkupiShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EkupiOpenedArticle extends BaseHelper {
    WebDriver driver;

    public EkupiOpenedArticle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "js-qty-selector-plus")
    WebElement increaseButton;
    @FindBy(id="addToCartButton") WebElement addCartButton;

    @FindBy(id="cboxLoadedContent") WebElement loadingNewWindows;
    @FindBy(className="action-buttons") WebElement mainContainer;

    @FindBy(className = "nav__links--shop_info") WebElement cartContainer;

    private void increasePeace(){
        increaseButton.click();
    }
    private void addToCartItems(){
        addCartButton.click();
    }

    private void finishCart(){
        wdWait.until(ExpectedConditions.visibilityOf(loadingNewWindows));
        WebElement submitCartButton=mainContainer.findElement(By.tagName("a"));
        submitCartButton.click();
    }
    private void openCart(){
        WebElement cartButton=cartContainer.findElement(By.tagName("a"));
        cartButton.click();
    }

    public void increaseAndCartTesting(){
        increasePeace();
        addToCartItems();
        finishCart();
        openCart();
    }
}
