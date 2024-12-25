package screens.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchInputComponent {

    private final SelenideElement accessibilityIdElement = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement searchInputTextElement = $(id("org.wikipedia.alpha:id/search_src_text"));

    @Step("Нажать на поле 'Поиск', чтобы выполнить поисковый запрос")
    public void clickToSearch(){
        accessibilityIdElement.click();
    }

    @Step("Ввести значение для поиска")
    public void enterSearchValue(String value){
        searchInputTextElement.sendKeys(value);
    }
}
