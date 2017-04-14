/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.dao;

import dicky.entities.Kategori;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dicky-java
 */
@Repository("kategoriDAO")
public class KategoriDAOImpl implements KategoriDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Kategori> findAll() {
        List<Kategori> list=new ArrayList<Kategori>();
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            list=session.createCriteria(Kategori.class).list();
            transaction.commit();
        } catch (Exception e) {
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
    public Kategori findId(String id) {
        Kategori k=null;
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            k=(Kategori) session.get(Kategori.class, id);
            transaction.commit();
        } catch (RuntimeException e) {
            if(transaction!=null){
                transaction.rollback();
            }
            k=null;
        }finally{
            session.flush();
            session.close();
        }
        return k;
    }

    @Override
    public void create(Kategori kategori) {
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            session.save(kategori);
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
    public void update(Kategori kategori) {
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            session.update(kategori);
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
    public void delete(Kategori kategori) {
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            session.delete(kategori);
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
            for(Kategori k: findAll()){
                id=k.getIdKategori();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

}
