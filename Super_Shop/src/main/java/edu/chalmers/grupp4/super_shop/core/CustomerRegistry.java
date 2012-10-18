
package edu.chalmers.grupp4.super_shop.core;

import java.util.ArrayList;
import java.util.List;

/**
 * All customers
 * @author hajo
 */
public final class CustomerRegistry extends AbstractDAO<Customer, Long> implements ICustomerRegistry {

    public static ICustomerRegistry newInstance(String puName) {
        return new CustomerRegistry(puName);
    }
    
    public CustomerRegistry(String puName) {
       super(Customer.class, puName);
    }

    @Override
    public List<Customer> getByName(String name) {
        List<Customer> found = new ArrayList<>();
        for (Customer c : getAll("Customer")) {
            if (c.getFname().equals(name) || c.getLname().equals(name)) {
                found.add(c);
            }
        }
        return found;
    }
    
    public List<Customer> getByUsername(String name) {
        List<Customer> found = new ArrayList<>();
        for (Customer c : getAll("Customer")) {
            if (c.getUsername().equals(name)) {
                found.add(c);
            }
        }
        return found;
    }
    
    public Customer getById(Long id){
        for(Customer c : getAll("Customer")){
            if(c.getId().equals(id)){
                return c;
            }
        } return null;
    }
}
