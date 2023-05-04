package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LimundoShop.LimundoShopPage;

public class LimundoShopTest extends BaseTest {
    @Test
    public void LimundoTest() throws InterruptedException {
        String url="https://www.limundo.com/";
        String username="tarik1407";
        String password="sarajevo123";
        String searchTerm=" Samsung Laptop";

        LimundoShopPage limundoTesting=new LimundoShopPage(driver);
        limundoTesting.olxTest(url,username,password,searchTerm);

        WebElement checkingAssert=driver.findElement(By.className("top-icon"));
        Assert.assertTrue("Top icon is non visibility",checkingAssert.isDisplayed());

        Thread.sleep(4000);
    }
}
