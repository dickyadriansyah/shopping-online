/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.services;

import dicky.dao.KategoriDAO;
import dicky.entities.Kategori;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dicky-java
 */

@Service("kategoriService")
@Transactional
public class KategoriServiceImpl implements KategoriService{

    @Autowired
    private KategoriDAO kategoriDAO;
    
    @Override
    public List<Kategori> findAll() {
        return kategoriDAO.findAll();
    }

    @Override
    public Kategori findId(String id) {
        return kategoriDAO.findId(id);
    }

    @Override
    public void create(Kategori kategori) {
        kategoriDAO.create(kategori);
    }

    @Override
    public void update(Kategori kategori) {
        kategoriDAO.update(kategori);
    }

    @Override
    public void delete(Kategori kategori) {
        kategoriDAO.delete(kategori);
    }

    @Override
    public String setId() {
        return kategoriDAO.setId();
    }
    
}
