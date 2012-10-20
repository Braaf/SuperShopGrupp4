/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Address;
import edu.chalmers.grupp4.super_shop.core.Customer;
import java.util.List;
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
    private String username = "default";
  
    
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
    
    private void setCustomerValues(String username){
        List<Customer> customers = crBean.getByUsername(username);        
        Customer currentCustomer = customers.get(0);
        Address address = currentCustomer.getAddress();
        fname = currentCustomer.getFname();
        lname = currentCustomer.getLname();
        pnumb = currentCustomer.getPnumb();
        street = address.getStreet();
        streetnumber = address.getNbr();
        postalcode = address.getPostalcode();
        city = address.getTown();
    }
    /////////////
    // Setters //
    /////////////
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setCfname(String cfname){
        this.cfname = cfname;
    }
    
    public void setcClname(String clname){
        this.clname = clname;
    }
    
    public void setCardnumber(int cardnumber){
        this.cardnumber = cardnumber;
    }
    
    public void setExpiration(int expiration){
        this.expiration = expiration;
    }
    
    public void setCvc(int cvc){
        this.cvc = cvc;
    }
    
    /////////////
    // Getters //
    /////////////
    
    public String getFname(){
        return fname;
    }
    
    public String getLname(){
        return lname;
    }
    
    public int getPnumb(){
        return pnumb;
    }
    
    public String getStreet(){
        return street;
    }
    
    public int getStreetnumber(){
        return streetnumber;
    }
    
    public int getPostalcode(){
        return postalcode;
    }
    
    public String getCity(){
        return city;
    }
    
    
}
