package com.vitaly.org;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MobileCatalogPage {
    protected static final Logger LOGGER = LoggerFactory.getLogger(MobileCatalogPage.class);
    private SelenideElement catalogOfProducts = $(byXpath("//ul[@class='catalog-grid']"));
    private ElementsCollection paginator = $$(byXpath("//a[contains(@class,'pagination__link')]"));
    @Step("Select top products")
    public Map<String, String> selectTopProducts(String title, int countOfPages) {
        ElementsCollection titleOfProductss = $$(byXpath("//span[contains(@class,'goods-tile__label') and contains(text(),'" + title + "')]/ancestor::div[@class='goods-tile']//span[@class='goods-tile__title']"));
        ElementsCollection priceOfProducts = $$(byXpath("//span[contains(@class,'goods-tile__label') and contains(text(),'" + title + "')]/ancestor::div[@class='goods-tile']//span[@class='goods-tile__price-value']"));
        catalogOfProducts.shouldBe(visible);
        LOGGER.info("Select TOP-product from listings");

        Map<String, String> mobilePhones = new LinkedHashMap<>();
        for (int i = 0; i < countOfPages; i++) {
            LOGGER.info("Cheking - " + (i + 1) + " page of listing");
            if (i == 0) {
                addProductsToMap(mobilePhones, titleOfProductss, priceOfProducts);
            }
            paginator.get(i).click();
            addProductsToMap(mobilePhones, titleOfProductss, priceOfProducts);
        }
        return mobilePhones;
    }
    @Step("Write date to file")
    public MobileCatalogPage writeToFile(Map<String, String> titleOfMap, String pathToFile) {
        LOGGER.info("Writing TOP-product into 'result.txt' file ");
        File myFile = new File(pathToFile);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));
            for (Map.Entry<String, String> entry : titleOfMap.entrySet())
                writer.write(entry.getKey() + " - " + entry.getValue() + "\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Map<String, String> addProductsToMap(Map<String, String> titleOfMap, ElementsCollection titleOfelement, ElementsCollection priceOfProduct) {
        if (titleOfelement.size() > 0) {
            for (int j = 0; j < titleOfelement.size(); j++) {
                titleOfMap.put(titleOfelement.get(j).getText(), priceOfProduct.get(j).getText());
            }
        }
        return titleOfMap;
    }
}