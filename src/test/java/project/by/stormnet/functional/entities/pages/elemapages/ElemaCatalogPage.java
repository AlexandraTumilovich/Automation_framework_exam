package project.by.stormnet.functional.entities.pages.elemapages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class ElemaCatalogPage extends AbstractPage {
    private String catalogSections = "//div[@class='row sect_name_block']/a";
    private String newItemsHeader = "//h2[text()='Новинки этого сезона']";
    private String newItemsDisplayed = "//div[@class='slick-track']/div[@aria-hidden='false']";

    public String getCatalogSections() {
        return catalogSections;
    }

    public String getNewItemsHeader() {
        return newItemsHeader;
    }

    public String getNewItemsDisplayed() {
        return newItemsDisplayed;
    }
}
