package pages.LimundoShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LimundoSearchPage extends BaseHelper {
    WebDriver driver;
    public LimundoSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "accordion")
    WebElement filterResults;
    @FindBy (className="aside-input-inline") WebElement priceContainer;
    @FindBy(id="btnPushPrice") WebElement submitFilterPrice;
    public String titleElement;

    private void clickOnFilterPrice(int indexPosition) {
        wdWait.until(ExpectedConditions.visibilityOf(filterResults));
        List<WebElement> listFilters = filterResults.findElements(By.className("card"));
        WebElement ourArticle = listFilters.get(indexPosition - 1).findElement(By.tagName("h4"));
        titleElement=ourArticle.getText();
        ourArticle.click();
    }
    private void inputPriceStart(String priceStart){
        List <WebElement> listInputPrice=priceContainer.findElements(By.className("input-group-inline"));
        WebElement priceFromInput=listInputPrice.get(0).findElement(By.name("txtCenaOd"));
        priceFromInput.sendKeys(priceStart);
    }
    private void inputPriceEnd(String priceEnd){
        List <WebElement> listInputPrice=priceContainer.findElements(By.className("input-group-inline"));
        WebElement priceUntilInput=listInputPrice.get(1).findElement(By.name("txtCenaDo"));
        priceUntilInput.sendKeys(priceEnd);
    }

    private void clickOnSubmitFilterPrice(){

        submitFilterPrice.click();
    }


    public void searchLimundoTest(int indexPosition,String priceStart,String priceEnd) {

        clickOnFilterPrice(indexPosition);
        inputPriceStart(priceStart);
        inputPriceEnd(priceEnd);
        clickOnSubmitFilterPrice();
    }
}
