/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.dao;

import dicky.entities.Users;

/**
 *
 * @author dicky-java
 */
public interface UsersDAO {
    
    public Users login(String username, String password);
    
}
