package screens;

import io.qameta.allure.Step;
import screens.components.SearchInputComponent;

public class MainScreen {

    @Step("Ввести в поле поиска искомое значение")
    public void enterSearchValue(String value){

        SearchInputComponent searchInputComponent = new SearchInputComponent();

        searchInputComponent.clickToSearch();
        searchInputComponent.enterSearchValue(value);
    }
}
