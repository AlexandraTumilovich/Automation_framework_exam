package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaHomeHelper;

import java.util.ArrayList;

public class ElemaLookbookTest {
    private ElemaHomeHelper elemaHomeHelper = new ElemaHomeHelper();

    @Test(priority = 24)
    public void checkLookbookHeader() {
        Assert.assertTrue(elemaHomeHelper.navigateToElemaLookbookPage().checkLookbookHeader(), "Header is not shown.");
    }

    @Test(priority = 25)
    public void checkLookbookText() {
        ArrayList<String> expectedLookbookText = getExpectedLookbookText();
        ArrayList<String> observedLookbookText = elemaHomeHelper.navigateToElemaLookbookPage().getLookbookText();
        Assert.assertTrue(observedLookbookText.containsAll(expectedLookbookText), "Navigation bar is not shown.");
    }

    @AfterTest
    public void tearDown() {
        elemaHomeHelper.quit();
    }

    private ArrayList<String> getExpectedLookbookText() {
        ArrayList<String> expectedLookbookText = new ArrayList<>();
        expectedLookbookText.add("В данном разделе мы собрали для вас идеи, что и с чем носить.");
        expectedLookbookText.add("Над каждым образом поработал наш стилист.");
        return expectedLookbookText;
    }
}
