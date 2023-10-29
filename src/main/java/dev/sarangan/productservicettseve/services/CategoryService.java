package dev.sarangan.productservicettseve.services;

import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {

    Category createCategory(String categoryName, String categoryDescription);

    String[] getAllCategories();


    List<Product> getProductsInCategory(@PathVariable("categoryId") String categoryId);
}
