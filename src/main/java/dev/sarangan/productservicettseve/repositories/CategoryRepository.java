package dev.sarangan.productservicettseve.repositories;

import dev.sarangan.productservicettseve.dtos.CategoryDto;
import dev.sarangan.productservicettseve.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);

    List<Category> findAll();
}
