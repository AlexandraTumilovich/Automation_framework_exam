package project.by.stormnet.functional.entities.helpers.elemahelpers;

import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.pages.elemapages.ElemaCollectionsPage;

public class ElemaCollectionsHelper extends AbstractHelper {

    ElemaCollectionsPage elemaCollectionsPage = new ElemaCollectionsPage();

    public boolean checkHeaderCollections(){
        return elemaCollectionsPage.getElement(elemaCollectionsPage.getHeaderCollections()).isDisplayed();
    }

    public boolean checkTextCollections(){
        return elemaCollectionsPage.getElement(elemaCollectionsPage.getTextCollections()).isDisplayed();
    }
}
