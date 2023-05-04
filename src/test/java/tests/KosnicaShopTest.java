package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.KosnicaShop.*;

import java.util.List;

public class KosnicaShopTest extends BaseTest {
    @Test
    public void KosnicaShopTest() throws InterruptedException {
        String url = "https://kosnicashop.ba/";
        String searchTerm = "Vrcaljka";
        String category = "Kasetne vrcaljke";
        int indexPosition = 5;
        String quantity = "3";
        String searchSecondTerm = "Kosnica";
        String secondCategory = "Oprema za pčelinjak";
        int indexPositionTable = 14;
        String quantityKosnica = "5";

        KosnicaShopHomePage kosnicaTestingHome = new KosnicaShopHomePage(driver);
        kosnicaTestingHome.dotshopHomeTesting(url, searchTerm);

        KosnicashopResultsPage kosnicaTestingResults = new KosnicashopResultsPage(driver);
        kosnicaTestingResults.resultsPageTesting(category, indexPosition);

        KosnicaShopArticlePage kosnicaTestingArticle = new KosnicaShopArticlePage(driver);
        kosnicaTestingArticle.kosnicashopArticleTesting(quantity);

        KosnicaShopOpenFirstArticlePage kosnicaTestingOpenArticle = new KosnicaShopOpenFirstArticlePage(driver);
        kosnicaTestingOpenArticle.kosnicaShopOpeningFirstArticle(searchSecondTerm);

        KosnicaShopResultsSecondArticle kosnicaTestingSecondResults = new KosnicaShopResultsSecondArticle(driver);
        kosnicaTestingSecondResults.kosnicaSecondResultsTesting(secondCategory, indexPositionTable);

        KosnicaShopOpenSecondArticle kosnicaTestingSecondArticleOpen = new KosnicaShopOpenSecondArticle(driver);
        kosnicaTestingSecondArticleOpen.openSecondArticle(quantityKosnica);

        // Asertion:
        WebElement tableContainer = driver.findElement(By.className("shop_table"));
        List<WebElement> listElements = tableContainer.findElements(By.className("cart_item"));
        WebElement firstItem = listElements.get(0);
        WebElement secondItem = listElements.get(1);

        // First article
        WebElement stringPrice = firstItem.findElement(By.className("woocommerce-Price-amount"));
        String priceFirst = stringPrice.getText().replace(".", "").replace("KM", "").replace(",", ".");

        WebElement totalPriceCont = firstItem.findElement(By.className("product-subtotal"));
        WebElement totalPrice = totalPriceCont.findElement(By.className("woocommerce-Price-amount"));
        String priceFirstTotal = totalPrice.getText().replace(".", "").replace("KM", "").replace(",", ".");

        Double priceArticleFirstNumber = Double.parseDouble(priceFirst);
        Double priceTotalArticlesNumber = Double.parseDouble(priceFirstTotal);

        // Second article
        WebElement stringPriceSecond = secondItem.findElement(By.className("woocommerce-Price-amount"));
        String priceSecond = stringPriceSecond.getText().replace(" ", "").replace("KM", "").replace(",00", "");

        WebElement totalPriceContSecond = secondItem.findElement(By.className("product-subtotal"));
        WebElement totalPriceSecond = totalPriceContSecond.findElement(By.className("woocommerce-Price-amount"));
        String priceFirstTotalSecond = totalPriceSecond.getText().replace(" ", "").replace("KM", "").replace(",00", "");

        float priceArticleSecondNumber = Float.parseFloat(priceSecond);
        float priceTotalArticlesSecondNumber = Float.parseFloat(priceFirstTotalSecond);

        Assert.assertTrue("Total price is not correct!", ((Integer.parseInt(quantity)) * priceArticleFirstNumber) == priceTotalArticlesNumber);
        Assert.assertTrue("Total price is not correct!", ((Float.parseFloat(quantityKosnica)) * priceArticleSecondNumber) == priceTotalArticlesSecondNumber);

        Thread.sleep(5000);
    }
}
