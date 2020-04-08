package com.vitaly.org;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MobilePage {
    protected static final Logger LOGGER = LoggerFactory.getLogger(MobilePage.class);
    private SelenideElement catalog = $(byXpath("//div[@class='layout']"));
    @Step("Select mobile category")
    public MobileCatalogPage selectCategory(String title) {
        catalog.shouldBe(visible);
        $(byXpath("//li[@class='portal-navigation__item'][1]")).click();
        LOGGER.info("Select 'Mobile phones' category ");
        return page(MobileCatalogPage.class);

    }
}

