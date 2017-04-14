/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.dao;

import dicky.entities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dicky-java
 */
@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void create(Account account) {
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            session.save(account);
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
    public Account login(String username, String password) {
        return (Account) sessionFactory.getCurrentSession()
                .createQuery("from Account where username = :username and password = :password")
                .setString("username", username)
                .setString("password", password)
                .uniqueResult();
    }

    @Override
    public Account find(String username) {
        return (Account) sessionFactory.getCurrentSession()
                .get(Account.class, username);
    }
    
}
