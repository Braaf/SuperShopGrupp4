/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Cart;
import edu.chalmers.grupp4.super_shop.core.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Braaf
 */
@Named
@SessionScoped
public class CartBean implements Serializable{
    
    private int test;

    public int getTest() {
        return test;
    }
    
    
    private final transient Cart cart = new Cart();
    
    public CartBean(){
    }
    
    public void addProd(Product p){
        if(p.getStock() > 0){
            cart.add(p);
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
}
