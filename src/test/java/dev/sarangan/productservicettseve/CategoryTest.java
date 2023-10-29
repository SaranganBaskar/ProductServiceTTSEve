package dev.sarangan.productservicettseve;

import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.repositories.CategoryRepository;
import dev.sarangan.productservicettseve.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    //region Category Module
    @Test
    void CreateCategoryTest(){
        Category category = new Category();
        category.setName("Laptops");
        category.setDescription("this is Laptops category");
        categoryRepository.save(category);
    }

    @Test
    void CreateCategoryInDbTest(){
        Category category = new Category();
        category.setName("Accessories");
        category.setDescription("this is Accessories category");
        categoryService.createCategory(category.getName(), category.getDescription());
    }

    @Test
    void GetCategoriesInDbTest(){
        String[] categoriesListTest = categoryService.getAllCategories();
        //System.out.println("The current Category is: " + categoriesListTest);
        for (String s: categoriesListTest){
            System.out.println("The current Category is: " + s);
        }
    }
    //endregion
}
