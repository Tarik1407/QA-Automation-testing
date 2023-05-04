package pages.SportdirectShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportdirectArticlePage extends BaseHelper {
    WebDriver driver;

    public SportdirectArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ulColourImages")
    WebElement colorsDiv;
    @FindBy(id = "ulSizes")
    WebElement sizeDiv;
    @FindBy(id = "ProductStandardAddToBag")
    WebElement cartButton;
    @FindBy(id = "aBagLink")
    WebElement cartButtonAdd;

    private void pickColor() {
        List<WebElement> listColorsLi = colorsDiv.findElements(By.tagName("li"));
        WebElement targetColor = listColorsLi.get(1).findElement(By.tagName("a"));
        targetColor.click();
    }

    private void pickSize() {
        wdWait.until(ExpectedConditions.visibilityOf(sizeDiv));
        List<WebElement> listSizeLi = sizeDiv.findElements(By.tagName("li"));
        for (WebElement item : listSizeLi) {
            String classes = item.getAttribute("class");
            if (!classes.contains("greyOut")) {
                item.click();
                break;
            }
        }
    }

    private void clickOnBagButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }

    private void goToCart(){
        wdWait.until(ExpectedConditions.elementToBeClickable(cartButtonAdd));
        cartButtonAdd.click();
    }

    public void sportdirectArticleTesting() {
        pickColor();
        pickSize();
        clickOnBagButton();
        goToCart();
    }
}
