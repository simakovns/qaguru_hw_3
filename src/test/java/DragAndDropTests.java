import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTests {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1000x1000";
        open("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    void changeElementsPlaceTest() {
        //Можно подогнать оффсеты, но "отпускать клавишу" метод actions() не хочет.
        //actions().clickAndHold($("#column-a")).moveToElement($("#column-b"), 100, 150).release().perform();

        $("#column-a").dragAndDropTo($("#column-b"));

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
