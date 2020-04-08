import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PageCatalog {
    @Step("select Category")
    public CheckPrice selectCategory (){
        $(byXpath("//span[@class='name'][contains(text(),'Bremsanlage')]")).click();
        $(byXpath("//div[@class='all-autoparts__itemtop-title']")).shouldHave(text("Bremsanlage")).shouldBe(visible);
        $(byXpath("//span[@class='all-autoparts__itemtop-text']")).shouldBe(text("Bremsscheiben")).click();
        return page(CheckPrice.class);
    }
}
