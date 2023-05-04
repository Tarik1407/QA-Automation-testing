package pages.LimundoShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LimundoShopPage extends BaseHelper {
    WebDriver driver;

    public LimundoShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "btn-user")
    WebElement loginButton;
    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(className = "btn-container")
    WebElement submitContainer;
    @FindBy(name = "txtPretraga")
    WebElement inputSearchField;
    @FindBy(id = "button-addon2")
    WebElement searchButton;
    @FindBy(className = "user-avatar")
    WebElement dropdownMenu;
    @FindBy(className = "show")
    WebElement mainContainerDropdown;
@FindBy(id="logo") WebElement logoContainer;
    private void navigateToPage(String url) {
        driver.get(url);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    private void inputUsername(String username) {
        usernameField.sendKeys(username);
    }

    private void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    private void clickSubmitButton() {
        WebElement submitButton = submitContainer.findElement(By.tagName("button"));
        submitButton.click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-container")));
    }

    private void inputSearchTerm(String searchTerm) {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPretraga")));
        inputSearchField.sendKeys(searchTerm);
    }

    private void clickOnSearchButton() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("button-addon2")));
        searchButton.click();
    }

    private void openDropdownMenu() {
        dropdownMenu.click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.className("show")));
    }

    private void logoutButton() {
        List<WebElement> resultsDiv = mainContainerDropdown.findElements(By.tagName("a"));
        int lastElement=resultsDiv.size()-1;
        WebElement lastElementAnchor=resultsDiv.get(lastElement);
        lastElementAnchor.click();
    }
    private void backToHomePage(){
        WebElement headerContainer = driver.findElement(By.className("header-container"));
        wdWait.until(ExpectedConditions.visibilityOf(headerContainer));
        WebElement logoButtn=logoContainer.findElement(By.tagName("a"));
        logoButtn.click();
    }

    public void olxTest(String url,String username, String password, String searchTerm) {
        navigateToPage(url);
        clickLoginButton();
        inputUsername(username);
        inputPassword(password);
        clickSubmitButton();
        inputSearchTerm(searchTerm);
        clickOnSearchButton();
        openDropdownMenu();
        logoutButton();
        backToHomePage();
    }
}
