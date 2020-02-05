package com.vitaly.org;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
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
        catalogpage.selectTopProducts("Топ продаж", 3);
        SortingPricePage sortpage = catalogpage.writeToFile("C://autodoc//result.txt");
        sortpage.sortOfPriceProducts();
    }
}
