package dev.sarangan.productservicettseve.controllers;

import dev.sarangan.productservicettseve.dtos.CategoryDto;
import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.repositories.CategoryRepository;
import dev.sarangan.productservicettseve.repositories.ProductRepository;
import dev.sarangan.productservicettseve.services.CategoryService;
import dev.sarangan.productservicettseve.services.ProductService;
import dev.sarangan.productservicettseve.services.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SelfCategoryController {
    private final CategoryService categoryService;
    private final Utilities utilities;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfCategoryController(CategoryService categoryService, Utilities utilities,
                                  ProductRepository productRepository,
                                  CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.utilities = utilities;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/selfcategories")
    public CategoryDto createCategory(@PathVariable("categoryName") String categoryName, @PathVariable("categoryDescription") String categoryDescription) {
        Category newCategory = categoryService.createCategory(categoryName, categoryDescription);
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName(newCategory.getName());
        categoryDto.setCategoryDescription(newCategory.getDescription());
        return categoryDto;
    }

    @GetMapping("/selfcategories")
    public String[] getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/selfproducts/selfcategories/{categoryName}")
    public List<ProductDto> getProductsInCategory(@PathVariable("categoryName") String categoryName) {
        Long categoryId = categoryRepository.getCategoryByName(categoryName).getId();
        List<Product> products = productRepository.findProductsByCategoryId(categoryId);
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product p : products) {
            productDtos.add(utilities.ConvertProductToProductDto(p));
        }
        return productDtos;
    }
}
