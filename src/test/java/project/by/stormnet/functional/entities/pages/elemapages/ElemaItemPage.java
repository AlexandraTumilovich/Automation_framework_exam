package project.by.stormnet.functional.entities.pages.elemapages;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class ElemaItemPage extends AbstractPage {

    private String addToCart = "//a[@class='add-to-cart']"; // Добавить в корзину
    private String checkAmount = "//a[@class='modal-link check-amount']";  //Проверить наличие в магазинах
    private String similarProductsDisplayed = "//div[@data-entity='items-row']/div/div/div[@aria-hidden='false']";
    private static String articulNumber = "//div[@class='et-props-artikul'][1]/span";
    private String modelNumber = "//div[@class='et-props-artikul'][2]/span";
    private String newPrice = "//span[@class='product-item-detail-price-current']/span[@class='newprice']";
    private String oldPrice = "//span[@class='product-item-detail-price-current']/span[@class='product-item-detail-price-old']";
    private String cartTextNumber = "//button[@class='shopping-cart dropdown-toggle']/span/span[@class='item-text-number']";
    private String deleteItemInCart = "//div[@class='dropdown-menu']/ul/li/div[@class='cart-info']/p[@class='delete']";

    public String getAddToCart() {
        return addToCart;
    }

    public String getCheckAmount() {
        return checkAmount;
    }

    public String getSimilarProductsDisplayed() {
        return similarProductsDisplayed;
    }

    public static String getArticulNumber() {
        return articulNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public String getCartTextNumber() {
        return cartTextNumber;
    }

    public String getDeleteItemInCart() {
        return deleteItemInCart;
    }
}
