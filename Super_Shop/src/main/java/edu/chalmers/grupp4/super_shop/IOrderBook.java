
package edu.chalmers.grupp4.super_shop;

import java.util.List;

/**
 * Interface to order book
 * @author hajo
 */
public interface IOrderBook extends IDAO<PurchaseOrder, Long> {

    List<PurchaseOrder> getByCustomer(Customer c);
    
}
