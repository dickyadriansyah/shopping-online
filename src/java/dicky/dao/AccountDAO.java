/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.dao;

import dicky.entities.Account;

/**
 *
 * @author dicky-java
 */
public interface AccountDAO {
    public void create(Account account);
    
    public Account login(String username, String password);
    
    public Account find(String username);
}
