/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.services;

import dicky.entities.Users;

/**
 *
 * @author dicky-java
 */
public interface UsersService {
    
    public Users login(String username, String password);
    
}
