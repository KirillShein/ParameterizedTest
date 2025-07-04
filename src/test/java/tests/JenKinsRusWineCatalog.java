package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class JenKinsRusWineCatalog {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.ruswine-spb.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = System.getProperty("browserSize", "1980x1100");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.remote = System.getProperty("remoteUrl");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }


    @Test
    @Tag("simple")
    void verifyWineCardsContentJenkinstest() {


        step("открыть страницу каталог", ()-> {
            open("/catalog");
        });

        step("кликнуть по названию категории вина", ()-> {
            $(".categories__title").click();
        });

        step("в модальном окне найти и кликнуть по категории вина", ()-> {
            $(".categories__popup").find(byText("Красное")).click();
        });

        step("проверить что отображаются карточки товара по выбранной категории", ()-> {
            $$(".productlist__content").shouldBe(sizeGreaterThan(0));
        });

    }
}
