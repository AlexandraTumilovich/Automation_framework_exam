package project.by.stormnet.functional.entities.pages.elemapages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class ElemaHomePage extends AbstractPage {
    private static String elemaLogo = "//img[@alt='elema-logo']";
    private String searchField = "//div[@class='input-group search hidden-sm hidden-xs']/input";
    private String searchButton = "//div[@class='input-group search hidden-sm hidden-xs']/span/button";
    private String login = "//a[@class='api_link settings-box-inner']";
    private String cart = "//button[@class='shopping-cart dropdown-toggle']";
    private String blogPage = "//ul[@class='nav navbar-nav']/li/a[@href='/blog/']";
    private String catalogPage = "//ul[@class='nav navbar-nav']/li/a[@href='/catalog/']";
    private String collectionsPage = "//ul[@class='nav navbar-nav']/li/a[@href='/collections/']";
    private String looBookPage = "//ul[@class='nav navbar-nav']/li/a[@href='/lookbook/']";
    private String newsPage = "//ul[@class='nav navbar-nav']/li/a[@href='/company/news/']";
    private String loginIcon = "//a[@href='#api_auth_login']"; // Иконка для вхдоха на сайта
    private String modelOpen = "//div[@class='api_modal api_modal_open']";

    public static ElemaHomePage getElemaHomePage() {
        ElemaHomePage elemaHomePage = new ElemaHomePage();
        waitForElementVisible(getElementBy(elemaLogo));
        System.out.println("Elema Home page is opened!");
        return elemaHomePage;
    }

    public ElemaHomePage navigateToElemaHomePage() {
        openUrl(elemaUrl);
        return getElemaHomePage();
    }

    public ElemaHomePage fillSearchField(String searchKey) {
        waitForElementVisible(getElementBy(searchField));
        getElement(searchField).sendKeys(searchKey);
        return getElemaHomePage();
    }

    public ElemaSearchPage clickSearchButton() {
        getElement(searchButton).click();
        return ElemaSearchPage.getElemaSearchPage();
    }

    public ElemaBlogPage navigateToElemaBlogPage() {
        navigateToElemaHomePage().getElement(blogPage).click();
        return new ElemaBlogPage();
    }

    public ElemaCatalogPage navigateToElemaCatalogPage() {
        navigateToElemaHomePage().getElement(catalogPage).click();
        return new ElemaCatalogPage();
    }

    public ElemaCollectionsPage navigateToElemaCollectionsPage() {
        navigateToElemaHomePage().getElement(collectionsPage).click();
        return new ElemaCollectionsPage();
    }

    public ElemaLookbookPage navigateToElemaLookbookPage() {
        navigateToElemaHomePage().getElement(looBookPage).click();
        return new ElemaLookbookPage();
    }

    public ElemaNewsPage navigateToElemaNewsPage() {
        navigateToElemaHomePage().getElement(newsPage).click();
        return new ElemaNewsPage();
    }

    public ElemaLoginPage navigateToElemaLoginPage() {
        navigateToElemaHomePage().getElement(loginIcon).click();
        waitForElementVisible(getElementBy(modelOpen));
        return new ElemaLoginPage();
    }
}
