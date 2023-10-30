package dev.sarangan.productservicettseve.repositories;

import dev.sarangan.productservicettseve.dtos.CategoryDto;
import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.services.CategoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);

    List<Category> findAll();

    Category getCategoryById(Long Id);

    Category getCategoryByName(String categoryName);

    @Query(value = "select * from product where category_id= :categoryId", nativeQuery = true)
    List<Product> getProductsByCategoryId(Long categoryId);
}
