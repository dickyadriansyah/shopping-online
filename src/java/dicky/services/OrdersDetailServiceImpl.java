/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.services;

import dicky.dao.OrdersDetailDAO;
import dicky.entities.OrdersDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dicky-java
 */
@Transactional
@Service("ordersDetailService")
public class OrdersDetailServiceImpl implements OrdersDetailService{

    @Autowired
    private OrdersDetailDAO ordersDetailDAO;
    
    @Override
    public void create(OrdersDetail ordersDetail) {
        ordersDetailDAO.create(ordersDetail);
    }
    
}
