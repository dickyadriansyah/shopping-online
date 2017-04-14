/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.services;

import dicky.dao.ProductDAO;
import dicky.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dicky-java
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDAO productDAO;
    
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findId(String id) {
         return productDAO.findId(id);
    }

    @Override
    public void create(Product product) {
        productDAO.create(product);
    }

    @Override
    public void update(Product product) {
       productDAO.update(product);
    }

    @Override
    public void delete(Product product) {
        productDAO.delete(product);
    }

    @Override
    public String setId() {
        return productDAO.setId();
    }
    
}
