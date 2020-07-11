package project.by.stormnet.functional.entities.pages.elemapages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class ElemaLookbookPage extends AbstractPage {
    private String lookbookHeader = "//h1[@class='elema-head']";
    private String lookbookText = "//div[@class='look-head']/p";

    public String getLookbookHeader() {
        return lookbookHeader;
    }

    public String getLookbookText() {
        return lookbookText;
    }
}
