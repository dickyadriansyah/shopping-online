/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.services;

import dicky.dao.AccountDAO;
import dicky.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dicky-java
 */

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDAO accountDAO;
    
    @Override
    public void create(Account account) {
        accountDAO.create(account);
    }

    @Override
    public Account login(String username, String password) {
        return accountDAO.login(username, password);
    }

    @Override
    public Account find(String username) {
        return accountDAO.find(username);
    }
    
}
