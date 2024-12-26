package tests.android;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.android.AndroidErrorScreen;
import screens.android.AndroidMainScreen;
import screens.android.AndroidSearchResultListScreen;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

public class AndroidSearchTests extends TestBase {

    private final AndroidMainScreen androidMainScreen = new AndroidMainScreen();
    private final AndroidSearchResultListScreen androidSearchResultListScreen = new AndroidSearchResultListScreen();
    private final AndroidErrorScreen androidErrorScreen = new AndroidErrorScreen();

    @Test
    @DisplayName("Проверка успешного поиска контента")
    @Tag("android")
    @Tag("ios")
    @Tag("browserstack_test")
    void successfulSearchTest() {

        step("Напечатать в поиске слово 'Appium'", () -> {
            androidMainScreen.enterSearchValue("Appium");
        });
        step("Проверить, что контент найден", androidSearchResultListScreen::checkSearchResult);
    }

    @Test
    @DisplayName("Проверка отображения ошибки при открытии статьи")
    @Tag("android")
    @Tag("ios")
    @Tag("browserstack_test")
    void checkErrorMessageTextTest() {

        step("Напечатать в поиске слово 'Appium'", () -> {
            androidMainScreen.enterSearchValue("Appium");
        });

        step("Открыть первую статью", androidSearchResultListScreen::openTopic);

        step("Проверить текст сообщения об ошибке", () -> {
            androidErrorScreen.checkErrorMessage("An error occurred");
        });
    }
}