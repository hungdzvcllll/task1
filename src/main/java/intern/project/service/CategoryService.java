package intern.project.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import intern.project.entity.Category;
import intern.project.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository cateRepo;

    public void saveCategory(Category category) {
        cateRepo.save(category);
    }

    public Category findById(int id) {
        Optional op = cateRepo.findById(id);
        return (Category) op.get();
    }

    public ArrayList<Category> findByName(String name) {
        return cateRepo.findByName(name);
    }

    public ArrayList<Category> findAll() {
        return cateRepo.findAll();
    }

    public void upDateCategoryName(String name, int id) {
        cateRepo.upDateCategoryName(name, id);
    }

    public void deleteById(int id) {
        cateRepo.deleteById(id);
    }

    public void deleteByName(String name) {
        cateRepo.deleteByName(name);
    }
}
