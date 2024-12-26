package screens.android;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;


public class AndroidSearchResultListScreen {

    private final ElementsCollection listOfSearchResultElements = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Проверить, что контент найден")
    public  void checkSearchResult() {
        assertThat(listOfSearchResultElements)
                .as("Список результатов поиска пуст")
                .size().isGreaterThan(0);
    }

    @Step("Открыть первую статью в списке")
    public  void openTopic() {
        assertThat(listOfSearchResultElements).isNotEmpty();
        listOfSearchResultElements.first().click();
    }

}
