/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.dao;

import org.springframework.stereotype.Repository;

/**
 *
 * @author dicky-java
 */
@Repository("makeidDAO")
public class MakeIdDAOImpl implements MakeIdDAO{

    @Override
    public String getId(String id, String awalan, int panjangField) {
        String max="";
        int nomber=0;
        String strTmp="";
        int panjangId=panjangField-awalan.length();
        int panjangNumber=0;
        if (id.equals("")) {
            nomber=0;
        }else{ 
            String idCut = id.substring(awalan.length(), panjangField);
            nomber = Integer.valueOf(idCut);
        }
             
            panjangNumber = String.valueOf(nomber+1).length();
            for (int i = 0; i < panjangId - panjangNumber; i++) {
                strTmp = strTmp + "0";
            }
            max=awalan+strTmp+String.valueOf(nomber+1);
        return max;
    }
    
}
