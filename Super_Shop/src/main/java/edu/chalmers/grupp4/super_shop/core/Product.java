
package edu.chalmers.grupp4.super_shop.core;

import java.io.Serializable;
import java.util.Objects;
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
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private String description;
    private int stock;
    private String category;
    private String picture;

    public Product() {
    }

    public Product(Long id, String name, double price, String category, int stock, String description, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.description = description;
        this.picture = picture;
    }
    
    public Product(String name, double price, String category, int stock, String description, String picture) {
        this.id = new Long(new Random().nextInt(100));
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.description = description;
        this.picture = picture;
    }
    
    public String getName() {
        return name;
    }
    
    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
    
    public String getCategory(){
        return category;
    }
    
    public int getStock(){
        return stock;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getPicture(){
        return picture;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return true;
    }
    

   
}
