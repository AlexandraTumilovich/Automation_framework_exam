package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaHomeHelper;

import java.util.ArrayList;


public class ElemaSearchTest {
    private ElemaHomeHelper elemaHomeHelper = new ElemaHomeHelper();
    private String searchKey;

    @DataProvider
    public static Object[][] searchKeyProvider() {
        return new Object[][]{{"Пальто"}, {"Куртка"}, {"Блузка"}};
    }

    @Factory(dataProvider = "searchKeyProvider")
    public ElemaSearchTest(String searchKey) {
        this.searchKey = searchKey;
    }

    @Test(priority = 1)
    public void countSearchResultsPerPage() {
        int countPerPage = elemaHomeHelper.search(searchKey).getSearchResultsCountPerPage();
        System.out.println("Results per page: " + countPerPage);
        Assert.assertTrue(countPerPage > 0, "No results were found");
    }

    @Test(priority = 2)
    public void countAllSearchResults() {
        int allResultsFound = elemaHomeHelper.search(searchKey).getAllResultsCount();
        System.out.println("All results found: " + allResultsFound);
        Assert.assertTrue(allResultsFound > 0, "No results were found");
    }

    @Test(priority = 3)
    public void checkAllResultsButton() {
        Assert.assertTrue(elemaHomeHelper.search(searchKey).checkShowAllResultsButton(), "Button is not shown.");
    }

    @Test(priority = 4)
    public void clickAllResultsButton() {
        int results = elemaHomeHelper.search(searchKey).clickShowAllResultsButton().getSearchResultsCountPerPage();
        Assert.assertEquals(results, 12, "All results are not shown.");
    }

    @Test(priority = 5)
    public void checkSideTags() {
        ArrayList<String> expectedSideTags = new ArrayList<>();
        expectedSideTags.add("НОВИНКИ");
        expectedSideTags.add("СКИДКИ");
        expectedSideTags.add("ЛИКВИДАЦИЯ");
        ArrayList<String> observedSideTags = elemaHomeHelper.search(searchKey).getSideTags();
        Assert.assertTrue(observedSideTags.containsAll(expectedSideTags), "Side tags are not shown.");
    }

    @Test(priority = 6)
    public void checkCategories() {
        ArrayList<String> expectedCategories = getExpectedCategories();
        ArrayList<String> observedCategories = elemaHomeHelper.search(searchKey).getCategories();
        Assert.assertTrue(observedCategories.containsAll(expectedCategories), "Categories are not shown.");
    }

    @Test(priority = 7)
    public void checkNavigationBar() {
        ArrayList<String> expectedNavigationBar = getExpectedNavigationBar();
        ArrayList<String> observedNavigationBar = elemaHomeHelper.search(searchKey).getNavigationBar();
        Assert.assertTrue(observedNavigationBar.containsAll(expectedNavigationBar), "Navigation bar is not shown.");
    }

    @AfterTest
    public void tearDown() {
        elemaHomeHelper.quit();
    }

    private ArrayList<String> getExpectedCategories() {
        ArrayList<String> expectedCategories = new ArrayList<>();
        expectedCategories.add("Женская одежда");
        expectedCategories.add("Мужская одежда");
        expectedCategories.add("Аксессуары");
        expectedCategories.add("Парфюмерия");
        expectedCategories.add("Лето");
        expectedCategories.add("Весна");
        expectedCategories.add("Осень");
        expectedCategories.add("Зима");
        expectedCategories.add("Premium");
        expectedCategories.add("Classic");
        expectedCategories.add("Your line");
        expectedCategories.add("Sport Chic");
        expectedCategories.add("Event");
        return expectedCategories;
    }

    private ArrayList<String> getExpectedNavigationBar() {
        ArrayList<String> expectedNavigationBar = new ArrayList<>();
        expectedNavigationBar.add("КАТАЛОГ");
        expectedNavigationBar.add("КОЛЛЕКЦИИ");
        expectedNavigationBar.add("LOOKBOOK");
        expectedNavigationBar.add("БЛОГ");
        expectedNavigationBar.add("НОВОСТИ");
        expectedNavigationBar.add("#ELEMA");
        return expectedNavigationBar;
    }
}
