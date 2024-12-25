package screens.components;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchResultListScreen {

    private final ElementsCollection listOfSearchResultElements = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Проверить, что контент найден")
    public  void checkSearchResult() {
        assertThat(listOfSearchResultElements).size().isGreaterThan(0);
    }

    @Step("Открыть самую первую статью")
    public  void openArticle() {
        listOfSearchResultElements.first().click();
    }

}
