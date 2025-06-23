package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.RusWineCatalogPage;




public class RusWineWebCatalog extends TestBase {

    RusWineCatalogPage rusWineCatalogPage = new RusWineCatalogPage();

    @DisplayName("Проверяем карточки у категорий вина")
    @ValueSource(strings = {
            "Красное", "Белое", "Игристое", "Оранжевое", "Розовое"
    })
    @ParameterizedTest(name = "Для проверки карточек у {0} вина")
    @Tag("BLOCKER")
    void verifyWineCardsContent(String wineSort) {
        rusWineCatalogPage.openPage()
                            .setCategoriesTitle()
                            .setCategoriesWine(wineSort)
                            .setCardWineContent();

    }

    @DisplayName("Проверяем карточки у категорий вина")
    @CsvSource(value = {
            "Красное, Дагестан",
            "Белое, Кубань",
            "Игристое, Самара",
            "Оранжевое, Долина Терека",
            "Розовое, Крым",
    })
    @ParameterizedTest(name = "Для проверки карточек у {0} вина")
    @Tag("BLOCKER")
    void verifWineRegionAndSortCardsContent(String wineSort, String regionWine) {
        rusWineCatalogPage.openPage()
                .setCategoriesTitle()
                .setCategoriesWine(wineSort)
                .setWineriesTitle()
                .setWineriesWine(regionWine)
                .setCardWineContent();
    }
}
