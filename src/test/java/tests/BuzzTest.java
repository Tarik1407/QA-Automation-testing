package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Buzz.*;

public class BuzzTest extends BaseTest{
    @Test
    public void BuzzTest() throws InterruptedException {
        String url="https://www.buzzsneakers.ba/";
        String username="tarikhalac14@gmail.com";
        String password="Kompjuter98765";
        String searchTerm="Nike Air Force";
        String quantity="2";

        BuzzShopHomePage buzHome=new BuzzShopHomePage(driver);
        buzHome.buzzHomeTesting(url,username,password);

        BuzzHomeAfterLoginPage buzAfterLogin=new BuzzHomeAfterLoginPage(driver);
        buzAfterLogin.buzzAfterLoginTesting(searchTerm);

        BuzSearchResultsPage buzSearchResults=new BuzSearchResultsPage(driver);
        buzSearchResults.buzResults();

        BuzOpensArticlePage buzOpensArticle=new BuzOpensArticlePage(driver);
        buzOpensArticle.buzOpenArticle();

        BuzzCartPage buzCartTesting=new BuzzCartPage(driver);
        buzCartTesting.buzCartTestingQuantity(quantity);

        // Assert
        // Article price separate:
        WebElement tableContainer=driver.findElement(By.className("cart-table"));
        WebElement itemPrice=tableContainer.findElement(By.className("cart-col-inner-wrapper"));
        String itemStringPrice=itemPrice.getText().replace(",",".").replace(" BAM","");
        Float priceArticle=Float.parseFloat(itemStringPrice);

        // Total price:
        WebElement itemTotalPrice=tableContainer.findElement(By.className("product-item-prices"));
        String totalPrice=itemTotalPrice.getText().replace(",",".").replace(" BAM","");
        Float totalPriceFixed=Float.parseFloat(totalPrice);


        Assert.assertTrue("Total price is not correct!",(priceArticle*Float.parseFloat(quantity))==totalPriceFixed);


        Thread.sleep(5000);
    }
}
