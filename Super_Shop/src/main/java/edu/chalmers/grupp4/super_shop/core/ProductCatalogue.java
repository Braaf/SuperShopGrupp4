
package edu.chalmers.grupp4.super_shop.core;

import java.util.ArrayList;
import java.util.Iterator;
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
        for (Product p : getAll("Product")) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
    
    public List<Product> getByCategory(String cat) {
        List<Product> found = new ArrayList<>();
        Iterator<Product> it = getAll("Product").iterator();
        while(it.hasNext()) {
            Product p = it.next();
            if (p.getCategory().equals(cat)) {
                found.add(p);
            }
        }
        return found;
    }
}
