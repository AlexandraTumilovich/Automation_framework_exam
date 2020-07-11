package project.by.stormnet.functional.entities.helpers.elemahelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.elemapages.ElemaItemPage;
import project.by.stormnet.functional.entities.pages.elemapages.ElemaSearchPage;

import java.util.ArrayList;
import java.util.List;

public class ElemaSearchHelper extends AbstractHelper {
    private ElemaSearchPage elemaSearchPage = new ElemaSearchPage();

    public int getSearchResultsCountPerPage() {
        return elemaSearchPage.getResultsSizePerPage();
    }

    public int getAllResultsCount() {
        return Integer.parseInt(elemaSearchPage.getResultsCount().split(":")[1]);
    }

    public boolean checkShowAllResultsButton() {
        return elemaSearchPage.isElementVisible(By.xpath(ElemaSearchPage.getShowAllResultsButton()));
    }

    public ElemaSearchHelper clickShowAllResultsButton() {
        elemaSearchPage.scrollPage(0, 600);
        ElemaSearchPage.waitForElementVisible(By.xpath(ElemaSearchPage.getShowAllResultsButton()));
        elemaSearchPage.getElement(ElemaSearchPage.getShowAllResultsButton()).click();
        return this;
    }

    public ArrayList<String> getSideTags() {
        ArrayList<String> sideTags = new ArrayList<>();
        List<WebElement> list1 = elemaSearchPage.getElements(elemaSearchPage.getSideTags());
        for (WebElement el1 : list1) {
            sideTags.add(el1.getText());
        }
        return sideTags;
    }

    public ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<>();
        List<WebElement> list2 = elemaSearchPage.getElements(elemaSearchPage.getCategories());
        for (WebElement el1 : list2) {
            categories.add(el1.getText());
        }
        return categories;
    }

    public ArrayList<String> getNavigationBar() {
        ArrayList<String> navBar = new ArrayList<>();
        List<WebElement> list3 = elemaSearchPage.getElements(elemaSearchPage.getNavigationBar());
        for (WebElement el1 : list3) {
            navBar.add(el1.getText());
        }
        return navBar;
    }

    public ElemaItemHelper getElemaItem() {
        elemaSearchPage.getElement(ElemaSearchPage.getResults() + "[1]").click();
        System.out.println("Open Elema Item page");
        ElemaSearchPage.waitForElementVisible(ElemaSearchPage.getElementBy(ElemaItemPage.getArticulNumber()));
        return new ElemaItemHelper();
    }
}
