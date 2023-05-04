package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.OlxShop.OlxHomePage;
import pages.OlxShop.OlxSearchResultsPage;

import java.util.List;

public class OlxTestSearch extends BaseTest {

    @Test
    public void olxSearchTest() throws InterruptedException {
        String url = "https://olx.ba/";
        String searchTerm = "Renault Megane";
        String category = "Vozila";
        String location = "Banjalučka";
        String fromPrice = "10000";
        String toPrice = "15000";

        OlxHomePage olxHomeTesting = new OlxHomePage(driver);
        olxHomeTesting.olxHomeTestingPage(url, searchTerm);

        OlxSearchResultsPage olxResults = new OlxSearchResultsPage(driver);
        olxResults.olxSearchResultsTesting(category, location, fromPrice, toPrice);

        // Asert - Soft assert
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("articles")));
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cardd")));

        WebElement searchResults = driver.findElement(By.className("articles"));
        List<WebElement> articleList = searchResults.findElements(By.className("cardd"));
        for (WebElement article : articleList) {
            String title = article.findElement(By.tagName("h1")).getText();
            System.out.println("Article title is: " + title);
            String price = article.findElement(By.className("smaller")).getText();
            System.out.println("Price of article is: " + price);
            String fixedPrice = price.replace(" KM", "").replace(".", "");
            int priceArticle = Integer.parseInt(fixedPrice);

            softAssertion.assertTrue(title.toUpperCase().contains(searchTerm.toUpperCase()), "Search term is: " + searchTerm + " title is: " + title);
            softAssertion.assertTrue(priceArticle >=Integer.parseInt(fromPrice) && priceArticle<=Integer.parseInt(toPrice),"price of article is: " + fixedPrice + "Price is not between range!");
        }
        softAssertion.assertAll();

        Thread.sleep(7000);
    }

}
