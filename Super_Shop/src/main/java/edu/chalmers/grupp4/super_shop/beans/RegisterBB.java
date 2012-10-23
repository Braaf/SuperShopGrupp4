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
@Named("registerBB")
@RequestScoped
public class RegisterBB {
    
    private CustomerRegistryBean crBean;
    
    private long id;
    @NotNull
    @Size(min = 1, max = 10, message = "Name: Must use 1-10 chars\n")
    private String fname;
    @NotNull
    @Size(min = 2, max = 20, message = "Last name: Must use 2-20 chars")
    private String lname;
    @NotNull
    @Size(min = 6, max = 35, message = "Email: must be between 6 and 35 chars long")
    private String email;    
    @NotNull
    @Size(min = 1, max = 20, message = "Street: must be between 1 and 20 chars long")
    private String street;
    @NotNull
    @Min(value = 1, message = "Street number: Too small, should be 5 signs")
    @Max(value = 999, message = "Street number: Too big, max 999")
    private int streetNumber;
    @NotNull
    private int postalCode;
    @NotNull
    @Size(min = 1, max = 20, message = "City: must be between 1 and 20 chars long")
    private String town;    
    @NotNull
    @Size(min = 5, max= 15, message = "Password must be between 5 and 15 chars long")
    private String password;
    @NotNull
    @Size(min = 5, max= 15, message = "Password must be between 5 and 15 chars long")
    private String confPassword;
    @NotNull
    private int pnumb;
    @NotNull
    @Size(min = 1, max = 10, message = "Username: must be between 1 and 10 chars long")
    private String username;
    
    //Empty parameter constructor
    public RegisterBB(){
    }
    
    @Inject
    public RegisterBB(CustomerRegistryBean crBean){
        this.crBean = crBean;
    }
    
    public String addNewCustomer(){
        List<Customer> customers;
        customers =crBean.getByName(username);
        if(!customers.isEmpty()){ //checks if the username is already taken, if so redirect to a notification page
            return "notify?faces-redirect=true&msg=usernameBusy";
        }
        if(password.equals(confPassword)){ //checks that both passwords that has been inserted matches and if so add the customer to the registry
        crBean.add(new Customer(new Address(street, streetNumber, postalCode, town), fname, lname, pnumb, email, username, password));
        return "login?faces-redirect=true"; 
        }else{
            return "notify?faces-redirect=true&msg=pwNotMatching"; //notify the user if passwords doesnt match
        }
    }
    //Getters and setters
    public Long getId(){
        return id;
    }
    
    public String getFname(){
        return fname;
    }
    
    public String getLname(){
        return lname;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public int getPnumb(){
        return pnumb;
    }
    
    public String getStreet(){
        return street;
    }
    
    public String getTown(){
        return town;
    }
    
    public int getStreetNumber(){
        return streetNumber;
    }
    
    public int getPostalCode(){
        return postalCode;
    }
    
    public String getConfPassword(){
        return confPassword;
    }
   
    
    public void setFname(String fname){
        this.fname = fname;
    }
    
    public void setLname(String lname){
        this.lname = lname;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setPnumb(int pnumb){
        this.pnumb = pnumb;
    }
    
    public void setStreet(String street){
        this.street = street;
    }
    
    public void setTown(String town){
        this.town = town;
    }
    
    public void setStreetNumber(int streetNumber){
        this.streetNumber = streetNumber;
    }
    
    public void setPostalCode(int postalCode){
        this.postalCode = postalCode;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }
    
}
