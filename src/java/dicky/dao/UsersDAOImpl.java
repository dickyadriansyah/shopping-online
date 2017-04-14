/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.dao;

import dicky.entities.Users;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dicky-java
 */
@Repository("usersDAO")
public class UsersDAOImpl implements UsersDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Users login(String username, String password) {
        return (Users) sessionFactory.getCurrentSession()
                .createQuery("from Users where username = :username and password = :password")
                .setString("username", username)
                .setString("password", password)
                .uniqueResult();
    }
    
}
