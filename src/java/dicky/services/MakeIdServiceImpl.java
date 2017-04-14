/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.services;

import dicky.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dicky-java
 */
@Service("makeidService")
@Transactional
public class MakeIdServiceImpl implements MakeIdService{

    @Autowired
    private MakeIdDAO makeidDAO;
    
    @Override
    public String getId(String id, String awalan, int panjangField) {
        return makeidDAO.getId(id, awalan, panjangField);
    }
    
}
