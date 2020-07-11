package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaHomeHelper;

public class ElemaSearchNegativeTest {
    private ElemaHomeHelper elemaHomeHelper = new ElemaHomeHelper();
    private String searchKey;

    @DataProvider
    public static Object[][] searchKeyProvider() {
        return new Object[][]{{"    "}, {"test"}, {"Белиберда"}, {"!\"№;%:?*()[]{}"}};
    }

    @Factory(dataProvider = "searchKeyProvider")
    public ElemaSearchNegativeTest(String searchKey) {
        this.searchKey = searchKey;
    }

    @Test(priority = 8)
    public void countSearchResultsperPage() {
        int countPerPage = elemaHomeHelper.search(searchKey).getSearchResultsCountPerPage();
        System.out.println("Results per page: " + countPerPage);
        Assert.assertTrue(countPerPage == 0, "Some results were found");
    }

    @Test(priority = 9)
    public void countAllSearchResults() {
        int allResultsFound = elemaHomeHelper.search(searchKey).getAllResultsCount();
        System.out.println("All results found: " + allResultsFound);
        Assert.assertTrue(allResultsFound == 0, "Some results were found");
    }

}
