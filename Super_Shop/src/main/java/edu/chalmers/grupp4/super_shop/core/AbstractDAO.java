package edu.chalmers.grupp4.super_shop.core;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * A container for entities Base class for OrderBook, ProductCatalogue,
 * CustomerRegistry
 *
 * K is type of id (primary key)
 *
 * @author andrn
 */
public abstract class AbstractDAO<T, K> implements IDAO<T, K> {

    private static EntityManagerFactory emf;
    private final Class<T> clazz;

    public AbstractDAO(Class<T> clazz, String puName) {
        this.clazz = clazz;
        AbstractDAO.emf = Persistence.createEntityManagerFactory(puName);
    }

    @Override
    public void add(T t) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {

            tx.begin();
            em.persist(t);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

    }

    @Override
    public void remove(K id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {

            T t = em.getReference(clazz, id);
            tx.begin();
            em.remove(t);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

    }

    @Override
    public void update(T t) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {

            tx.begin();
            em.merge(t);
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

    }

    @Override
    public T find(K id) {

        EntityManager em = emf.createEntityManager();
        try {
            return em.find(clazz, id);
        } finally {
            em.close();
        }

    }

    @Override
    public List<T> getAll(String type) {

        EntityManager em = emf.createEntityManager();
        try {

            TypedQuery<T> query = em.createQuery("select p from " + type + " p", clazz);
            return query.getResultList();

        } catch (Exception e) {
            return null;
        } finally {
            em.close();
            em = null;
        }

    }

    @Override
    public List<T> getRange(int firstResult, int maxResults) {

        EntityManager em = emf.createEntityManager();
        try {

            TypedQuery<T> query = em.createQuery("select p from Product p", clazz);
            return query.getResultList().subList(firstResult, firstResult + maxResults);

        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public int getCount(String type) {
        EntityManager em = emf.createEntityManager();
        try {

            TypedQuery<T> query = em.createQuery("select p from " + type + " p", clazz);
            return query.getResultList().size();

        } catch (Exception e) {
            return -1;
        } finally {
            em.close();
        }
    }
    
    @Override
    public void clear(String type) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {

            tx.begin();
            Query query = em.createQuery("delete from " + type + " p");
            query.executeUpdate();
            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
        
    }
    
    /*public List<T> search(String term) {
        
        EntityManager em = emf.createEntityManager();
        try {

            Query query = em.createQuery("select p from Product p where p." + term);
            return query.getResultList();
        
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
        
    }*/
}
