package project.by.stormnet.functional.entities.helpers.elemahelpers;

import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.elemapages.ElemaLoginPage;

public class ElemaLoginHelper extends AbstractHelper {
    ElemaLoginPage elemaLoginPage = new ElemaLoginPage();

    public boolean checkRegistrationLink() { // Проверка наличия кнопки Регистрация
        return elemaLoginPage.getElement(elemaLoginPage.getCreateAccount()).isDisplayed();
    }

    public boolean validateClickRegistrationLink() {
        do {
            elemaLoginPage.getElement(elemaLoginPage.getCreateAccount()).click();
        } while (!elemaLoginPage.getElement(elemaLoginPage.getRegistrationSubmit()).isDisplayed());
        return elemaLoginPage.getElement(elemaLoginPage.getRegistrationSubmit()).isDisplayed();
    }

    public boolean newUserRegistration() {
        validateClickRegistrationLink();
        return elemaLoginPage.fillUserInfo();
    }
}
