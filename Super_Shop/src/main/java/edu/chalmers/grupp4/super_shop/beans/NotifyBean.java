/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.beans;

import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Andreas
 */
@Named
@ConversationScoped
public class NotifyBean implements Serializable {

    private String title;
    private String description;
    
    public NotifyBean() {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String msg = params.get("msg");
        switch (msg) {
            case "passwordChanged":
                title = "Password is now changed!";
                description = "Your password has now been changed.";
                break;
            case "passwordNotChanged":
                title = "Password is not changed!";
                description = "Your password has not been changed because new password and confirmation passwords does not match.";
                break;
            case "pwNotMatching":
                title = "Password not matching!";
                description = "Password and Confirm password must match";
                break;
            case "cartIsEmpty":
                title = "No products in the cart!";
                description = "You have no products in your cart yet!";
                break;
            case "usernameBusy":
                title = "Username already in use!";
                description ="That username is already taken, please register with another.";
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    
    
    
}
