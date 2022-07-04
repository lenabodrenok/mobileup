package bodrenok.lena.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class MobileUpTestsAllureTestOps extends TestBase {


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
        step("Find form", () -> {
            $(".main-nav__list").$(byText("Контакты")).click();
            $(".contacts__header-promo").$(byText("Написать нам")).click();
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
        step("Select 'Контакты'", () -> {
            $(".main-nav__list").$(byText("Контакты")).click();
        });
        step("Select 'Tg'", () -> {
            $$(".social-links__item").findBy(text("Tg")).click();
        });
        step("Check open new tab", () -> {
            Assertions.assertEquals(2, WebDriverRunner.getWebDriver().getWindowHandles().size());
        });
    }

    @Test
    @AllureId("10914")
    @DisplayName("autorization")
    @Owner("allure8")
    void autoTest() {
        step("Открываем главную страницу");
        step("Нажимаем кнопку Авторизация");
        step("Выбираем способ авторизации через FaceBook");
        step("Авторизуемся как пользователь", () -> {
            step("Ввести логин LOGIN");
            step("Ввести пароль PASSWORD");
        });
        step("Нажать кнопку Войти");
        step("Должны оказаться на главной странице сайта");
        step("Профиль пользователя должен быть заполнен из FaceBook");
        step("Нажать кнопку Выйти");
    }
    @Test
    @AllureId("10914")
    @DisplayName("autorization")
    @Owner("allure8")
    void autoTestic() {
        step("Открываем главную страницу");
        step("Нажимаем кнопку Авторизация");
        step("Выбираем способ авторизации через FaceBook");
        step("Авторизуемся как пользователь", () -> {
            step("Ввести логин LOGIN");
            step("Ввести пароль PASSWORD");
        });
        step("Нажать кнопку Войти");
        step("Должны оказаться на главной странице сайта");
        step("Профиль пользователя должен быть заполнен из FaceBook");
        step("Нажать кнопку Выйти");
    }
}

