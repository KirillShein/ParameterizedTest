package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class JenKinsRusWineCatalog {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.ruswine-spb.ru/catalog";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:124@selenoid.autotests.cloud/wb/hub";
    }


    @Test
    @Tag("simple")
    void verifyWineCardsContentJenkinstest() {
        SelenideLogger.addListener("alluer", new AllureSelenide());

        step("открыть страницу каталог", ()-> {
            open("https://www.ruswine-spb.ru/catalog");
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
