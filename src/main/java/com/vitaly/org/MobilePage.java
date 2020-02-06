package com.vitaly.org;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MobilePage {
    private SelenideElement catalog = $(byXpath("//div[@class='layout']"));

    public MobileCatalogPage selectCategory(String title) {
        catalog.shouldBe(visible);
        $(byXpath("//span[@class='portal-navigation__link-text' and contains(text(),'" + title + "')]")).click();
        System.out.println("Select 'Mobile phones' category ");
        return page(MobileCatalogPage.class);

    }
}

