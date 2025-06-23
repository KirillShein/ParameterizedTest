package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RusWineCatalogPage {

    public RusWineCatalogPage openPage() {
        open("catalog");
        return this;
    }

    private SelenideElement categoriesTitle = $(".categories__title"),
                            categoriesWine = $(".categories__popup"),
                            wineriesTitle = $(".wineries__title"),
                            wineriesWine = $(".wineries__popup");


    private ElementsCollection cardWineContent = $$(".productlist__content");


    public RusWineCatalogPage setCategoriesTitle() {
        categoriesTitle.click();

        return this;
    }

    public RusWineCatalogPage setCategoriesWine(String value) {
        categoriesWine.find(byText(value)).click();

        return this;
    }

    public RusWineCatalogPage setCardWineContent() {
        cardWineContent.shouldBe(sizeGreaterThan(0));

        return this;
    }

    public RusWineCatalogPage setWineriesTitle() {
        wineriesTitle.click();

        return this;
    }

    public RusWineCatalogPage setWineriesWine(String value) {
        wineriesWine.find(byText(value)).click();

        return this;
    }





}
