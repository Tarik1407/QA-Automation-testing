package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SportdirectShop.SportdirectArticlePage;
import pages.SportdirectShop.SportdirectCartPage;
import pages.SportdirectShop.SportdirectHomePage;
import pages.SportdirectShop.SportdirectResultsPage;


public class SportDirectSearchAndCartTest extends BaseTest {
    @Test
    public void sportDirectTesting() throws InterruptedException {
        String url="https://www.sportsdirect.com/";
        String searchTerm="Reebok Clasics";
        String category="Headwear";
        String gender="Unisex Adults";
        int indexPosition=4;
        String quantity="3";

        SportdirectHomePage sportdirectHome=new SportdirectHomePage(driver);
        sportdirectHome.sportdirectHomeTesting(url,searchTerm);

        SportdirectResultsPage sportdirectResults=new SportdirectResultsPage(driver);
        sportdirectResults.sportdirectResultsTesting(category,gender,indexPosition);

        SportdirectArticlePage sportdirectArticle=new SportdirectArticlePage(driver);
        sportdirectArticle.sportdirectArticleTesting();

        SportdirectCartPage sportdirectCartPage=new SportdirectCartPage(driver);
        sportdirectCartPage.sportdirectCartTesting(quantity);

        // Assert
        WebElement productItem=driver.findElement(By.className("productLine"));
        WebElement stringPrice=productItem.findElement(By.className("itemprice"));
        WebElement totalPriceString=productItem.findElement(By.className("itemtotalprice"));
        String priceItem=stringPrice.getText();
        String totalPrice=totalPriceString.getText();

        float price=Float.parseFloat(priceItem.replace("£",""));
        float total=Float.parseFloat(totalPrice.replace("£",""));
        System.out.println("Price of item is:  " +priceItem + " * " + quantity + " = " + (price*Float.parseFloat(quantity)));
        System.out.println("Total price is: "+totalPrice);

        Assert.assertTrue("Total price is NOT correct",(price*Float.parseFloat(quantity))==total);




        Thread.sleep(5000);

    }
}
