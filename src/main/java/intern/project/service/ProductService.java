package intern.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import intern.project.entity.Product;
import intern.project.repository.ProductRepository;
@Service
public class ProductService {
    @Autowired
    ProductRepository prRepo;

    public void saveProduct(Product product) {
        prRepo.save(product);
    }

    public Product findById(int id) {
        return prRepo.findById(id);
    }

    public ArrayList<Product> findByCategoryId(int category_id) {
        return prRepo.findByCategoryId(category_id);
    }
    public ArrayList<Product> findByName(String name){
        return prRepo.findByName(name);
    }
    public void UpdatePrice(float price, int id) {
        prRepo.updatePrice(price, id);
    }

    public void deleteById(int id) {
        prRepo.deleteById(id);
    }
    public ArrayList<Product> findAll(){
        return prRepo.findAll();
    }
}
