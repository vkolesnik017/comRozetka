package com.vitaly.org;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MobileCatalogPage {
    private SelenideElement catalogOfProducts = $(byXpath("//ul[@class='catalog-grid']"));
    private ElementsCollection paginator = $$(byXpath("//a[contains(@class,'pagination__link')]"));
    Map<String, String> mobilePhones = new LinkedHashMap<>();


    public void selectTopProducts(String title, int countOfPages) {
        ElementsCollection titleOfProductss = $$(byXpath("//span[contains(@class,'goods-tile__label') and contains(text(),'" + title + "')]/ancestor::div[@class='goods-tile']//span[@class='goods-tile__title']"));
        ElementsCollection priceOfProducts = $$(byXpath("//span[contains(@class,'goods-tile__label') and contains(text(),'" + title + "')]/ancestor::div[@class='goods-tile']//span[@class='goods-tile__price-value']"));
        catalogOfProducts.shouldBe(visible);
        System.out.println("Select TOP-product from listings");
        for (int i = 0; i < countOfPages; i++) {
            if (i == 0) {
                addProductsToMap(mobilePhones, titleOfProductss, priceOfProducts);
            }
            paginator.get(i).click();
            addProductsToMap(mobilePhones, titleOfProductss, priceOfProducts);
        }
    }

    public SortingPricePage writeToFile(String pathToFile) {
        System.out.println("Writing TOP-product into 'result.txt' file ");
        File myFile = new File(pathToFile);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));
            for (Map.Entry<String, String> entry : mobilePhones.entrySet())
                writer.write(entry.getKey() + " - " + entry.getValue() + "\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page(SortingPricePage.class);
    }

    public void addProductsToMap(Map<String, String> titleOfMap, ElementsCollection titleOfelement, ElementsCollection priceOfProduct) {
        for (int j = 0; j < titleOfelement.size(); j++) {
            titleOfMap.put(titleOfelement.get(j).getText(), priceOfProduct.get(j).getText());
        }
    }
}