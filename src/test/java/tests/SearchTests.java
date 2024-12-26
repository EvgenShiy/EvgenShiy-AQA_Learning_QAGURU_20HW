package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ErrorScreen;
import screens.MainScreen;
import screens.SearchResultListScreen;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    private final MainScreen mainScreen = new MainScreen();
    private final SearchResultListScreen searchResultListScreen = new SearchResultListScreen();
    private final ErrorScreen errorScreen = new ErrorScreen();

    @Test
    @DisplayName("Проверка успешного поиска контента")
    @Tag("mobile_test")
    @Tag("browserstack_test")
    void successfulSearchTest() {

        step("Напечатать в поиске слово 'Appium'", () -> {
            mainScreen.enterSearchValue("Appium");
        });
        step("Проверить, что контент найден", searchResultListScreen::checkSearchResult);
    }

    @Test
    @DisplayName("Проверка отображения ошибки при открытии статьи")
    @Tag("mobile_test")
    @Tag("browserstack_test")
    void checkErrorMessageTextTest() {

        step("Напечатать в поиске слово 'Appium'", () -> {
            mainScreen.enterSearchValue("Appium");
        });

        step("Открыть первую статью", searchResultListScreen::openTopic);

        step("Проверить текст сообщения об ошибке", () -> {
            errorScreen.checkErrorMessage("An error occurred");
        });
    }
}