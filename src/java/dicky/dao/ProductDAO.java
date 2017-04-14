/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.dao;

import dicky.entities.Product;
import java.util.List;

/**
 *
 * @author dicky-java
 */
public interface ProductDAO {
    
    public String setId();
    
    public List<Product> findAll();
    
    public Product findId(String id);
    
    public void create(Product product);
    
    public void update(Product product);
    
    public void delete(Product product);
    
}
