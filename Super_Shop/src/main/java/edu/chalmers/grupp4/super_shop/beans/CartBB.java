/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Product;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ossian
 */
@Named
@RequestScoped
public class CartBB {
    
    private CartBean cbean;
    
    public CartBB(){
    }
    
    @Inject
    public CartBB(CartBean cbean){
        this.cbean = cbean;
    }
    
    //adds a product to the cart and refreshes the products page
    public String addProd(Product p){
        cbean.addProd(p);
        return "products?faces-redirect=true";
    }
    
}
