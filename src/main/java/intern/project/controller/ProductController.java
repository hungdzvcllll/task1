package intern.project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import intern.project.entity.Product;
import intern.project.service.FilesStorageServiceImpl;
import intern.project.service.ProductService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ProductController {
    @Autowired
    ProductService proService;
    @Autowired
    FilesStorageServiceImpl fileService;
    @PostMapping("/save_product")
    public void saveProduct(@RequestBody Product product) {
        proService.saveProduct(product);
    }
    @GetMapping("/findProductById")
    public Product findById(@RequestParam int id) {
        return proService.findById(id);
    }
    @GetMapping("findProductByCategoryId")
    public ArrayList<Product> findByCategoryId(@RequestParam int category_id){
        return proService.findByCategoryId(category_id);
    }
    @PostMapping("updatePrice")
    public void updatePrice(@RequestParam float price,@RequestParam int id){
        proService.UpdatePrice(price, id);
    }
    @PostMapping("deleteProductById")
    public String deleteById(@RequestParam int id){
        proService.deleteById(id);
        return "deleted_category";
    }       
}
