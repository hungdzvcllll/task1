package intern.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import intern.project.entity.Category;
import intern.project.service.CategoryService;

@Controller
public class CategoryController {
    @Autowired
    CategoryService cateService;


    @PostMapping("saveCategory")
    public void saveCategory(@RequestBody Category category) {
        cateService.saveCategory(category);
    }

    @GetMapping("list_category")
    public ArrayList<Category> findAll() {
       return cateService.findAll();
    }
    @PostMapping("rename_category_form")
    public void renameForm(@RequestParam String name,@RequestParam int id){
        cateService.upDateCategoryName(name, id);
    }
    @GetMapping("findCategoryById")
    public Category findById(@RequestParam int id) {
        return cateService.findById(id);
    }

    @GetMapping("findCategoryByName")
    public ArrayList<Category> findByName(@RequestParam String name) {
        return cateService.findByName(name);
    }

    @PostMapping("updateCategoryName")
    public void upDateCategoryName(@RequestParam String name, @RequestParam int id) {
        cateService.upDateCategoryName(name, id);
    }

    @PostMapping("deleteCategoryById")
    public void deleteById(@RequestParam int id) {
        cateService.deleteById(id);
    }

}
