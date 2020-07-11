package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaHomeHelper;

import java.util.ArrayList;

public class ElemaNewsTest {

    private ElemaHomeHelper elemaHomeHelper = new ElemaHomeHelper();

    @Test(priority = 26)
    public void checkNewsHeaderPresent() {
        Assert.assertTrue(elemaHomeHelper.navigateToElemaNewsPage().checkNewsHeader(), "News header is not shown.");
    }

    @Test(priority = 27)
    public void checkNewsHeaderText() {
        String expectedText = "НОВОСТИ";
        String observerText = elemaHomeHelper.navigateToElemaNewsPage().getNewsHeaderText();
        Assert.assertTrue(observerText.equals(expectedText), "Header text is not correct.");
    }

    @Test(priority = 28)
    public void checkSideSectionElementsList() {
        ArrayList<String> expectedSideSectionElementsList = getExpectedSideSectionElementsList();
        ArrayList<String> observedSideSectionElementsList = elemaHomeHelper.navigateToElemaNewsPage().getSideSectionElementsList();
        Assert.assertTrue(observedSideSectionElementsList.containsAll(expectedSideSectionElementsList), "Side section list is not shown.");
    }

    @Test(priority = 29)
    public void checkSideSectionElementsNumber() {
        Assert.assertEquals(elemaHomeHelper.navigateToElemaNewsPage().getSideSectionElementsNumber(), 8, "Side section elements number is not correct.");
    }

    @AfterTest
    public void tearDown() {
        elemaHomeHelper.quit();
    }

    private ArrayList<String> getExpectedSideSectionElementsList() {
        ArrayList<String> expectedSideSectionElementsList = new ArrayList<>();
        expectedSideSectionElementsList.add("Компания");
        expectedSideSectionElementsList.add("Контакты");
        expectedSideSectionElementsList.add("Линии товаров");
        expectedSideSectionElementsList.add("Вакансии");
        expectedSideSectionElementsList.add("Новости");
        expectedSideSectionElementsList.add("Сеть магазинов");
        expectedSideSectionElementsList.add("Акционерам и инвесторам");
        expectedSideSectionElementsList.add("Наши партнёры");
        return expectedSideSectionElementsList;
    }
}
