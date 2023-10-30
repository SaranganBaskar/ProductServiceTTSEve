package dev.sarangan.productservicettseve.services;

import dev.sarangan.productservicettseve.dtos.FakeStoreProductDto;
import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.repositories.ProductRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto) {
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
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDto.class,
                productId);

        FakeStoreProductDto productDto = response.getBody();
        return convertFakeStoreProductDtoToProduct(productDto);
    }

    @Override
    public Product addNewProduct(Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                FakeStoreProductDto.class);

        FakeStoreProductDto productDto = response.getBody();
        return convertFakeStoreProductDtoToProduct(productDto);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class).build();

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setCategory(product.getCategory().getName());

        FakeStoreProductDto fakeStoreProductDtoResponse = restTemplate.patchForObject(
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId
        );
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtoResponse);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        RestTemplate restTemplateForReplace = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class).build();

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setCategory(product.getCategory().getName());

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("id", productId);

        HttpEntity<FakeStoreProductDto> httpEntityFakeStoreProductDto = new HttpEntity<>(fakeStoreProductDto);

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoForReplace = restTemplateForReplace.exchange(
                "https://fakestoreapi.com/products/{id}",
                HttpMethod.PUT,
                httpEntityFakeStoreProductDto,
                FakeStoreProductDto.class,
                uriVariables
        );
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtoForReplace.getBody());
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> productsList = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        List<Product> ansProductDto = new ArrayList<>();

        for (FakeStoreProductDto currProductDto : productsList.getBody()) {
            ansProductDto.add(convertFakeStoreProductDtoToProduct(currProductDto));
        }

        return ansProductDto;
    }

    @Override
    public Product deleteProduct(Long productId) {
        RestTemplate restTemplateForReplace = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class).build();

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("id", productId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<FakeStoreProductDto> httpEntityFakeStoreProductDtoForDelete = new HttpEntity<>(headers);

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoForDelete =
                restTemplateForReplace.exchange(
                        "https://fakestoreapi.com/products/{id}",
                        HttpMethod.DELETE,
                        httpEntityFakeStoreProductDtoForDelete,
                        FakeStoreProductDto.class,
                        uriVariables
                );
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtoForDelete.getBody());
    }
}
