/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.controlleradmin;

import dicky.entities.Kategori;
import dicky.services.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dicky-java
 */
@Controller
@RequestMapping("admin/kategori**")
public class KategoriAdminController {
    
    @Autowired
    private KategoriService kategoriService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("kategoris", kategoriService.findAll());
        return "admin.kategori.index";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        modelMap.put("kategori", new Kategori());
        return "admin.kategori.add";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute(value = "kategori") Kategori kategori, ModelMap modelMap){
        this.kategoriService.create(kategori);
        modelMap.put("kategoris", kategoriService.findAll());
        return "redirect:../kategori.html";
    }
    
    @RequestMapping(value = "delete/{idKategori}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "idKategori") String idKategori, ModelMap modelMap){
        this.kategoriService.delete(this.kategoriService.findId(idKategori));
        modelMap.put("kategoris", kategoriService.findAll());
        return "admin.kategori.index";
    }
    
    @RequestMapping(value = "edit/{idKategori}", method = RequestMethod.GET)
    public String edit(@PathVariable(value = "idKategori") String idKategori, ModelMap modelMap){
        modelMap.put("kategori", kategoriService.findId(idKategori));
        return "admin.kategori.edit";
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute(value = "kategori") Kategori kategori, ModelMap modelMap){
        this.kategoriService.update(kategori);
        modelMap.put("kategoris", kategoriService.findAll());
        return "redirect:../kategori.html";
    }
    
}
