package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaHomeHelper;
import project.by.stormnet.functional.entities.helpers.elemahelpers.ElemaItemHelper;

public class ElemaItemTest {
    private ElemaHomeHelper elemaHomeHelper = new ElemaHomeHelper();
    private String searchKey;

    @DataProvider
    public static Object[][] searchKeyProvider() {
        return new Object[][]{{"Плащ"}, {"Дубленка"}, {"Полупальто"}};
    }

    @Factory(dataProvider = "searchKeyProvider")
    public ElemaItemTest(String searchKey) {
        this.searchKey = searchKey;
    }

    @Test(priority = 10)
    public void checkArticulNumber() {
        Assert.assertTrue(getElemaItem().checkArticulNumberNotNull(), "Articul number is absent.");
    }

    @Test(priority = 11)
    public void checkModelNumber() {
        Assert.assertTrue(getElemaItem().checkModelNumberNotNull(), "Model number is absent.");
    }

    @Test(priority = 12)
    public void checkNewPrice() {
        Assert.assertTrue(getElemaItem().checkNewPrice(), "New Price is absent.");
    }

    @Test(priority = 13)
    public void checkOldPrice() {
        Assert.assertTrue(getElemaItem().checkOldPrice(), "Old Price is absent.");
    }

    @Test(priority = 14)
    public void checkSimilarGoodsDisplayed() {
        Assert.assertTrue(getElemaItem().checkSimilarGoods(), "Similar goods are not displayed.");
    }

    @Test(priority = 15)
    public void addItemToCart() {
        String item1 = "БРЮКИ ЖЕНСКИЕ 3К-10688-1";
        Assert.assertTrue(elemaHomeHelper.search(item1).getElemaItem().addItemToCart(), "Item is not added to cart.");
    }

    @Test(priority = 16)
    public void checkAmountInShops() {
        Assert.assertTrue(getElemaItem().checkAmountInShops(), "Amount in shops is not shown.");
    }

    @AfterTest
    public void tearDown() {
        elemaHomeHelper.quit();
    }

    private ElemaItemHelper getElemaItem() {
        return elemaHomeHelper.search(searchKey).getElemaItem();
    }
}
