package com.vitaly.org;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    protected static final Logger LOGGER = LoggerFactory.getLogger(MainPage.class);
    private SelenideElement allCategories = $(byXpath("//div[contains(@class,'menu-wrapper_state_static')]"));
    private SelenideElement hiddenMenu = $(byXpath("//div[@class='menu-wrapper display-block menu-wrapper_state_animated']"));
    private SelenideElement catalogOfProducts = $(byXpath("//button[@class='menu-toggler']"));

    @Step("Select category ")
    public TvAndMobilePage selectCategory(String nameOfCategory) {
        LOGGER.info("Opening main page of rozetka");
        allCategories.shouldBe(visible);
        $(byXpath("//ul[@class='menu-categories menu-categories_type_main']/li[2]")).click();
        $(byXpath("//div[@class='header-bottomline']")).click();
        LOGGER.info("Selection of 'Smartphones, TVs and Electronics' categories");
        return page(TvAndMobilePage.class);
    }

}
