import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class AddToBasketProduct {
    @Step("add to basket")
    public String addToBasket() {
        ElementsCollection buttonsAddToBascet = Selenide.elements(byXpath("//div[@class='right_side']//div[@class='basket_btn button active_red_button ']"));
        //div[@class='price']
        buttonsAddToBascet.get(2).click();

        //  $(byXpath("//div[@class='cart-items-block ']")).shouldBe(visible);
        if (element(byXpath("//div[@class='popup-related__header']")).has(visible)) {
            element(byXpath("//span[@class='popup-related__close']")).click();
        }
        $(byXpath("//div[@class='cart-items-block ']")).shouldNotBe(visible);
        $(byXpath("//div[@class='header__cart-count info artikles']")).click();
        System.out.println("Product - '" + element(byXpath("//td[@class='info']/h3")).getText() + "' was added to basket");
        $(byXpath("//div[@class='cart-page-head__button']")).shouldBe(enabled);
        $(byXpath("//div[@class='cart-page-head__button']")).click();
        //   $(byName("Email")).setValue("testselenide2@gmail.com");
        //   $(byName("Password")).setValue("Lion1986");
        //   $(byXpath("//div[@class='button-continue']/a")).click();
        $(byName("lVorname")).setValue("testName");
        $(byName("lName")).setValue("testSurName");
        $(byName("lStrasse")).setValue("str. Guginhaim");
        $(byName("delivery_house")).setValue("48");
        $(byName("lPlz")).setValue("12345");
        $(byName("lOrt")).setValue("048");
        $(byXpath("//div[@class='jq-selectbox__trigger']")).click();
        $(byXpath("//li[contains(text(),'Deutschland')]")).click();
        $(byName("lTelefon")).setValue("200+002");
        $(byXpath("//div[@class='button-continue address-continue']/a")).click();
        $(byXpath("//div[contains(text(),'Vorkasse')]")).click();
        $(byXpath("//a[contains(text(),'Weiter')]")).click();
        //  System.out.println(element(byXpath("//div[@class='info-user-cart__info']")).getText());
        String nameOfCustomer = $(byXpath("//div[@class='info-user-cart__info']")).getText();
        return nameOfCustomer;
    }
}
