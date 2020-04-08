import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PageClass {
    private SelenideElement regField = $(byXpath("//span[@class='status ga-click']"));
    private SelenideElement eemail = $(byId("email"));

    @Step("Registration in gmail")
    public CheckEmail registrtion(String email) {
        System.out.println("Registration of new clien ");
        regField.click();
        $(byId("reg_pop")).click();
        eemail.setValue(email);
        $(byId("Password")).setValue("12345678");
        $(byId("new_pass_confirm")).setValue("12345678");
        $("#register_form > fieldset > div.accept_subscription_checkbox.subscribe_checkbox > label").click();
        $(byXpath("//a[@class='register_submit']")).click();
        $("#login_complete > div.btns > div:nth-child(2) > a").shouldHave(text("Weiter einkaufen")).click();
        $(byId("login_complete")).shouldBe(disappear);
        return page(CheckEmail.class);


    }
}
