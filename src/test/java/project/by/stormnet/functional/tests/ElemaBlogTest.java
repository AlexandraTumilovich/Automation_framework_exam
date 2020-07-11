package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaHomeHelper;

import java.util.ArrayList;

public class ElemaBlogTest {
    private ElemaHomeHelper elemaHomeHelper = new ElemaHomeHelper();

    @Test(priority = 17)
    public void checkNavigationElements() {
        ArrayList<String> expectedNavigationElements = getExpectedNavigationElements();
        ArrayList<String> observedNavigationElements = elemaHomeHelper.navigateToElemaBlogPage().getBlogNavigationElements();
        Assert.assertTrue(observedNavigationElements.containsAll(expectedNavigationElements), "Navigation bar is not shown.");
    }

    @Test(priority = 18)
    public void getBlogArticlesNumberPerPage() {
        int numberOfBlogArticles = elemaHomeHelper.navigateToElemaBlogPage().getBlogArticlesNumber();
        System.out.println("Number of blog articles: " + numberOfBlogArticles);
        Assert.assertTrue(numberOfBlogArticles > 0, "There are no articles");
    }

    @AfterTest
    public void tearDown() {
        elemaHomeHelper.quit();
    }

    private ArrayList<String> getExpectedNavigationElements() {
        ArrayList<String> expectedNavigationElements = new ArrayList<>();
        expectedNavigationElements.add("КАК НОСИТЬ");
        expectedNavigationElements.add("СТИЛЬ");
        expectedNavigationElements.add("ТРЕНДЫ");
        return expectedNavigationElements;
    }
}
