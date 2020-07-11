package project.by.stormnet.functional.entities.helpers.elemahelpers;

import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.elemapages.ElemaHomePage;

public class ElemaHomeHelper extends AbstractHelper {
    private ElemaHomePage elemaHomePage = new ElemaHomePage();

    public ElemaHomeHelper navigateToElemaHomePage() {
        System.out.println("Navigate to 'Home' page");
        elemaHomePage.navigateToElemaHomePage();
        return this;
    }

    public ElemaSearchHelper search(String searchKey) {
        navigateToElemaHomePage();
        elemaHomePage
                .fillSearchField(searchKey)
                .clickSearchButton();
        return new ElemaSearchHelper();
    }

    public ElemaBlogHelper navigateToElemaBlogPage() {
        elemaHomePage.navigateToElemaBlogPage();
        return new ElemaBlogHelper();
    }

    public ElemaCatalogHelper navigateToElemaCatalogPage() {
        elemaHomePage.navigateToElemaCatalogPage();
        return new ElemaCatalogHelper();
    }

    public ElemaCollectionsHelper navigateToElemaColectionsPage() {
        elemaHomePage.navigateToElemaCollectionsPage();
        return new ElemaCollectionsHelper();
    }

    public ElemaLookbookHelper navigateToElemaLookbookPage() {
        elemaHomePage.navigateToElemaLookbookPage();
        return new ElemaLookbookHelper();
    }

    public ElemaNewsHelper navigateToElemaNewsPage() {
        elemaHomePage.navigateToElemaNewsPage();
        return new ElemaNewsHelper();
    }

    public ElemaLoginHelper navigateToElemaLoginPage() {
        elemaHomePage.navigateToElemaLoginPage();
        return new ElemaLoginHelper();
    }

}
