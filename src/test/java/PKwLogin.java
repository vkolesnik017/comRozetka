import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PKwLogin {

    private SelenideElement loginButton = $(byId("login"));
    {
        Configuration.holdBrowserOpen = true;
        //  Configuration.startMaximized=true;
        Configuration.timeout=6000;

    }

    @Test
    @Flaky
    @Owner(value = "Kolesnik")
    public void CheckingOfLoginANewClient() {
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(1000);

        String randNumber = String.valueOf(rand_int1);
        PageClass page = open("https://www.pkwteile.de/", PageClass.class);
        CheckEmail checkletter = page.registrtion("first"+randNumber+"abs@gmail.com");
        checkletter.selectLetter("testselenide2@gmail.com");
        SelectCar pageCar =  checkletter.closeWindowEmail();
        pageCar.logOut();
        pageCar.logNewClient("daf"+randNumber+"0m17@gmail.com");
        PageCatalog selectCategory =  pageCar.selectCar(4,308,61);
        CheckPrice sortingPrice = selectCategory.selectCategory();
     //   AddToBasketProduct pageBasket = sortingPrice.checkSortingPrice("//div[@class='price']");
        //  pageBasket.addToBasket();
     //   CheckOrderAws pageOrderAws = new CheckOrderAws();
     //   pageOrderAws.checkOrder(pageBasket.addToBasket());


/*

         RegistrationPge pageField = page.addToBascet(9127030);
        RegistrstionAdress regData = pageField.registrationUser("reto@33p.org", "12345678");
       regData.addAllData("MyName", "MySurName","str. Guginhaim",48,12345,438,"200+200");

*/



/*  ElementsCollection category =   $$(byXpath("//div[@class='category-block__item-title']/p")).filterBy(text("isen"));
        System.out.println($$(byXpath("//div[@class='category-block__item-title']/p")).size());
category.shouldHave(size(2));
        List<String> categories = new ArrayList<>();
        for (int i=0; i<category.size(); i++) {
            categories.add(category.get(i).getText());
        }
        System.out.println(categories.size());
        for (String s: categories) {
            System.out.println(s);
        }*/
    }
}
