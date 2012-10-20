/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Customer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ossian
 */
@Named("checkoutBean")
@RequestScoped
public class CheckoutBB {
    
    private CustomerRegistryBean crBean;
    private Customer currentCustomer;
    
    private String fname;
    private String lname;
    private int pnumb;
    private String street;
    private int streetnumber;
    private int postalcode;
    private String city;
    
    private String cfname;
    private String clname;
    private int cardnumber;
    private int expiration;
    private int cvc;
    
    public CheckoutBB(){
        
    }
    
    @Inject
    public CheckoutBB(CustomerRegistryBean crBean){
        this.crBean = crBean;
    }
    
    public String placeOrder(){
        return "orderplaced?faces-redirect=True";
    }
}
