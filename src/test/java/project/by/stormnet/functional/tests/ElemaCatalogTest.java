package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaCatalogHelper;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaHomeHelper;

import java.util.ArrayList;

public class ElemaCatalogTest {
    private ElemaHomeHelper elemaHomeHelper = new ElemaHomeHelper();

    @Test(priority = 19)
    public void checkCatalogSections() {
        ArrayList<String> expectedCatalogSections = getExpectedCatalogSections();
        ArrayList<String> observedCatalogSections = getElemaCatalogHelper().getCatalogSections();
        Assert.assertTrue(observedCatalogSections.containsAll(expectedCatalogSections), "Catalog sections are not shown.");
    }

    @Test(priority = 20)
    public void checkNewItemsHeader() {
        Assert.assertTrue(getElemaCatalogHelper().checkNewItemsHeader(), "New items Header is not shown.");
    }

    @Test(priority = 21)
    public void checkNewItemsDisplayed() {
        Assert.assertEquals(getElemaCatalogHelper().getNewItemsDisplayed(), 5, "New items are not shown.");
    }


    @AfterTest
    public void tearDown() {
        elemaHomeHelper.quit();
    }

    private ArrayList<String> getExpectedCatalogSections() {
        ArrayList<String> expectedCatalogSections = new ArrayList<>();
        expectedCatalogSections.add("Мужская одежда");
        expectedCatalogSections.add("Женская одежда");
        expectedCatalogSections.add("Парфюмерия");
        expectedCatalogSections.add("Аксессуары");
        return expectedCatalogSections;
    }

    private ElemaCatalogHelper getElemaCatalogHelper() {
        return elemaHomeHelper.navigateToElemaCatalogPage();
    }

}
