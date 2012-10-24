/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Address;
import edu.chalmers.grupp4.super_shop.core.Customer;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andreas
 */
@Named
@RequestScoped
public class AccountBean implements Serializable {
    
    private CustomerRegistryBean bean;
    
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
    private String newPassword;
    
    @NotNull
    @Size(min = 5, max= 15, message = "Password must be between 5 and 15 chars long")
    private String confPassword;
    
    @NotNull
    private int pnumb;
    
    @NotNull
    @Size(min = 1, max = 10, message = "Username: must be between 1 and 10 chars long")
    private String username;
    
    private Customer customer;

    public AccountBean() {
    }
    
    @Inject
    public AccountBean(CustomerRegistryBean bean) {
        this.bean = bean;
    }
    
    public String init(String username) {
        List<Customer> list = bean.getByUsername(username);
        if (list.isEmpty()) {
            return "products?faces-redirect=true";
        }
        
        customer = list.get(0);
        fname = customer.getFname();
        lname = customer.getLname();
        email = customer.getEmail();
        id = customer.getId();
        pnumb = customer.getPnumb();
        this.username = customer.getUsername();
        //password = customer.getPassword();
        street = customer.getAddress().getStreet();
        streetNumber = customer.getAddress().getNbr();
        postalCode = customer.getAddress().getPostalcode();
        town = customer.getAddress().getTown();
        
        return "account?faces-redirect=true";
    }
    
    public String changePassword() {
        if (newPassword.equals(confPassword)) {
            bean.update(new Customer(customer.getId(), new Address(street, streetNumber, postalCode, town), fname, lname, pnumb, email, username, newPassword));
            password = "";
            newPassword = "";
            confPassword = "";
            return "notify?faces-redirect=true&msg=passwordChanged";
        } else {
            return "notify?faces-redirect=true&msg=passwordNotChanged";
        }
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public long getId() {
        return id;
    }

    public String getLname() {
        return lname;
    }

    public String getPassword() {
        return password;
    }

    public String getNewPassword() {
        return newPassword;
    }
    
    

    public String getConfPassword() {
        return confPassword;
    }

    public int getPnumb() {
        return pnumb;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getTown() {
        return town;
    }

    public String getUsername() {
        return username;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    
    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }
    
    
    
    
    
    
    
}
