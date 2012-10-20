/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Cart;
import edu.chalmers.grupp4.super_shop.core.Product;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Braaf
 */
@SessionScoped
public class CartBean implements Serializable{
    
    private final transient Cart cart = new Cart();
    
    public CartBean(){
    }
    
    public void addProd(Product p){
        if(p.getStock() > 0){
            cart.add(p);
            System.out.println(p.getStock() + "Stock");
            System.out.println(cart.getProductFreq().get(p) + " frequency");
        }
    }
    
    public void removeProd(){
        
    }
    
    public int getFreq(){
        return 1;
    }
}
