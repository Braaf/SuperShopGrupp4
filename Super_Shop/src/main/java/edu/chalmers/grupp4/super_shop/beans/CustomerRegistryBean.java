package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Customer;
import edu.chalmers.grupp4.super_shop.core.CustomerRegistry;
import edu.chalmers.grupp4.super_shop.core.JPAShop;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Ossian
 */
@SessionScoped
public class CustomerRegistryBean implements Serializable{
    
    private final CustomerRegistry customerRegistry = (CustomerRegistry) JPAShop.INSTANCE.getCustomerRegistry();
    
    public void CustomerRegistryBean(){        
    }
    
    public Customer getById(Long id){
        return customerRegistry.getById(id);
    }
    
    public List<Customer> getByName(String name) {
        return customerRegistry.getByName(name);
    }
    
    public List<Customer> getByUsername(String name) {
        return customerRegistry.getByUsername(name);
    }
        
    public List<Customer> getAll(){
        return customerRegistry.getAll("Customer");
    }
    
    public void add(Customer c){
        customerRegistry.add(c);
    }
    
    public void remove(Long id){
        customerRegistry.remove(id);
    }
    
    public void removeAll() {
        customerRegistry.clear("Customer");
    }
    
    public void update(Customer c){
        customerRegistry.update(c);
    }
}
