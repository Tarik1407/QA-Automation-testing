package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.EkupiShop.*;

public class EkupiTest extends BaseTest{
    @Test
    public void ekupiSearchTest() throws InterruptedException {
        String url="https://www.ekupi.ba/";
        String username="tarikhalac14@gmail.com";
        String password="Sarajevo12345";
        String searchTermData="Macbook pro";
        int indexPositionPrice=5;

        EkupiHomePage searchTestEkupi=new EkupiHomePage(driver);
        searchTestEkupi.ekupiTestingHome(url);

        EkupiLoginPage loginData=new EkupiLoginPage(driver);
        loginData.loginInputData(username,password);

        EkupiSearchPage searchTerm=new EkupiSearchPage(driver);
        searchTerm.insertSearchTermTesting(searchTermData);

        EkupiResultsPage resultsTest=new EkupiResultsPage(driver);
        resultsTest.resultsSearch(indexPositionPrice);

        EkupiOpenedArticle cartIncreaseTest=new EkupiOpenedArticle(driver);
        cartIncreaseTest.increaseAndCartTesting();

        EkupiCartPage clearCart=new EkupiCartPage(driver);
        clearCart.clearCartTesting();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("login_link")));
        WebElement loginButton=driver.findElement(By.className("login_link"));
        Assert.assertTrue("Login button is not shown!",loginButton.isDisplayed());

        Thread.sleep(5000);
    }
}
