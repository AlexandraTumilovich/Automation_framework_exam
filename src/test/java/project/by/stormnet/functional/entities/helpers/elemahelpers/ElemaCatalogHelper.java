package project.by.stormnet.functional.entities.helpers.elemahelpers;

import org.openqa.selenium.WebElement;
import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.elemapages.ElemaCatalogPage;

import java.util.ArrayList;
import java.util.List;

public class ElemaCatalogHelper extends AbstractHelper {
    ElemaCatalogPage elemaCatalogPage = new ElemaCatalogPage();

    public ArrayList<String> getCatalogSections() {
        ArrayList<String> catalogSectionsList = new ArrayList<>();
        List<WebElement> listElements = elemaCatalogPage.getElements(elemaCatalogPage.getCatalogSections());
        for (WebElement el : listElements) {
            catalogSectionsList.add(el.getText());
        }
        return catalogSectionsList;
    }

    public boolean checkNewItemsHeader() {
        return elemaCatalogPage.getElement(elemaCatalogPage.getNewItemsHeader()).isDisplayed();
    }

    public int getNewItemsDisplayed() {
        List<WebElement> NewItemsDisplayedElements = elemaCatalogPage.getElements(elemaCatalogPage.getNewItemsDisplayed());
        return NewItemsDisplayedElements.size();
    }
}
