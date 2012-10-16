package edu.chalmers.grupp4.super_shop.beans;

import edu.chalmers.grupp4.super_shop.core.Product;
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
public class ProductsBB {
    
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
}