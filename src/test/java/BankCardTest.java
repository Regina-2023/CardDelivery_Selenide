import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.MyDate;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

import java.text.ParseException;
import java.time.Duration;


class BankCardTest {
    String str_date = new MyDate().text_date();


    public static String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

    BankCardTest() throws ParseException {
    }

    @Test
    void shouldSubmitRequest() {
        System.out.println("Converted String: " + str_date);
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("input[placeholder='Город']").setValue("Санкт-Петербург");
        $$("[class='menu-item__control']").find(exactText("Санкт-Петербург")).click();
        $("input[placeholder='Дата встречи']").sendKeys(deleteString);
        $("input[placeholder='Дата встречи']").setValue(str_date);
        form.$("input[name='name']").setValue("Регина Фаритова");
        form.$("input[name='phone']").setValue("+79117790793");
        form.$("span[class='checkbox__box']").click();
        form.$("button[class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $("div[class='notification__title']").shouldBe(visible, Duration.ofSeconds(15)).shouldHave(exactText("Успешно!"));
    }
}
