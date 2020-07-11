package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaHomeHelper;

public class ElemaCollectionsTest {
    private ElemaHomeHelper elemaHomeHelper = new ElemaHomeHelper();

    @Test(priority = 22)
    public void checkHeaderCollections() {
        Assert.assertTrue(elemaHomeHelper.navigateToElemaColectionsPage().checkHeaderCollections(), "Header is not shown.");
    }

    @Test(priority = 23)
    public void checkTextCollections() {
        Assert.assertTrue(elemaHomeHelper.navigateToElemaColectionsPage().checkTextCollections(), "Text is not shown.");
    }

    @AfterTest
    public void tearDown() {
        elemaHomeHelper.quit();
    }

}
