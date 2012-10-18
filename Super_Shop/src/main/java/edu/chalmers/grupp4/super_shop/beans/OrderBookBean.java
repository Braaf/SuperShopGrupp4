package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Customer;
import edu.chalmers.grupp4.super_shop.core.JPAShop;
import edu.chalmers.grupp4.super_shop.core.OrderBook;
import edu.chalmers.grupp4.super_shop.core.PurchaseOrder;
import java.util.List;

/**
 *
 * @author Osten
 */
public class OrderBookBean {
    
    private transient OrderBook  orderBook = (OrderBook) JPAShop.INSTANCE.getOrderBook();
    
    public OrderBookBean(){        
    }
    
    public List<PurchaseOrder> getByCustomer(Customer c){
        return orderBook.getByCustomer(c);
    }
    public List<PurchaseOrder> getAll(){
        return orderBook.getAll("Customer");
    }
    
    public void add(PurchaseOrder po){
        orderBook.add(po);
    }
    
    public void remove(Long id){
        orderBook.remove(id);
    }
    
    public void update(PurchaseOrder po){
        orderBook.update(po);
    }
}
