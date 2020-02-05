package com.vitaly.org;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement allCategories = $(byXpath("//div[contains(@class,'menu-wrapper_state_static')]"));
    private SelenideElement hiddenMenu = $(byXpath("//div[@class='menu-wrapper display-block menu-wrapper_state_animated']"));
    private SelenideElement catalogOfProducts = $(byXpath("//button[@class='menu-toggler']"));

    public TvAndMobilePage selectCategory(String nameOfCategory) {
        System.out.println("Opening main page of rozetka");
        allCategories.shouldBe(visible);
        $(byXpath("//a[@class='menu-categories__link' and contains(text(),'" + nameOfCategory + "')]")).click();
        $(byXpath("//div[@class='header-bottomline']")).click();
        System.out.println("Selection of 'Smartphones, TVs and Electronics' categories");
        return page(TvAndMobilePage.class);
    }

}
