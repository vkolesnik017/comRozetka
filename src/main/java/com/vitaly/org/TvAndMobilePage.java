package com.vitaly.org;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TvAndMobilePage {
    protected static final Logger LOGGER = LoggerFactory.getLogger(TvAndMobilePage.class);
    private SelenideElement titleOfPage = $(byXpath("//h1[@class='portal__heading']"));

    public MobilePage selectMobile(String title) {
        titleOfPage.shouldBe(visible);
        $(byXpath("//a[contains(@class,'tile-cats__heading') and contains(text(),'" + title + "')]")).click();
        LOGGER.info("Choice 'Smartphones and portable devices' category");

        return page(MobilePage.class);
    }
}
