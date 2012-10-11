package edu.chalmers.grupp4.super_shop.core;

import java.io.Serializable;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author hajo
 */
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private transient Cart cart = new Cart();
    private Address address;
    private String fname;
    private String lname;
    private String email;

    public Customer() {
    }

    public Customer(Long id, Address address, String fname,
            String lname, String email) {
        this.id = id;
        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public Customer(Address address, String fname,
            String lname, String email) {
        // For now. Later database will generate id
        this.id = new Long(new Random().nextInt(100));
        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public void addProductToCart(Product product) {
        cart.add(product);
    }

    public void removeProductFromCart(Product product) {
        cart.remove(product);
    }

    public PurchaseOrder finishShopping() {
        PurchaseOrder po = new PurchaseOrder(this);
        cart = null;
        return po;
    }

    public void cancelShopping() {
        cart = new Cart();
    }

    public Address getAddress() {
        return address;
    }

    public Cart getCart() {
        return cart;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    
    public Long getId() {
        return id;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", address=" + address + ", fname=" + fname + ", lname=" + lname + ", email=" + email + '}';
    }    
}
