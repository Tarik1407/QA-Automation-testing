package pages.EkupiShop;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EkupiHomePage extends BaseHelper {
    WebDriver driver;
    public EkupiHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
@FindBy(className = "login_link") WebElement loginButton;
    private void navigateToPage(String url){
        driver.get(url);
    }
    private void clickOnLoginForm(){
        loginButton.click();
    }
    public void ekupiTestingHome(String url){
        navigateToPage(url);
        clickOnLoginForm();
    }
}
