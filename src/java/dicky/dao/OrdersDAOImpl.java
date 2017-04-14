/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.dao;

import dicky.entities.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dicky-java
 */
@Repository("ordersDAO")
public class OrdersDAOImpl implements OrdersDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Orders create(Orders orders) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(orders);
        transaction.commit();
        session.close();
        return orders;
    }
    
}
