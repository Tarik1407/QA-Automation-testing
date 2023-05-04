package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BHShop.BHShopCart;
import pages.BHShop.BHShopHome;
import pages.BHShop.BHShopShopPage;

public class BHShopTesting extends BaseTest {
    @Test
    public void BHShopTesting() throws InterruptedException {
        String url = "https://bh-market.ba/";
        String searchTerm = "Bušilice";
        String sortingLowerPrice = "Razvrstaj po cijeni: manje do veće";

        BHShopHome bhShopHomeTesting = new BHShopHome(driver);
        bhShopHomeTesting.bhShopHome(url);

        BHShopShopPage bhShopTesting = new BHShopShopPage(driver);
        bhShopTesting.shopTesting(searchTerm, sortingLowerPrice);

        BHShopCart bhShopCartTesting = new BHShopCart(driver);
        bhShopCartTesting.cartTesting();

        // Asesertation:

        WebElement formContainer = driver.findElement(By.className("woocommerce-cart-form"));
        WebElement targetArticle = formContainer.findElement(By.tagName("tbody"));

        WebElement productPrice = targetArticle.findElement(By.className("product-price"));
        WebElement totalPrice=targetArticle.findElement(By.className("product-subtotal"));

        String priceText = productPrice.getText().replace(",00", "").replace(" KM", "");
        int price = Integer.parseInt(priceText);

        String totalPriceText=totalPrice.getText().replace(",00","").replace(" KM","");
        int totalPriceNumber=Integer.parseInt(totalPriceText);

        Assert.assertTrue("Total price is not correct!",(price*3)==totalPriceNumber);
        Thread.sleep(5000);
    }
}
