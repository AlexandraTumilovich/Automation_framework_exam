package project.by.stormnet.functional.entities.pages.elemapages;

import org.openqa.selenium.By;
import project.by.stormnet.functional.entities.pages.AbstractPage;
import java.util.Random;

public class ElemaLoginPage extends AbstractPage {
    private String createAccount = "//div[@class='api_modal api_modal_open']/div/div/div/div/form/div/div/a[@data-header='Регистрация']"; //кнопка "Регистрация"
    private String logout = "//i[@class='icon-logout icons']";
    private String registrationLoginField = "//input[@name='FIELDS[LOGIN]']"; // поле "Логин" при регистрации
    private String registrationPassword = "//input[@name='FIELDS[PASSWORD]']"; // поле "Пароль" при регистрации
    private String registrationConfirmationPassword = "//input[@name='FIELDS[CONFIRM_PASSWORD]']"; // Поле подтверждения пароль при регистрации
    private String registrationEmail = "//input[@name='FIELDS[EMAIL]']"; // Поле email при регистраци
    private String registrationSubmit = "//form[@id='bx_1004171869_Hnj7Ij']/div/button"; // Зарегистрироваться
    private String login;
    private String password;
    private String email;

    public String getCreateAccount() {
        return createAccount;
    }

    public String getRegistrationSubmit() {
        return registrationSubmit;
    }

    public boolean fillUserInfo() {
        createUserInfo();
        getElement(registrationLoginField).clear();
        getElement(registrationLoginField).sendKeys(login);
        getElement(registrationPassword).clear();
        getElement(registrationPassword).sendKeys(password);
        getElement(registrationConfirmationPassword).clear();
        getElement(registrationConfirmationPassword).sendKeys(password);
        getElement(registrationEmail).clear();
        getElement(registrationEmail).sendKeys(email);
        getElement(registrationSubmit).click();
        waitForElementVisible(By.xpath(logout));
        boolean userLoggedIn = getElement(logout).isDisplayed();
        getElement(logout).click();
        return userLoggedIn;
    }

    public String generateRandomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder(8);
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String message = sb.toString();
        return message;
    }

    public void createUserInfo() {
        login = generateRandomString();
        password = generateRandomString();
        email = "test_" + generateRandomString() + "@test.com";
        System.out.println("Login: " + login + ", password: " + password + ", email: " + email);
    }
}
