package com.vitaly.org;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ListingPage {
    private SelenideElement listOfProducts = $(byXpath("//ul[@class='catalog-grid']"));
    private ElementsCollection pricesOfProducts = $$(byXpath("//span[@class='goods-tile__price-value']"));


    public ListingPage sortProductsAscendingByPrice() {
        listOfProducts.shouldBe(visible);
        $(byXpath("//select[contains(@class,'select-css')]")).selectOptionByValue("1: cheap");
        System.out.println("Select 'Ascending by prices' sorting");
        return this;
    }

    public List<Double> getProductsPricesList() {
        listOfProducts.shouldBe(visible);
        List<Double> prices = new ArrayList<>();
        for (int i = 0; i < pricesOfProducts.size(); i++) {
            prices.add(Double.parseDouble(pricesOfProducts.get(i).getText()));
        }
        return prices;
    }
}
