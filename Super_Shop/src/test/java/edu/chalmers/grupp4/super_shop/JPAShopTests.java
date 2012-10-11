/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop;

import edu.chalmers.grupp4.super_shop.core.JPAShop;
import edu.chalmers.grupp4.super_shop.core.Product;
import edu.chalmers.grupp4.super_shop.core.ProductCatalogue;
import edu.chalmers.grupp4.super_shop.core.QueryProcessor;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author andrn
 */
public class JPAShopTests {
    
    private static ProductCatalogue catalogue;
    private static QueryProcessor queryProcessor;

    @BeforeClass
    public static void setUpClass() throws Exception {
        catalogue = (ProductCatalogue) JPAShop.INSTANCE.getProductCatalogue();
        queryProcessor = JPAShop.INSTANCE.getQueryProcessor();
    }
    
    @Before
    public void setup() {
        catalogue.clear();
        catalogue.add(new Product("banana", 13.11));
        catalogue.add(new Product("sven", 10.11));
    }

    @Test
    public void testAdd() {
        Assert.assertTrue(catalogue.getCount() == 2);
    }
    
    @Test
    public void testRemove() {
        catalogue.remove(catalogue.getByName("banana").get(0).getId());
        Assert.assertTrue(catalogue.getCount() == 1);
    }
    
    @Test
    public void testUpdate() {
        long id = catalogue.getByName("banana").get(0).getId();
        Product newProd = new Product(id, "bolof", 123);
        catalogue.update(newProd);
        Assert.assertFalse(catalogue.find(id).getName().equals("banana"));
    }
    
    @Test
    public void testGetAll() {
        Assert.assertTrue(catalogue.getAll().size() == 2);
    }
    
    @Test
    public void testSearch() {
        
        List<Product> list = queryProcessor.searchProducts("price < 12");
        Assert.assertTrue(list.size() == 1);
        Assert.assertTrue(list.get(0).getName().equals("sven"));
        
        list = queryProcessor.searchProducts("price < 15");
        Assert.assertTrue(list.size() == 2);
        
        list = queryProcessor.searchProducts("name = 'banana'");
        Assert.assertTrue(list.size() == 1);
        Assert.assertTrue(list.get(0).getName().equals("banana"));
        
        Product p = new Product("olof", 16);
        catalogue.add(p);
        list = queryProcessor.searchProducts("id = " + p.getId());
        Assert.assertTrue(list.size() == 1);
        Assert.assertTrue(list.get(0).getName().equals("olof"));
        
    }
    
}


// ·