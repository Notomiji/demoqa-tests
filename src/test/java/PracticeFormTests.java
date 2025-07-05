import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.util.regex.Matcher;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@ivan.van");

        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8888888888");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2017");
        $("[aria-label='Choose Saturday, July 1st, 2017']").click();

        $("#subjectsInput").setValue("e");
        $$(byText("English")).find(visible).click();

        $("[for='hobbies-checkbox-2']").click();

        File file = new File("src/test/resources/photo.png");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Zalupkino");

        $("#state").click();
        $("#react-select-3-input").setValue("ncr");
        $$(byText("NCR")).find(visible).click();
        $("#state").shouldHave(text("NCR"));

        $("#city").click();
        $("#react-select-4-input").setValue("delhi");
        $$(byText("Delhi")).find(visible).click();
        $("#city").shouldHave(text("Delhi"));

        $("#submit").click();
    }
}
