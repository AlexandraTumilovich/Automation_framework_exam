package project.by.stormnet.functional.entities.pages.elemapages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class ElemaNewsPage extends AbstractPage {
    private String headerNews = "//div[@class='company-content']/h1";
    private String sideSection = "//aside[@id='aside-nav']/ul/li";

    public String getHeaderNews() {
        return headerNews;
    }

    public String getSideSection() {
        return sideSection;
    }
}
