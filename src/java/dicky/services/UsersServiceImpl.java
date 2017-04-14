/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.services;

import dicky.dao.UsersDAO;
import dicky.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dicky-java
 */
@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersDAO usersDAO;
    
    @Override
    public Users login(String username, String password) {
        return usersDAO.login(username, password);
    }
    
}
