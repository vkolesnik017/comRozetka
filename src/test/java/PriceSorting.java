import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class PriceSorting {
    /*    public static void main(String[] args) {
            String ss = "10,01 €";
          String  sss = ss.replaceAll("[^,0-9]","").replaceAll(",",".");
            System.out.println(sss);
          Double d= Double.parseDouble(sss);
            System.out.println(d);
        }*/
    @Test
    public void checkSorting() {
        System.out.println("open rozetka");
        open("https://rozetka.com.ua/mobile-phones/c80003/");
        System.out.println("111111111");
        $(byXpath("//ul[@class='catalog-grid']")).shouldBe(visible);
        $(byXpath("//ctg-pagination//li[3]//a[1]")).click();
        SelenideElement tit = $(byXpath("//span[@class='goods-tile__title']"));
        String titleName = $(byXpath("//span[@class='goods-tile__title']")).getText();
        $(byXpath("//select[contains(@class,'select-css')]")).selectOptionByValue("1: cheap");
        System.out.println($(byXpath("//span[@class='goods-tile__title']")).getText());
           }

    public void sortList(List<Integer> first, List<Integer> second) {
        Assert.assertEquals(first, second);
        System.out.println("Price sorting works correctly");
    }
}
