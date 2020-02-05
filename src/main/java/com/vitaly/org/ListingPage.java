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
private ElementsCollection prices = $$(byXpath("//span[@class='goods-tile__price-value']"));

    List<Integer> listBeforeSorting = new ArrayList<>();


    public List<Integer> listOfProductBeforeSorting() {
        listOfProducts.shouldBe(visible);
        $(byXpath("//select[contains(@class,'select-css')]")).selectOptionByValue("1: cheap");

        for (int i = 0; i < prices.size(); i++) {
            listBeforeSorting.add(Integer.parseInt(prices.get(i).getText()));
        }
     return listBeforeSorting;
    }

    public List<Integer> listOfProductsAfterSorting(){
        List<Integer> listAfterSorting = new ArrayList<>(listBeforeSorting);
        Collections.sort(listAfterSorting);
        return listAfterSorting;
    }




  /*      List<Integer> listAfterSorting = new ArrayList<>(listBeforeSorting);
        Collections.sort(listAfterSorting);
        System.out.println("Check of price sorting");
        sortList(listAfterSorting,listBeforeSorting);
    }

    public void sortList(List<Integer> newPriceList, List<Integer> oldPriceList) {
        Assert.assertEquals(newPriceList,oldPriceList);
        System.out.println("Price sorting works correctly");
    }*/

 /*   public void sortOfPriceProducts() {
        listOfProducts.shouldBe(visible);
        $(byXpath("//select[contains(@class,'select-css')]")).selectOptionByValue("1: cheap");
        List<Integer> listBeforeSorting = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            listBeforeSorting.add(Integer.parseInt(prices.get(i).getText()));
        }
        List<Integer> listAfterSorting = new ArrayList<>(listBeforeSorting);
        Collections.sort(listAfterSorting);
        System.out.println("Check of price sorting");
        sortList(listAfterSorting,listBeforeSorting);
    }

    public void sortList(List<Integer> newPriceList, List<Integer> oldPriceList) {
        Assert.assertEquals(newPriceList,oldPriceList);
        System.out.println("Price sorting works correctly");
    }*/
}
