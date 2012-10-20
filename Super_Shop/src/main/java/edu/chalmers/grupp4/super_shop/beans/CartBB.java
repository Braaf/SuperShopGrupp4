/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Customer;
import edu.chalmers.grupp4.super_shop.core.JPAShop;
import edu.chalmers.grupp4.super_shop.core.OrderBook;
import edu.chalmers.grupp4.super_shop.core.Product;
import edu.chalmers.grupp4.super_shop.core.PurchaseOrder;
import java.util.List;
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
    
    public String addProd(Product p){
        cbean.addProd(p);
        return "products?faces-redirect=true";
    }
    
}
