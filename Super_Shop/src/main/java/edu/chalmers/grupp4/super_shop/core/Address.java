package edu.chalmers.grupp4.super_shop.core;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author hajo
 */
@Embeddable
public class Address implements Serializable {

    private String street;
    private int nbr;
    private int postalcode;
    private String town;

    public Address() {
    }

    public Address(String street, int nbr, int postalCode, String town) {
        this.street = street;
        this.nbr = nbr;
        this.postalcode = postalCode;
        this.town = town;
    }
    
    public int  getPostalcode(){
        return postalcode;
    }
    
    public int getNbr() {
        return nbr;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", nbr=" + nbr + ", postalcode=" + postalcode + ", town=" + town + '}';
    }
}
