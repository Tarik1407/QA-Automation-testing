package pages.SportdirectShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SportdirectCartPage extends BaseHelper {
    WebDriver driver;

    public SportdirectCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="Lines_0__Quantity")
    WebElement inputField;
    private void increaseItemInCart(String quantity){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("productLine")));
        while(!inputField.getAttribute("value").equals("")){
            inputField.sendKeys(Keys.DELETE);
        }
        inputField.sendKeys(quantity);
        inputField.sendKeys(Keys.ENTER);
    }
    public void sportdirectCartTesting(String quantity){
        increaseItemInCart(quantity);
    }
}
