package dev.sarangan.productservicettseve.services;

import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Utilities {

    @Autowired
    private final CategoryRepository categoryRepository;

    public Utilities(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Product ConvertProductDtoToProduct(ProductDto productDto){
        Product newProduct = new Product();
        newProduct.setId(productDto.getId());
        newProduct.setTitle(productDto.getTitle());
        newProduct.setDescription(productDto.getDescription());
        newProduct.setImageUrl(productDto.getImage());
        newProduct.setPrice(productDto.getPrice());

        Optional<Category> category = Optional.ofNullable(categoryRepository.getCategoryByName(productDto.getCategory()));
        if(category.isPresent()){
            newProduct.setCategory(category.get());
        }else{
            Category newCategory = new Category();
            newCategory.setName(productDto.getCategory());
            newProduct.setCategory(newCategory);
        }
        return newProduct;
    }

    public ProductDto ConvertProductToProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImageUrl());
        productDto.setCategory(product.getCategory().getName());
        productDto.setPrice(product.getPrice());
        productDto.setRatingDto(productDto.getRatingDto());
        return productDto;
    }
}
