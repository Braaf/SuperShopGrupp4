package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ossian
 */
@Named("products")
@RequestScoped
public class ProductsBB implements Serializable {
    
    private ProductCatalogueBean pcBean;
    
    public ProductsBB(){
        
    }
    
    @Inject
    public ProductsBB(ProductCatalogueBean pcBean){
        this.pcBean = pcBean;
    }
    

    public List<Product> getAll(){
        return pcBean.getAll();
    }
    
    public void setStock(String name, int stock){
        pcBean.setStock(name, stock);
    }
    
    public void decrementStock(Product p){
        if(p.getStock() > 0){
            p.setStock(p.getStock() - 1);
            pcBean.update(p);
        }
    }
    
    //*************************************************//
    // Methods for product listing by category!        //
    //*************************************************//
    public List<Product> getSale(){
        return pcBean.getByCategory("supersale");
    }
    
    public List<Product> getJackets(){
        return pcBean.getByCategory("jackets");
    }
    
    public List<Product> getShirts(){
        return pcBean.getByCategory("shirts");
    }
    
    public List<Product> getPants(){
        return pcBean.getByCategory("pants");
    }
    
    public List<Product> getShoes(){
        return pcBean.getByCategory("shoes");
    }
    
    public List<Product> getShorts(){
        return pcBean.getByCategory("shorts");
    }
    
    public List<Product> getSuits(){
        return pcBean.getByCategory("suits");
    }

}