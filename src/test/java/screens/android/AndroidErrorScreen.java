package screens.android;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class AndroidErrorScreen {

    private final SelenideElement wikiErrorTextElement = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));

    @Step("Проверить наличие ошибки и ее текст")
    public void checkErrorMessage(String errorText){

        assertThat(wikiErrorTextElement).isNotNull();

        String error = wikiErrorTextElement.getAttribute("text");
        assertThat(error)
                .as("Текст ошибки не соответствует ожидаемому")
                .isEqualTo(errorText);
    }
}
