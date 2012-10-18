/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Address;
import edu.chalmers.grupp4.super_shop.core.Customer;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andreas
 */
@Named
@ConversationScoped
public class LoginBean implements Serializable {

    private CustomerRegistryBean bean;
    private Long id;
    private String username;
    private String password;
    private boolean loggedIn;

    public LoginBean() {
    }
    
    @Inject
    public LoginBean(CustomerRegistryBean bean) {
        this.bean = bean;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void login(ActionEvent event) {
        bean.add(new Customer(1L, new Address("Gibraltargatan 78", 41279, "Göteborg"),
                "Andreas", "Nilsson", "a@a.com", "ante", "sven"));
        List<Customer> list = bean.getByUsername(username);
        if (list.isEmpty()) {
            // TODO no user with that username
        } else if (list.size() > 1) {
            // TODO multiple users with equal usernames is not allowed
        } else if (list.get(0).getPassword().equals(password)) {
            loggedIn = true; // TODO user is authenticated
        } else {
            // TODO username and password does not match
        }
        
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.username);
        hash = 31 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoginBean other = (LoginBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
}
