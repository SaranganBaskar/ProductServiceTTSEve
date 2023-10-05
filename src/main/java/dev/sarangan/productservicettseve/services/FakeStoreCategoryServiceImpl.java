package dev.sarangan.productservicettseve.services;

import dev.sarangan.productservicettseve.dtos.FakeStoreProductDto;
import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService {
    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public String[] getAllCategories() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class);
        return responseEntity.getBody();
    }

    @Override
    public List<Product> getProductsInCategory(String categoryId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> categorySpecificProductsList = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/category/{categoryId}",
                FakeStoreProductDto[].class, categoryId);

        List<Product> ansCategorySpecificProductsDto = new ArrayList<>();

        for(FakeStoreProductDto currProductDto: categorySpecificProductsList.getBody()){
            Product product = new Product();
            product.setId(currProductDto.getId());
            product.setTitle(currProductDto.getTitle());
            product.setPrice(currProductDto.getPrice());

            Category category = new Category();
            category.setName(currProductDto.getCategory());
            product.setCategory(category);
            product.setImageUrl(currProductDto.getImage());
            ansCategorySpecificProductsDto.add(product);
        }

        return ansCategorySpecificProductsDto;
    }
}
