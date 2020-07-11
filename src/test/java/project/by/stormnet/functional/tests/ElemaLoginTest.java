package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaHomeHelper;

public class ElemaLoginTest {

    private ElemaHomeHelper elemaHomeHelper = new ElemaHomeHelper();

    @Test(priority = 30)
    public void validateClickLoginIcon() {
        Assert.assertTrue(elemaHomeHelper.navigateToElemaLoginPage().checkRegistrationLink(), "Registration button is not shown.");
    }

    @Test(priority = 31)
    public void validateClickRegistrationLink() {
        Assert.assertTrue(elemaHomeHelper.navigateToElemaLoginPage().validateClickRegistrationLink(), "Registration submit button is not shown.");
    }

    @Test(priority = 32)
    public void newUserRegistration() {
        Assert.assertTrue(elemaHomeHelper.navigateToElemaLoginPage().newUserRegistration(), "New user is not logged in.");
    }

    @AfterTest
    public void tearDown() {
        elemaHomeHelper.quit();
    }
}
