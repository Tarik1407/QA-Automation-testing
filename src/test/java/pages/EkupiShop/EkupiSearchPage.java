package pages.EkupiShop;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EkupiSearchPage extends BaseHelper {
    WebDriver driver;
    public EkupiSearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="js-site-search-input") WebElement searchInputField;
    @FindBy(className = "js_search_button") WebElement searchButton;
    private void insertSearchTerm(String searchTerm){
        searchInputField.sendKeys(searchTerm);
    }
    private void clickOnSearchButton(){
        searchButton.click();
    }
    public void insertSearchTermTesting(String searchTerm){
        insertSearchTerm(searchTerm);
        clickOnSearchButton();
    }
}
