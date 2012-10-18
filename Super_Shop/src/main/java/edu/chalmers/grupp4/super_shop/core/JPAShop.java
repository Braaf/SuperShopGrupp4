package edu.chalmers.grupp4.super_shop.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The complete shop as a singleton
 * 
 * NOTE: Uses Java 1.7
 *
 * @author hajo
 */
public enum JPAShop {

    INSTANCE;
    private final IProductCatalogue productCatalogue = ProductCatalogue.newInstance("shop_pu");
    private final ICustomerRegistry customerRegistry = CustomerRegistry.newInstance("shop_pu");
    private final IOrderBook orderBook = OrderBook.newInstance("shop_pu");
    private final QueryProcessor queryProcessor = QueryProcessor.newInstance("shop_pu");

    private JPAShop() {
        Logger.getAnonymousLogger().log(Level.INFO, "Shop alive {0}", this.hashCode());
        createProducts(); //add products to the productcatalogue
    }

    public ICustomerRegistry getCustomerRegistry() {
        return customerRegistry;
    }

    public IOrderBook getOrderBook() {
        return orderBook;
    }

    public IProductCatalogue getProductCatalogue() {
        return productCatalogue;
    }

    public QueryProcessor getQueryProcessor() {
        return queryProcessor;
    }
    
    private void createProducts(){
        
        if (productCatalogue.getCount() > 0) {
            return;
        }
        
        //pants
        productCatalogue.add(new Product("Superpants - blue", Double.parseDouble("250"), "pants", 12, "Awesome pair of blue superpants!", "./../resources/img/super_shop_clothes/super_pants/super_pants_blue.jpg"));
        productCatalogue.add(new Product("Superpants - brown", Double.parseDouble("235"), "pants", 9, "Awesome pair of brown superpants!", "./../resources/img/super_shop_clothes/super_pants/super_pants_brown.jpg"));
        productCatalogue.add(new Product("Superpants - gray", Double.parseDouble("299"), "pants", 11, "Awesome pair of gray superpants!", "./../resources/img/super_shop_clothes/super_pants/super_pants_gray.jpg"));
        productCatalogue.add(new Product("Superpants - jeans", Double.parseDouble("265"), "pants", 7, "Awesome pair of jeans superpants!", "./../resources/img/super_shop_clothes/super_pants/super_pants_jeans.jpg"));
        productCatalogue.add(new Product("Superpants - orange", Double.parseDouble("199"), "pants", 9, "Awesome pair of orange superpants!", "./../resources/img/super_shop_clothes/super_pants/super_pants_orange.jpg"));
        productCatalogue.add(new Product("Superpants - red", Double.parseDouble("249"), "pants", 12, "Awesome pair of red superpants!", "./../resources/img/super_shop_clothes/super_pants/super_pants_red.jpg"));
        productCatalogue.add(new Product("Superpants - white", Double.parseDouble("300"), "pants", 9, "Awesome pair of white superpants!", "./../resources/img/super_shop_clothes/super_pants/super_pants_white.jpg"));
        
        //jackets
        productCatalogue.add(new Product("Superjacket - baseball", Double.parseDouble("799"), "jackets", 7, "Awesome superjacket of the baseballmodell!", "./../resources/img/super_shop_clothes/super_jackets/super_jacket_baseball.jpg"));
        productCatalogue.add(new Product("Superjacket - downy", Double.parseDouble("699"), "jackets", 16, "Awesome superjacket of the downmodell!", "./../resources/img/super_shop_clothes/super_jackets/super_jacket_downy.jpg"));
        productCatalogue.add(new Product("Superjacket - parkas", Double.parseDouble("649"), "jackets", 9, "Awesome superjacket of the parkasmodell!", "./../resources/img/super_shop_clothes/super_jackets/super_jacket_parkas.jpg"));
        productCatalogue.add(new Product("Superjacket - woolen", Double.parseDouble("999"), "jackets", 7, "Awesome superjacket of the woolen modell!", "./../resources/img/super_shop_clothes/super_jackets/super_jacket_ull.jpg"));
        
        //shirts
        productCatalogue.add(new Product("Supershirt - black", Double.parseDouble("275"), "shirts", 7, "Awesome black supershirt!", "./../resources/img/super_shop_clothes/super_shirts/super_shirt_black.jpg"));
        productCatalogue.add(new Product("Supershirt - blue", Double.parseDouble("275"), "shirts", 14, "Awesome blue supershirt!", "./../resources/img/super_shop_clothes/super_shirts/super_shirt_blue.jpg"));
        productCatalogue.add(new Product("Supershirt - jeans", Double.parseDouble("275"), "shirts", 7, "Awesome jeans supershirt!", "./../resources/img/super_shop_clothes/super_shirts/super_shirt_jeans.jpg"));
        productCatalogue.add(new Product("Supershirt - red", Double.parseDouble("275"), "shirts", 5, "Awesome red supershirt!", "./../resources/img/super_shop_clothes/super_shirts/super_shirt_red.jpg"));
        productCatalogue.add(new Product("Supershirt - white", Double.parseDouble("275"), "shirts", 11, "Awesome white supershirt!", "./../resources/img/super_shop_clothes/super_shirts/super_shirt_white.jpg"));
        productCatalogue.add(new Product("Supershirt - yellow", Double.parseDouble("275"), "shirts", 9, "Awesome yellow supershirt!", "./../resources/img/super_shop_clothes/super_shirts/super_shirt_yellow.jpg"));
        
        //shoes
        productCatalogue.add(new Product("Supershoes - brown", Double.parseDouble("999"), "shoes", 7, "Awesome pair of brown supershoes!", "./../resources/img/super_shop_clothes/super_shoes/super_shoe_brown.jpg"));
        productCatalogue.add(new Product("Supershoes - green", Double.parseDouble("1299"), "shoes", 5, "Awesome pair of green supershoes!", "./../resources/img/super_shop_clothes/super_shoes/super_shoe_green.jpg"));
        productCatalogue.add(new Product("Supershoes - red", Double.parseDouble("1199"), "shoes", 11, "Awesome pair of red supershoes!", "./../resources/img/super_shop_clothes/super_shoes/super_shoe_red.jpg"));
        
        //shorts
        productCatalogue.add(new Product("Supershorts - blue", Double.parseDouble("225"), "shorts", 15, "Awesome pair of blue supershorts!", "./../resources/img/super_shop_clothes/super_shorts/super_shorts_blue.jpg"));
        productCatalogue.add(new Product("Supershorts - green", Double.parseDouble("250"), "shorts", 9, "Awesome pair of green supershorts!", "./../resources/img/super_shop_clothes/super_shorts/super_shorts_green.jpg"));
        productCatalogue.add(new Product("Supershorts - jeans", Double.parseDouble("299"), "shorts", 8, "Awesome pair of jeans supershorts!", "./../resources/img/super_shop_clothes/super_shorts/super_shorts_jeans.jpg"));
        productCatalogue.add(new Product("Supershorts - red", Double.parseDouble("199"), "shorts", 5, "Awesome pair of red supershorts!", "./../resources/img/super_shop_clothes/super_shorts/super_shorts_red.jpg"));
        
        //suits
        productCatalogue.add(new Product("Superblazer - black", Double.parseDouble("899"), "suits", 10, "The black superblazer!", "./../resources/img/super_shop_clothes/super_suits/super_blazer_black.jpg"));
        productCatalogue.add(new Product("Superblazer - gray", Double.parseDouble("899"), "suits", 7, "The gray superblazer!", "./../resources/img/super_shop_clothes/super_suits/super_blazer_gray.jpg"));
        productCatalogue.add(new Product("Supersuit - black", Double.parseDouble("1699"), "suits", 11, "The black supersuit!", "./../resources/img/super_shop_clothes/super_suits/super_suit_black.jpg"));
        productCatalogue.add(new Product("Supersuit - blue", Double.parseDouble("1999"), "suits", 9, "The blue supersuit!", "./../resources/img/super_shop_clothes/super_suits/super_suit_blue.jpg"));
        productCatalogue.add(new Product("Supersuit - gray", Double.parseDouble("1799"), "suits", 9, "The gray supersuit!", "./../resources/img/super_shop_clothes/super_suits/super_suit_gray.jpg"));
        
    }   
    
}
