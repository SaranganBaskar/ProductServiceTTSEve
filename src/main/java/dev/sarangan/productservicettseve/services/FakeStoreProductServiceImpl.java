package dev.sarangan.productservicettseve.services;

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
public class FakeStoreProductServiceImpl implements ProductService {

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class, productId);
        ProductDto productDto = response.getBody();

        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());

        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());

        return product;
    }

    @Override
    public Product addNewProduct(ProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                ProductDto.class);

        ProductDto productDto = response.getBody();
        Product addedProduct = new Product();
        addedProduct.setId(productDto.getId());
        addedProduct.setTitle(productDto.getTitle());
        addedProduct.setPrice(productDto.getPrice());

        Category category = new Category();
        category.setName(productDto.getCategory());
        addedProduct.setCategory(category);
        addedProduct.setImageUrl(productDto.getImage());

        return addedProduct;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> productsList = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProductDto[].class);

        List<Product> ansProductDto = new ArrayList<>();

        for(ProductDto currProductDto: productsList.getBody()){
            Product product = new Product();
            product.setId(currProductDto.getId());
            product.setTitle(currProductDto.getTitle());
            product.setPrice(currProductDto.getPrice());

            Category category = new Category();
            category.setName(currProductDto.getCategory());
            product.setCategory(category);
            product.setImageUrl(currProductDto.getImage());
            ansProductDto.add(product);
        }

        return ansProductDto;
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        return null;
    }
}
