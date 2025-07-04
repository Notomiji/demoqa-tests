import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("testUser");
        $("#userEmail").setValue("testUser@mail.com");
        $("#currentAddress").setValue("Zhopa mira 1");
        $("#permanentAddress").setValue("Zhopa mira 2");
        $(".btn-primary").click();

        $("#output").shouldHave(text("testUser"), text("testUser@mail.com"), text("Zhopa mira 1"), text("Zhopa mira 2"));
    }
}
