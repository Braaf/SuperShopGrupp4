/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Cart;
import edu.chalmers.grupp4.super_shop.core.JPAShop;
import edu.chalmers.grupp4.super_shop.core.Product;
import edu.chalmers.grupp4.super_shop.core.ProductCatalogue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.PrePassivate;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Braaf
 */
@Named
@SessionScoped
public class CartBean implements Serializable{
    
    private final transient Cart cart = new Cart();
    private final transient ProductCatalogue pc = (ProductCatalogue) JPAShop.INSTANCE.getProductCatalogue();
    
    
    private boolean notEmpty = false;
    
    public CartBean(){
    }
    
    //add a product to the cart and update the productcatalogue with the new quantity
    public void addProd(Product p){
        if(p.getStock() > 0){
            cart.add(p);
            p.setStock(p.getStock() - 1);
            pc.update(p);
            notEmpty = true;
        }
    }
    
    //remove the product from the cart and check if ther is any products left
    public String removeProd(Product product){
        cart.remove(product);
        List<Product> products = getProducts();
        if(products.isEmpty()){
            notEmpty = false;
        }
        return "cart?faces-redirect=true";
    }
    
    public int getFreq(){
        return 1;
    }
    
    //get the number of how many products of each kind that has been put in the cart
    public Map<Product, Integer> getProductFreq(){
        return cart.getProductFreq();
    }
    
    public List<Product> getProducts() {
        Product[] arr = cart.getProductFreq().keySet().toArray(new Product[0]);
        return new ArrayList(Arrays.asList(arr));
    }
    //get the number of how many of a specific product that has been put in the cart
    public int getProductFreq(Product p) {
        return cart.getProductFreq().get(p);
    }
    
    //get the total price of all the products in the cart together
    public int getTotalPrice(){
        int totalPrice = 0;
        List<Product> products = getProducts();
        for(Product p : products){
            int numberOfProducts = getProductFreq(p);
            totalPrice += p.getPrice()*numberOfProducts;
        }
        return totalPrice;
    }
    
    //remove all the products from the cart
    public void resetCart(){
        List<Product> products = getProducts();
        for(Product p : products){
            cart.remove(p);
        }
        notEmpty = false;       
        
    }
    //Called on sessionexpire?
    @PrePassivate
    public void emptyCart(){
        HashMap<Product, Integer> cartMap = (HashMap<Product, Integer>) getProductFreq();
        Set<Product> pSet = cartMap.keySet();
        //Re add items in cart to stock
        for(Product p : pSet){
            //Set stock to both our cart and current stock
            p.setStock(p.getStock() + cartMap.get(p));
            //updatdatabase
            pc.update(p);
        }
    }
    
    public boolean getNotEmpty(){
        return notEmpty;
    }
    
    //return a notification page that tells the user that the cart is empty
    public String cartIsEmpty(){
        return "notify?faces-redirect=true&msg=cartIsEmpty";
    }
    
}
