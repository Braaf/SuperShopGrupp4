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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ossian
 */
@Named("checkoutBean")
@RequestScoped
public class CheckoutBB {
    
    private CustomerRegistryBean crBean;  
    
    private String fname;
    private String lname;
    private int pnumb;
    private String street;
    private int streetnumber;
    private int postalcode;
    private String city;
    
    
    @NotNull
    @Size(min = 1, max = 10, message = "Name: Must use 1-10 chars\n")
    private String cfname;
    @NotNull
    @Size(min = 1, max = 20, message = "Last name: Must use 2-20 chars")
    private String clname;
    @NotNull
    @Min(value = 1)
    private long cardnumber;
    @NotNull
    @Min(value = 1)
    @Max(value = 1225)
    private int expiration;
    @NotNull
    @Min(value = 1)
    @Max(value = 999)
    private int cvc;
    
    public CheckoutBB(){
        
    }
    
    @Inject
    public CheckoutBB(CustomerRegistryBean crBean){
        this.crBean = crBean;
        
    }
    
    //Just redirect the user to a page that says that the order is placed, this is the place to use the customer payment details
    public String placeOrder(){
        return "orderplaced?faces-redirect=True";
    }
    
    //if the user is logged in, intiate the customers values
    public String setCustomerValues(String username){
        List<Customer> customers = crBean.getByUsername(username); 
        if (customers.isEmpty()) {
            return "login?faces-redirect=true";
        }
        Customer currentCustomer = customers.get(0);
        Address address = currentCustomer.getAddress();
        fname = currentCustomer.getFname();
        lname = currentCustomer.getLname();
        pnumb = currentCustomer.getPnumb();
        street = address.getStreet();
        streetnumber = address.getNbr();
        postalcode = address.getPostalcode();
        city = address.getTown();
        
        return "checkout?faces-redirect?true";
    }
    /////////////
    // Setters //
    /////////////
    
    public void setCfname(String cfname){
        this.cfname = cfname;
    }
    
    public void setClname(String clname){
        this.clname = clname;
    }
    
    public void setCardnumber(long cardnumber){
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
    
    public String getCfname(){
        return cfname;
    }
    
    public String getClname(){
        return clname;
    }
    
    public long getCardnumber(){
        return cardnumber;
    }
    
    public int getExpiration(){
        return expiration;
    }
    
    public int getCvc(){
        return cvc;
    }
}
