package pages.EkupiShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EkupiCartPage extends BaseHelper {
    WebDriver driver;

    public EkupiCartPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="clearCartButton") WebElement clearButton;
    @FindBy(id="cboxLoadedContent") WebElement confirmButtonContainer;
    @FindBy(className = "nav__links--account") WebElement mainUlContainer;
    @FindBy(className = "banner__component") WebElement logoContainer;

    private void clickOnClearButton(){
        clearButton.click();
    }

    private void confirmDeleteArticle(){
        List<WebElement> cartButton=confirmButtonContainer.findElements(By.className("row"));
        WebElement targetElement=cartButton.get(0).findElement(By.tagName("a"));
        targetElement.click();
    }
    private void clickOnLogoutButton(){
        List<WebElement> liList=mainUlContainer.findElements(By.tagName("li"));
        WebElement logoutButton=liList.get(2).findElement(By.tagName("a"));
        logoutButton.click();
    }
    private void clickOnLogo(){
        WebElement logoButton=logoContainer.findElement(By.tagName("a"));
        logoButton.click();
    }
    public void clearCartTesting(){
        clickOnClearButton();
        confirmDeleteArticle();
        clickOnLogoutButton();
        clickOnLogo();
    }
}
