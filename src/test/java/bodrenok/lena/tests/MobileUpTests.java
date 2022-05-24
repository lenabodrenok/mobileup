package bodrenok.lena.tests;

import bodrenok.lena.domain.MenuItem;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MobileUpTests extends TestBase {

    @DisplayName("Checking main page menu")
    @EnumSource(MenuItem.class)
    @ParameterizedTest()
    void mainMenuTest(MenuItem testData) {
        step("Check item: " + testData.rusName, () -> {
            $(".main-nav__list").$(byText(testData.rusName)).click();
            $(".grid").shouldBe(visible);
        });
    }

    @DisplayName("Checking vacancy QA automation engineer")
    @Test
    void vacancyTest() {
        step("Select 'Вакансии'", () -> {
            $$(".main-nav__link").findBy(text("Вакансии")).click();
        });
        step("Check 'QA auto'", () -> {
            $$(".vacancies-front__vacancy-item").findBy(text("QA auto")).shouldBe(visible);
        });
    }

    @DisplayName("Checking form")
    @Test
    void fillFormTest() {
        step("Select 'Оставить заявку'", () -> {
            $(".intro__content").$("#button").click();
        });
        step("Fill form", () -> {
            $("#customer-name").setValue("Name");
            $("#customer-email").setValue("Email");
            $("#customer-tel").setValue("");
            $("#customer-company").setValue("Компания");
            $("#project-description").setValue("Пара слов");
            $("#customer-price").setValue("1000000");
            $("#load-file").uploadFromClasspath("file.png");
            $(".project-form__submit-btn").scrollIntoView(false).click();
        });
        step("Check results", () -> {
            $(".project-form__field--invalid").shouldHave(pseudo(":after", "content", "\"Что-то не так с адресом e-mail\""));
            $(".project-form__field--invalid", 1).shouldHave(pseudo(":after", "content", "\"Пожалуйста, заполните это поле\""));
        });
    }

    @DisplayName("Checking Telegram link")
    @Test
    void linkTest() {
        step("Select 'Tg'", () -> {
            $$(".social-links__item").findBy(text("Tg")).click();
        });
        step("Check open", () -> {
            Assertions.assertEquals(2, WebDriverRunner.getWebDriver().getWindowHandles().size());
        });
    }
}



