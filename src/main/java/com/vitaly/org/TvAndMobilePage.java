package com.vitaly.org;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TvAndMobilePage {
    protected static final Logger LOGGER = LoggerFactory.getLogger(TvAndMobilePage.class);
    private SelenideElement titleOfPage = $(byXpath("//h1[@class='portal__heading']"));

      @Step("Select mobile type")
    public MobilePage selectMobile(String title) {
        titleOfPage.shouldBe(visible);
        $(byXpath("//li[@class='portal-grid__cell'][1]")).click();
        LOGGER.info("Choice 'Smartphones and portable devices' category");

        return page(MobilePage.class);
    }
}
