/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicky.controlleradmin;

import dicky.entities.Kategori;
import dicky.entities.Product;
import dicky.services.KategoriService;
import dicky.services.ProductService;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dicky-java
 */
@Controller
@RequestMapping("admin/product**")
public class ProductAdminController {

    String folderTujuan = "/uploads";
    
    @Autowired
    private ProductService productService;

    @Autowired
    private KategoriService kategoriService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("products", productService.findAll());
        return "admin.product.index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
        modelMap.put("kategoris", kategoriService.findAll());
        return "admin.product.add";
    }

    private File tujuanUpload(HttpSession session) {
        
        String lokasifullPath = session.getServletContext().getRealPath(folderTujuan);
        File hasil = new File(lokasifullPath);
        if (!hasil.exists()) {
            hasil.mkdirs();
        }
        return hasil;
    }

    @RequestMapping(value = "prosesInsert", method = RequestMethod.POST)
    public String prosesInsert(HttpServletRequest request, HttpSession session, ModelMap modelMap,
            @RequestParam("fileUpload") MultipartFile[] fileUpload) throws ServletException, IOException {

        if (fileUpload != null && fileUpload.length > 0) {
            for (MultipartFile file : fileUpload) {
                String lokasiUpload = tujuanUpload(session).getAbsolutePath();

                System.out.println("Saving file: " + file.getOriginalFilename());
                Product product = new Product();
                product.setIdProduct(request.getParameter("idproduct"));
                product.setNameProduct(request.getParameter("nama"));
                String price = request.getParameter("price");
                product.setPrice(new BigDecimal(price));
                String idkategori = request.getParameter("idkategori");
                Kategori findId = kategoriService.findId(idkategori);
                product.setKategori(findId);
                product.setFilename(file.getOriginalFilename());
                product.setFiledata(file.getBytes());
                File tujuan = new File(lokasiUpload + File.separator + file.getOriginalFilename());
                file.transferTo(tujuan);
                productService.create(product);
                modelMap.put("products", productService.findAll());

            }
        }

        return "redirect:../product.html";
    }

    @RequestMapping(value = "delete/{idProduct}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "idProduct") String idProduct, ModelMap modelMap) {
        this.productService.delete(this.productService.findId(idProduct));
        modelMap.put("products", productService.findAll());
        return "admin.product.index";
    }

    @RequestMapping(value = "edit/{idProduct}", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, @PathVariable(value = "idProduct") String idProduct, ModelMap modelMap) throws ServletException, IOException {
        request.setAttribute("product", this.productService.findId(idProduct));
        modelMap.put("kategoris", kategoriService.findAll());
        return "admin.product.edit";
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, ModelMap modelMap) throws ServletException, IOException{
        
        Product p=new Product();
        p.setIdProduct(request.getParameter("idproduct"));
        p.setNameProduct(request.getParameter("nama"));
        String price=request.getParameter("price");
        p.setPrice(new BigDecimal(price));
        String idkategori=request.getParameter("idkategori");
        Kategori findId = kategoriService.findId(idkategori);
        p.setKategori(findId);
        productService.update(p);
        modelMap.put("products", productService.findAll());
        return "redirect:../product.html";
    }

}
