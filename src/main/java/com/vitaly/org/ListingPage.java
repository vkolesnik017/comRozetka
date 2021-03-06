package com.vitaly.org;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ListingPage {
    protected static final Logger LOGGER = LoggerFactory.getLogger(ListingPage.class);
    private SelenideElement listOfProducts = $(byXpath("//ul[@class='catalog-grid']"));
    private ElementsCollection pricesOfProducts = $$(byXpath("//span[@class='goods-tile__price-value']"));
    private SelenideElement paginatorPage = $(byXpath("//a[@class='pagination__link pagination__link_state_active']"));

    @Step("Sorting price")
    public ListingPage sortProductsAscendingByPrice() {
        listOfProducts.shouldBe(visible);
        $(byXpath("//select[contains(@class,'select-css')]")).selectOptionByValue("1: cheap");
        LOGGER.info("Select 'Ascending by prices' sorting");
        return this;
    }

    public List<Double> getProductsPricesList() {
        paginatorPage.shouldHave(text("1"));
        List<Double> prices = new ArrayList<>();
        for (int i = 0; i < pricesOfProducts.size(); i++) {
            prices.add(Double.parseDouble(pricesOfProducts.get(i).getText()));
        }
        return prices;
    }
}
