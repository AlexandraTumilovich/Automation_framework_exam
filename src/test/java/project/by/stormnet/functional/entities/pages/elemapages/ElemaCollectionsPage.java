package project.by.stormnet.functional.entities.pages.elemapages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class ElemaCollectionsPage extends AbstractPage {
    private String headerCollections = "//span[@class='elema-head fz-30']";
    private String textCollections = "//p[@class='ext']";

    public String getHeaderCollections() {
        return headerCollections;
    }

    public String getTextCollections() {
        return textCollections;
    }
}
