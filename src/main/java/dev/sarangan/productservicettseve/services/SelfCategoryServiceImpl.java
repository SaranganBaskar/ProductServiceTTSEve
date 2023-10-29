package dev.sarangan.productservicettseve.services;

import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

@Service
public class SelfCategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public SelfCategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category createCategory(String categoryName, String categoryDescription) {
        Category newCategory = new Category();
        newCategory.setName(categoryName);
        newCategory.setDescription(categoryDescription);
        return categoryRepository.save(newCategory);
    }

    @Override
    public String[] getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        ArrayList<String> categoryDtoList = new ArrayList<String>();
        for (int i = 0; i < categoryList.size(); i++){
            categoryDtoList.add(categoryList.get(i).getName());
        }
        return categoryDtoList.toArray(new String[0]);
    }

    @Override
    public List<Product> getProductsInCategory(String categoryId) {
        return null;
    }
}
