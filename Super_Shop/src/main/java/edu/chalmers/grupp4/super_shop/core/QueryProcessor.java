/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.grupp4.super_shop.core;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author andrn
 */
public class QueryProcessor {
    
    private static EntityManagerFactory emf;

    public static QueryProcessor newInstance(String pu) {
        return new QueryProcessor(pu);
    }
    
    private QueryProcessor(String pu) {
        emf = Persistence.createEntityManagerFactory(pu);
    }
    
    public List<Product> searchProducts(String term) {
        
        EntityManager em = emf.createEntityManager();
        try {

            Query query = em.createQuery("select p from Product p where p." + term);
            return query.getResultList();
        
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
        
    }
    
}
