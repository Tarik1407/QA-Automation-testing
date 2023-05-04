package pages.EkupiShop;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EkupiLoginPage extends BaseHelper {
    WebDriver driver;
    public EkupiLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="j_username") WebElement usernameField;
    @FindBy(id="j_password") WebElement passwordField;
    @FindBy(id="submit") WebElement submitLoginButton;
    private void insertUsername(String username){
        usernameField.sendKeys(username);
    }
    private void  insertPassword(String password){
        passwordField.sendKeys(password);
    }
    private void clickLoginSubmit(){
        submitLoginButton.click();
    }
    public void loginInputData(String username,String password){
        insertUsername(username);
        insertPassword(password);
        clickLoginSubmit();
    }
}
