package pages.Buzz;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BuzzCartPage extends BaseHelper {
    WebDriver driver;

    public BuzzCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="quantity_1") WebElement selectContainer;

    private void inputQuantity(String quantity) throws InterruptedException {
        Select dropdownItems=new Select(selectContainer);
        dropdownItems.selectByVisibleText(quantity);
        Thread.sleep(4000);

    }
    public void buzCartTestingQuantity(String quantity) throws InterruptedException {
        inputQuantity(quantity);
    }
}
