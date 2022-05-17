package bodrenok.lena.tests;

import bodrenok.lena.domain.MenuItem;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

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
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

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
}



