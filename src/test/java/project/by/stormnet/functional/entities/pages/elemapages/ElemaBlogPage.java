package project.by.stormnet.functional.entities.pages.elemapages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class ElemaBlogPage extends AbstractPage {
    private String blogNavigation= "//div[@class='blog-nav']/ul/li";
    private String blogArticle = "//main/article";

    public String getBlogNavigation() {
        return blogNavigation;
    }

    public String getBlogArticle() {
        return blogArticle;
    }
}
