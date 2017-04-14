/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.dao;

import dicky.entities.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dicky-java
 */
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Product> findAll() {
        List<Product> list=new ArrayList<Product>();
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            list=session.createCriteria(Product.class).list();
            transaction.commit();
        } catch (RuntimeException e) {
            if(transaction!=null){
                transaction.rollback();
            }
            list=null;
        }finally{
            session.flush();
            session.close();
        }
        return list;
    }

    @Override
    public Product findId(String id) {
        Product p=null;
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            p=(Product) session.get(Product.class, id);
            transaction.commit();
        } catch (RuntimeException e) {
            if(transaction!=null){
                transaction.rollback();
            }
            p=null;
        }finally{
            session.flush();
            session.close();
        }
        return p;
    }

    @Override
    public void create(Product product) {
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (RuntimeException e) {
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.flush();
            session.close();
        }
        
    }

    @Override
    public void update(Product product) {
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            Query q=session.createQuery("update Product set name_product=:n, price=:p, id_kategori=:d where id_product=:i");
            q.setParameter("n", product.getNameProduct());
            q.setParameter("i", product.getIdProduct());
            q.setBigDecimal("p",product.getPrice());
            q.setParameter("d", product.getKategori().getIdKategori());
            int executeUpdate = q.executeUpdate();
            System.out.println(executeUpdate);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.flush();
            session.close();
        }
    }

    @Override
    public void delete(Product product) {
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            session.delete(product);
            transaction.commit();
        } catch (RuntimeException e) {
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.flush();
            session.close();
        }
    }

    @Override
    public String setId() {
        String id = "";
        try {
            for(Product p: findAll()){
                id=p.getIdProduct();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
}
