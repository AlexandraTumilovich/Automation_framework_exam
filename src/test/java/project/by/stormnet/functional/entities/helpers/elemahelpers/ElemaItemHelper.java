package project.by.stormnet.functional.entities.helpers.elemahelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.elemapages.ElemaItemPage;
import java.util.List;

public class ElemaItemHelper extends AbstractHelper {
    private ElemaItemPage elemaItemPage = new ElemaItemPage();

    public boolean checkArticulNumberNotNull(){
        return !(elemaItemPage.getElement(ElemaItemPage.getArticulNumber()).getText().isEmpty());
    }

    public boolean checkModelNumberNotNull(){
        return !(elemaItemPage.getElement(elemaItemPage.getModelNumber()).getText().isEmpty());
    }

    public boolean checkSimilarGoods(){
        List<WebElement> similarGoods = elemaItemPage.getElements(elemaItemPage.getSimilarProductsDisplayed());
        return similarGoods.size()>0;
    }

    public boolean checkNewPrice(){
        return !(elemaItemPage.getElement(elemaItemPage.getNewPrice()).getText().isEmpty());
    }

    public boolean checkOldPrice(){
        return !(elemaItemPage.getElement(elemaItemPage.getOldPrice()).getText().isEmpty());
    }

    public boolean addItemToCart(){
        elemaItemPage.scrollPage(0, 300);
        elemaItemPage.getElement(elemaItemPage.getAddToCart()).click();
        ElemaItemPage.waitForElementVisible(By.xpath(elemaItemPage.getDeleteItemInCart()));
        String numberOfItemsInCart = elemaItemPage.getElement(elemaItemPage.getCartTextNumber()).getText();
        elemaItemPage.getElement(elemaItemPage.getDeleteItemInCart()).click();
        return numberOfItemsInCart.equals("1");
    }

    public boolean checkAmountInShops(){
        return !(elemaItemPage.getElement(elemaItemPage.getCheckAmount()).getText().isEmpty());
    }
}
