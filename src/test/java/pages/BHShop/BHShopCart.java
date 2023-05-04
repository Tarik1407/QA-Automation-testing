package pages.BHShop;

import helpers.BaseHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BHShopCart extends BaseHelper {
    WebDriver driver;

    public BHShopCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "update_cart")
    WebElement updateCart;
    @FindBy(className = "plus")
    WebElement plusButton;

    private void inputArticlesNumbers() {
        plusButton.click();
        plusButton.click();
    }

    private void updateCart() throws InterruptedException {
        updateCart.click();
        Thread.sleep(2500);
    }

    public void cartTesting() throws InterruptedException {
        inputArticlesNumbers();
        updateCart();
    }
}
