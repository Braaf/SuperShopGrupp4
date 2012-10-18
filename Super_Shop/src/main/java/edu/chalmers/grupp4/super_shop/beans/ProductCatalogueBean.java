package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.JPAShop;
import edu.chalmers.grupp4.super_shop.core.Product;
import edu.chalmers.grupp4.super_shop.core.ProductCatalogue;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Ossian
 */
@SessionScoped
public class ProductCatalogueBean implements Serializable{
    
    private final transient ProductCatalogue pc = (ProductCatalogue) JPAShop.INSTANCE.getProductCatalogue();

    
    public void ProductCatalougeBean(){
    }
    
    public List<Product> getAll(){
        return pc.getAll();
    }
    
    public List<Product> getByName(String name){
        return pc.getByName(name);
    }
    
    public void add(Product p){
        pc.add(p);
    } 
    
    public void remove(Long id){
        pc.remove(id);
    }
    
    public void update(Product p){
        pc.update(p);
    }
    
    public void setStock(String name, int stock){
        pc.getByName(name).get(0).setStock(stock); //change the stock of the product
    }
}