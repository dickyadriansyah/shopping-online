/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.dao;

import dicky.entities.OrdersDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dicky-java
 */
@Repository("ordersDetailDAO")
public class OrdersDetailDAOImpl implements OrdersDetailDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void create(OrdersDetail ordersDetail) {
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            session.save(ordersDetail);
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
    
}
