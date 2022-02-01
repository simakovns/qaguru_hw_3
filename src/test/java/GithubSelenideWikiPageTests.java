import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GithubSelenideWikiPageTests {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1000x1000";
    }

    @Test
    void wikiSoftAssertionsTests() {
        open("https://github.com/selenide/selenide/wiki");
        //find <a> to click on
        $$(".markdown-body ul li").find(text("Soft assertions")).lastChild().click();

        $$(".markdown-body ol li").filterBy(text("JUnit5")).shouldHave(sizeGreaterThan(0));
    }
}
