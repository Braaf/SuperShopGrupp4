
package edu.chalmers.grupp4.super_shop.core;

import java.util.List;

/**
 * Basic contract for containers of Products, Customers, etc
 * 
 * K is type of id (primary key)
 * 
 * @author hajo
 */
public interface IDAO<T, K> {

    public void add(T t);

    public void remove(K id);
    
    public void clear(String type);

    public void update(T t);

    public T find(K id);

    public List<T> getAll(String type);

    public List<T> getRange(int maxResults, int firstResult);

    public int getCount(String type);
}
