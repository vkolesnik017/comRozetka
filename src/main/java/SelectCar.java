import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SelectCar {
@Step("LogOut from your account")
    public void logOut() {
        System.out.println("Logout from account");
        $(byXpath("//img[@class='logout_but']")).click();

    }
   @Step("Login of a new client")
    public void logNewClient(String email) {
        System.out.println("Registration a new account");
        $(byXpath("//span[@class='status ga-click']")).shouldBe(visible);
        $(byXpath("//span[@class='status ga-click']")).click();
        $(byId("reg_pop")).shouldBe(visible);
        $(byId("reg_pop")).click();
        $(byId("email")).setValue(email);
        $(byId("Password")).setValue("12345678");
        $(byId("new_pass_confirm")).setValue("12345678");
        $("#register_form > fieldset > div.accept_subscription_checkbox.subscribe_checkbox > label").click();
        $(byXpath("//a[@class='register_submit']")).click();
        $("#login_complete > div.btns > div:nth-child(2) > a").shouldHave(text("Weiter einkaufen")).click();
        $(byId("login_complete")).shouldBe(Condition.disappear);
    }

    @Step("Select car ib selector")
    public PageCatalog selectCar(int maker, int model, int fuel) {
        $(byId("selector-wrapper")).shouldBe(visible);
        $(byName("maker_id")).selectOption(4);
        $(byName("model_id")).selectOptionByValue(Integer.toString(308));
        $(byName("car_id")).selectOptionByValue(Integer.toString(61));
        $(byXpath("//a[@class='submit ripple-out']")).click();
        return page(PageCatalog.class);
    }
}
