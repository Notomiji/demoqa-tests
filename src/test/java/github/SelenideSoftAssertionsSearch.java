package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertionsSearch {

    @Test
    void shouldFindSoftAssertionsSearch() {

        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $$("a").findBy(text("SoftAssertions")).click();
        // Проверка, что заголовок с нужным текстом виден
        $$("h4.heading-element")
                .findBy(text("3. Using JUnit5 extend test class:"))
                .scrollIntoView(true)
                .shouldBe(visible);

        sleep(5000);
    }
}
