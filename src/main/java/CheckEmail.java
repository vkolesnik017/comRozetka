import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class CheckEmail {

    @Step("select letter")
    public void selectLetter (String letterFromAutodoc) {
        open("https://mail.google.com/");
        //  open("https://www.google.com/intl/ru/gmail/about/#");
        // $(byText("Войти")).shouldBe(visible);
        $(byXpath("//div[@class='h-c-header__cta']//li[2]/a")).shouldBe(visible);
        $(byXpath("//div[@class='h-c-header__cta']//li[2]/a")).click();
        Selenide.switchTo().window(0).close();
        Selenide.switchTo().window(0);
        // $(byText("Войти")).click();
        $(byId("identifierId")).setValue(letterFromAutodoc);
        $(byId("identifierNext")).click();
        $(byName("password")).setValue("Lion1986");
        $(byXpath("//span[@class='CwaK9']")).click();

        if ($(byXpath("//div[@class='mkCr7e']")).has(appear)) {
            $(byXpath("//span[@class='RveJvd snByac']")).click();
        }
        $(byXpath("//table[@class='aKk'] ")).shouldBe(visible);
        ElementsCollection letters = Selenide.elements(Selectors.byXpath("//td[@class='yX xY ']"));
        boolean found = false;

        for (int i = 0; i < letters.size(); ++i) {
            if (letters.get(i).has(text("info@pkwteile.de"))) {
                found = true;
                letters.get(i).click();
                break;
            }
        }

        if (!found) {
            System.out.println("You don't have a registration letter");
        }

        $(byXpath("//a[contains(text(),'Weiter shoppen')]")).click();
    }
    @Step("close window email")
    public SelectCar closeWindowEmail() {

        Selenide.switchTo().window(0).close();
        Selenide.switchTo().window(0);
        return page(SelectCar.class);
    }
}
