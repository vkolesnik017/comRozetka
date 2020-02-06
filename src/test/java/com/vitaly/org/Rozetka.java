package com.vitaly.org;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;


public class Rozetka {
    @BeforeTest
    public void setUp() {
        Configuration.timeout = 6000;
        Configuration.startMaximized = true;
    }

    @Test
    public void mainMethod() {
        MainPage page = open("https://rozetka.com.ua/", MainPage.class);
        TvAndMobilePage tvPage = page.selectCategory("Смартфоны, ТВ и электроника");
        MobilePage mobPage = tvPage.selectMobile("Смартфоны и портативная техника");
        MobileCatalogPage catalogpage = mobPage.selectCategory("Мобильные телефоны");
        Map<String, String> productsMap = catalogpage.selectTopProducts("Топ продаж", 3);
        catalogpage.writeToFile(productsMap, "C://autodoc//result.txt");
        ListingPage sortprice = new ListingPage();
        List<Double> pricesAfterSorting = sortprice.sortProductsAscendingByPrice().getProductsPricesList();
        System.out.println("Checking prices sorting");
        Assert.assertEquals(pricesAfterSorting, getExpectedSortedPrices(pricesAfterSorting));
    }

    private List<Double> getExpectedSortedPrices(List<Double> pricesList) {
        List<Double> expectedSortedPrices = new ArrayList<>(pricesList);
        Collections.sort(expectedSortedPrices);
        return expectedSortedPrices;
    }
}
