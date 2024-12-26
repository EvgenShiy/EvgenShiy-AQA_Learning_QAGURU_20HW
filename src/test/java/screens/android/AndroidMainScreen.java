package screens.android;

import io.qameta.allure.Step;
import screens.android.components.SearchInputComponent;

public class AndroidMainScreen {

    @Step("Ввести в поле поиска искомое значение")
    public void enterSearchValue(String value){

        SearchInputComponent searchInputComponent = new SearchInputComponent();

        searchInputComponent.clickToSearch();
        searchInputComponent.enterSearchValue(value);
    }
}
