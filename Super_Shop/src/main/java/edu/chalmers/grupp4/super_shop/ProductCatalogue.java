
package edu.chalmers.grupp4.super_shop;

import java.util.ArrayList;
import java.util.List;

/**
 * All products
 * @author hajo
 */
public final class ProductCatalogue extends AbstractDAO<Product, Long> implements IProductCatalogue {

    public static IProductCatalogue newInstance(String puName){
        return new ProductCatalogue(puName);
    }
    
    public ProductCatalogue(String puName) {
        super(Product.class, puName);
    }
    
    @Override
    public List<Product> getByName(String name) {
        List<Product> found = new ArrayList<>();
        for (Product p : getAll()) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
}
