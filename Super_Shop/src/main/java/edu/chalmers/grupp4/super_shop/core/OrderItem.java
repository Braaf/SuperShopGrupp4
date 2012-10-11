package edu.chalmers.grupp4.super_shop.core;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * A single row in the order
 *
 * @author hajo
 */
@Entity
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue
    Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;
    private int quantity;

    public OrderItem() {
    }

    OrderItem(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "product=" + product + ", quantity=" + quantity + '}';
    }
}
