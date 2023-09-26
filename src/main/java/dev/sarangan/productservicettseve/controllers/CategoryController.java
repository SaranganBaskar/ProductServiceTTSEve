package dev.sarangan.productservicettseve.controllers;

import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping()
    public String[] getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public List<Product> getProductsInCategory(@PathVariable("categoryId") String categoryId){
        return categoryService.getProductsInCategory(categoryId);
    }

}
