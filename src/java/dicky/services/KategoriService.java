/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.services;

import dicky.entities.Kategori;
import java.util.List;

/**
 *
 * @author dicky-java
 */
public interface KategoriService {
    
    public String setId();
    
    public List<Kategori> findAll();
    
    public Kategori findId(String id);
    
    public void create(Kategori kategori);
    
    public void update(Kategori kategori);
    
    public void delete(Kategori kategori);
    
}
