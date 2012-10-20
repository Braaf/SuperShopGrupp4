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
        
        if (msg.equals("passwordChanged")) {
            title = "Password is now changed!";
            description = "Your password has now been changed.";
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    
    
    
}
