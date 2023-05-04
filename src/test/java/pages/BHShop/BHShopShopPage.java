package pages.BHShop;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BHShopShopPage extends BaseHelper {
    WebDriver driver;

    public BHShopShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "products")
    WebElement articleList;
    @FindBy(id = "right-sidebar-inner")
    WebElement fullContainerFilter;
    @FindBy(className = "product-categories")
    WebElement categoryContainer;
    @FindBy(name = "orderby")
    WebElement selectContainer;
    @FindBy(id="oceanwp-list") WebElement listButton;
    @FindBy(id="elementor-menu-cart__toggle_button") WebElement cartButton;
    @FindBy(className = "elementor-button--view-cart") WebElement cart;

    private void choseCategory(String category) throws InterruptedException {
        wdWait.until(ExpectedConditions.visibilityOf(articleList));
        wdWait.until(ExpectedConditions.visibilityOf(fullContainerFilter));
        wdWait.until(ExpectedConditions.visibilityOf(categoryContainer));
        List<WebElement> liElements = categoryContainer.findElements(By.tagName("li"));
        for (WebElement categoryItem : liElements) {
            if (categoryItem.getText().contains(category)) {
                categoryItem.click();
                break;
            }
        }
        Thread.sleep(2000);
    }

    private void choseSort(String sortingLowerPrice) throws InterruptedException {
        Select sortItems = new Select(selectContainer);
        sortItems.selectByVisibleText(sortingLowerPrice);
        wdWait.until(ExpectedConditions.visibilityOf(articleList));
        Thread.sleep(4000);
    }
    private void clickOnListView() throws InterruptedException {
        wdWait.until(ExpectedConditions.visibilityOf(articleList));
        wdWait.until(ExpectedConditions.visibilityOf(fullContainerFilter));
        listButton.click();
        Thread.sleep(2000);
    }

    private void clickOnArticle() {
        wdWait.until(ExpectedConditions.visibilityOf(articleList));
        wdWait.until(ExpectedConditions.visibilityOf(categoryContainer));
        WebElement listOfSortArticlies=driver.findElement(By.className("products"));
        List<WebElement> liElements=listOfSortArticlies.findElements(By.tagName("li"));
        WebElement targetArticle=liElements.get(0).findElement(By.className("add_to_cart_button"));
        targetArticle.click();
    }
    private void clickOnCart(){
        cartButton.click();
    }

    private void goToCart(){
        wdWait.until(ExpectedConditions.elementToBeClickable(cart));
        cart.click();
    }

    public void shopTesting(String category, String sortingLowerPrice) throws InterruptedException {
        choseCategory(category);
        choseSort(sortingLowerPrice);
        clickOnListView();
        clickOnArticle();
        clickOnCart();
        goToCart();
    }

}
