package pages.Buzz;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BuzzShopHomePage extends BaseHelper {
    WebDriver driver;
    public BuzzShopHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "login-btn") WebElement loginButton;
    @FindBy(className = "login_form") WebElement formContainer;
    @FindBy(id="login_email") WebElement inputEmailField;
    @FindBy(id="login_password") WebElement inputPasswordField;
    @FindBy(className = "btn-login") WebElement submitLoginButton;

    private void navigateToPage(String url){
        driver.get(url);
    }

    private void accpectCookie() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> cookieButton=driver.findElements(By.className("cookie-agree-gdpr"));
        if(cookieButton.size()!=0){
            wdWait.until(ExpectedConditions.elementToBeClickable(cookieButton.get(0)));
            cookieButton.get(0).click();
            wdWait.until(ExpectedConditions.invisibilityOf(cookieButton.get(0)));
        }
        System.out.println("Accpect cookie: " + cookieButton.size());
    }

    private void clickOnLoginContainer() throws InterruptedException {
        loginButton.click();
        Thread.sleep(2000);
    }
    private void inputEmail(String email){
        wdWait.until(ExpectedConditions.visibilityOf(formContainer));
        inputEmailField.sendKeys(email);
    }
    private void passwordField(String password){
        inputPasswordField.sendKeys(password);
    }

    private void clickOnSubmitButton() throws InterruptedException {
        submitLoginButton.click();
        Thread.sleep(5000);
    }

    public void buzzHomeTesting(String url,String username,String password) throws InterruptedException {
        navigateToPage(url);
        accpectCookie();
        clickOnLoginContainer();
        inputEmail(username);
        passwordField(password);
        clickOnSubmitButton();

    }

}
