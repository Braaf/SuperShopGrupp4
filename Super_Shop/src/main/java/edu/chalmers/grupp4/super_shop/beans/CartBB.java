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

/**
 *
 * @author Ossian
 */
public class CartBB {
    
    private final transient OrderBook order = (OrderBook) JPAShop.INSTANCE.getOrderBook();
    
    public void CartBB(){
    }
    
    public List<PurchaseOrder> getAll(Customer c){
        return order.getAll();
    }
    
    public void remove(Long id){
        order.remove(id);
    }
    
    public void update(Product p){
    //    order.update(p);
    }
}
