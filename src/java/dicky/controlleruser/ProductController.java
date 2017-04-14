/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicky.controlleruser;

import dicky.entities.Kategori;
import dicky.services.KategoriService;
import dicky.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dicky-java
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private KategoriService kategoriService;
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("title", "Data Product");
        modelMap.put("productlist", productService.findAll());
        return "product.list";
    }
    
    @RequestMapping(value = "kategori/{idKategori}", method = RequestMethod.GET)
    public String kategori(@PathVariable("idKategori") String idKategori, ModelMap modelMap){
        Kategori kategori=kategoriService.findId(idKategori);
        modelMap.put("title", "Data Product");
        modelMap.put("kategori", kategori);
        modelMap.put("products", kategori.getProducts());
        modelMap.put("action", "product");
        return "product.kategori";
    }
    
}
