/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.rest;

import edu.chalmers.grupp4.super_shop.core.Product;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Braaf
 */
@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ProductProxy {
    
    private Product p;
    
    public ProductProxy(){};
    
    public ProductProxy(Product p){
        this.p = p;
    }
    
    //--------------------------------------------//
    // GETTERS                                    //
    //--------------------------------------------//
    @XmlAttribute(name="id")
    public Long getId(){
        return p.getId();
    }
    @XmlElement(name="name")
    public String getName(){
        return p.getName();
    }
    @XmlElement(name="price")
    public double getPrice(){
        return p.getPrice();
    }
    @XmlElement(name="description")
    public String getDescription(){
        return p.getDescription();
    }
    @XmlElement(name="stock")
    public int getStock(){
        return p.getStock();
    }
    @XmlElement(name="category")
    public String getCategory(){
        return p.getCategory();
    }
    @XmlElement(name="picture")
    public String getPicture(){
        return p.getPicture();
    }
}
