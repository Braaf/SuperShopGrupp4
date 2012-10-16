package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Customer;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Ossian
 */
public class CustomerBB {
    
    private CustomerRegistryBean customerRB;
    
    public CustomerBB(){
        
    }
    
    @Inject 
    public CustomerBB(CustomerRegistryBean customerRB){        
    }
    
    public Customer getById(Long id){
        return customerRB.getById(id);
    }
    public List<Customer> getAll(){
        return customerRB.getAll();
    }
}
