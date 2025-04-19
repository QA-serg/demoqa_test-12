import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
    }

    @Test

    void practice_form() {
        open("/automation-practice-form");
        // Names and Email
        $("#firstName").setValue("Sensey");
        $("#lastName").setValue("Sontyago");
        $("#userEmail").setValue("UsertestX@mail.ru");
        //Gender
        $("#gender-radio-2").click();
        //Календарь
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("2001");
        $(".react-datepicker__day--011:not(.react-datepicker__day--outside-month)").click();
        //Number
        $("#userNumber").setValue("9998887766");
        //Subject
        $("#subjectsInput").setValue("arts") .pressEnter();
        //Hibbies
        $("#hobbies-checkbox-3").click();
        //File
        $("#uploadPicture").uploadFile(new File("src/test/resources/google.png"));
        //Address
        $("#currentAddress").shouldHave(text("Moscow Street 1"));
        $("#state").setValue("ncr") .pressEnter();
        $("#city").setValue("noida") .pressEnter();
        $("#submit").click();

// Проверки
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Sensey Sontyago"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("UsertestX@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9998887766"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("11 April,2001"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("google.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Tг.Москва ул.Новая дом 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
    }
}