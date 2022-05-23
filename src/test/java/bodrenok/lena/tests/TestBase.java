package bodrenok.lena.tests;

import bodrenok.lena.config.CredentialsConfig;
import bodrenok.lena.helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestBase {

    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    static String selenoid = System.getProperty("selenoid", "selenoid.autotests.cloud/wd/hub");

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String propertyBrowser = System.getProperty("propertyBrowser", "chrome");
        String propertyVersion = System.getProperty("propertyVersion", "100");
        String propertyBrowserSize = System.getProperty("propertyBrowserSize", "1920x1080");

        Configuration.browser = propertyBrowser;
        Configuration.browserVersion = propertyVersion;
        Configuration.browserSize = propertyBrowserSize;

        Configuration.remote = "https://" + config.login() + ":" + config.password() + "@" + selenoid;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void openPage() {
        step("Open page for testing", () -> {
            open("https://mobileup.ru/");
        });
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
