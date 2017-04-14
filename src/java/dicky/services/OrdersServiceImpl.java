/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.services;

import dicky.dao.OrdersDAO;
import dicky.entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dicky-java
 */
@Transactional
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersDAO ordersDAO;
    
    @Override
    public Orders create(Orders orders) {
        return ordersDAO.create(orders);
    }
    
}
