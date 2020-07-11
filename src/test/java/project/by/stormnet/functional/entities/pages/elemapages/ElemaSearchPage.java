package project.by.stormnet.functional.entities.pages.elemapages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class ElemaSearchPage extends AbstractPage {
    private static String resultsCounter = "//div[@class='search-container combine']/div/p";
    private static String results = "//div[@class='rnd-item']";
    private static String showAllResultsButton = "//button[@class='show-cat-all']";
    private String sideTags = "//div[@class='aside-tags']/div/a";
    private String categories = "//div[@class='aside-nav-block']/ul/li/a";
    private String navigationBar="//ul[@class='nav navbar-nav']/li/a";

    public static String getShowAllResultsButton() {
        return showAllResultsButton;
    }

    public String getSideTags() {
        return sideTags;
    }

    public String getCategories() {
        return categories;
    }

    public String getNavigationBar() {
        return navigationBar;
    }

    public static String getResults() {
        return results;
    }

    public static ElemaSearchPage getElemaSearchPage(){
        ElemaSearchPage elemaSearchPage = new ElemaSearchPage();
        waitForElementVisible(getElementBy(results));
        System.out.println("Search page is opened");
        return elemaSearchPage;
    }

    public int getResultsSizePerPage(){
        return getElements(results).size();
    }

    public String getResultsCount(){
        return getElement(resultsCounter).getText();
    }


}
