package bodrenok.lena.tests;

import bodrenok.lena.domain.MenuItem;
import bodrenok.lena.helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class MobileUpTests {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        baseUrl = "https://mobileup.ru";
    }

    @DisplayName("Checking main page menu")
    @EnumSource(MenuItem.class)
    @ParameterizedTest()
    void mainMenuTest(MenuItem testData) {
        step("Open " + baseUrl, () -> Selenide.open(baseUrl));
        step("Check item: " + testData.rusName, () -> {
            $(".main-nav__list").$(byText(testData.rusName)).click();
            $(".grid").shouldBe(visible);
        });
    }

    @DisplayName("Checking vacancy QA automation engineer")
    @Test
    void vacancyTest() {
        step("Open " + baseUrl, () -> Selenide.open(baseUrl));
        step("Select 'Вакансии'", () -> {
            $$(".main-nav__link").findBy(text("Вакансии")).click();
        });
        step("Check 'QA auto'", () -> {
            $$(".vacancies-front__vacancy-item").findBy(text("QA auto")).shouldBe(visible);
        });
    }

    @DisplayName("Checking form") // доделать
    @Test
    void fillFormTest() {
        step("Open " + baseUrl, ()-> Selenide.open(baseUrl));
        step("Select 'Оставить заявку'", () -> {
            $(".intro__content").$("#button").click();
        });
        step("Fill form", () -> {
            $("#customer-name").setValue("Name");
            $("#customer-email").setValue("Email");
           // $("#customer-tel").setValue("+7 (123) 111-11-11"); // не работает
            //$("#customer-tel").$("[title]").setValue("+7 (123) 111-11-11"); // не работает
            $("#customer-company").setValue("Компания");
            $("#project-description").setValue("Пара слов");
            $("#customer-price").setValue("1000000");
            $("#load-file").uploadFromClasspath("file.png");
            $(".project-form__submit-btn").scrollIntoView(false).click();
        });
        step("Check results", () -> {
            //$(byAttribute("data-error-msg", "Что-то не так с адресом e-mail")).shouldBe(visible);
            //$("[data-error-msg=Что-то не так с адресом e-mail]").shouldBe(visible);
            //$(".project-form__field-wrapper").findBy(text("Что-то не так с адресом e-mail")).shouldBe(visible);
        });
    }

    @DisplayName("Checking the Telegram link")
    @Test
    void linkTest() {
        step("Open " + baseUrl, () -> Selenide.open(baseUrl));
        step("Select 'Tg'", () -> {
            $$(".social-links__item").findBy(text("Tg")).click();
        });
        step("Check open", () -> {
            Assertions.assertEquals(2, WebDriverRunner.getWebDriver().getWindowHandles().size());
        });
    }



    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}



