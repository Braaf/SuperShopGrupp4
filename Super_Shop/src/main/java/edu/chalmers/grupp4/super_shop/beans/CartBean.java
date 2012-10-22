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
import javax.annotation.PreDestroy;
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
    
    public CartBean(){
    }
    
    public void addProd(Product p){
        if(p.getStock() > 0){
            cart.add(p);
            p.setStock(p.getStock() - 1);
            pc.update(p);
        }
    }
    
    public void removeProd(){
        
    }
    
    public int getFreq(){
        return 1;
    }
    public Map<Product, Integer> getProductFreq(){
        return cart.getProductFreq();
    }
    
    public List<Product> getProducts() {
        Product[] arr = cart.getProductFreq().keySet().toArray(new Product[0]);
        return new ArrayList(Arrays.asList(arr));
    }
    
    public int getProductFreq(Product p) {
        return cart.getProductFreq().get(p);
    }
    
    //Called on sessionexpire?
    @PreDestroy
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
    
}
