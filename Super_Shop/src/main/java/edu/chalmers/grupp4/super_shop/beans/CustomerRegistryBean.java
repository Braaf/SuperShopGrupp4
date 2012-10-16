package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Customer;
import edu.chalmers.grupp4.super_shop.core.CustomerRegistry;
import edu.chalmers.grupp4.super_shop.core.JPAShop;
import java.util.List;

/**
 *
 * @author Ossian
 */
public class CustomerRegistryBean {
    
    private final transient CustomerRegistry customerRegistry = (CustomerRegistry) JPAShop.INSTANCE.getCustomerRegistry();
    
    public void CustomerRegistryBean(){
        
    }
    public Customer getById(Long id){
        return customerRegistry.getById(id);
    }
    
    public List<Customer> getByName(String name) {
        return customerRegistry.getByName(name);
    }
        
    public List<Customer> getAll(){
        return customerRegistry.getAll();
    }
    
    public void add(Customer c){
        customerRegistry.add(c);
    }
    
    public void remove(Long id){
        customerRegistry.remove(id);
    }
    
    public void update(Customer c){
        customerRegistry.update(c);
    }
}
