/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
    public void login(ActionEvent event) {
        bean.getByName(username);
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
