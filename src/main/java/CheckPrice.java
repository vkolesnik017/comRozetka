import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.apache.http.util.Asserts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class CheckPrice {
    @Step("add product to bascet")
    public AddToBasketProduct checkSortingPrice(String locatorOfPricecs) {
        Configuration.assertionMode = AssertionMode.SOFT;
        ElementsCollection priceList = Selenide.elements(Selectors.byXpath(locatorOfPricecs));
        System.out.println(priceList.size());
        List<Double> priceListDouble = new ArrayList();

        for (int i = 0; i < priceList.size(); ++i) {
            String correctPrice = priceList.get(i).getText().replaceAll("[^0-9,]", "").replace(",", ".");
            priceListDouble.add(Double.parseDouble(correctPrice));
        }

        List<Double> checkPriceList = new ArrayList(priceListDouble);
        Collections.sort(checkPriceList);
        if (priceListDouble.size() == checkPriceList.size()) {
            for (int el = 0; el < priceList.size(); ++el) {
                Asserts.check(priceListDouble.get(el) == checkPriceList.get(el), "Error");

            }
        } else {
            System.out.println("Quantity of prices don't match");
        }
        return page(AddToBasketProduct.class);
    }
}
