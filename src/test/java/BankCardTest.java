import com.codeborne.selenide.SelenideElement;
import myclasses.MyDate;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


class BankCardTest {
    String strDate = new MyDate().textDate(5);
    public static String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("input[placeholder='Город']").setValue("Санкт-Петербург");
        $$("[class='menu-item__control']").find(exactText("Санкт-Петербург")).click();
        $("input[placeholder='Дата встречи']").sendKeys(deleteString);
        $("input[placeholder='Дата встречи']").setValue(strDate);
        form.$("input[name='name']").setValue("Регина Фаритова");
        form.$("input[name='phone']").setValue("+79117790793");
        form.$("span[class='checkbox__box']").click();
        form.$("span[class='button__text']").click();
        $("div[class='notification__content']").shouldBe(visible, Duration.ofSeconds(15)).shouldHave(exactText("Встреча успешно забронирована на " + strDate));
    }
}
