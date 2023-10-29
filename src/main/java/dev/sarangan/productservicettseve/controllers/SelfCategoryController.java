package dev.sarangan.productservicettseve.controllers;

import dev.sarangan.productservicettseve.dtos.CategoryDto;
import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.services.CategoryService;
import dev.sarangan.productservicettseve.services.SelfCategoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelfCategoryController {
    private final CategoryService categoryService;

    public SelfCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/selfcategories")
    public CategoryDto createCategory(@PathVariable("categoryName") String categoryName, @PathVariable("categoryDescription") String categoryDescription){
        Category newCategory = categoryService.createCategory(categoryName, categoryDescription);
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName(newCategory.getName());
        categoryDto.setCategoryDescription(newCategory.getDescription());
        return categoryDto;
    }

    @GetMapping("/selfcategories")
    public String[] getAllCategories(){
        return categoryService.getAllCategories();
    }
}
