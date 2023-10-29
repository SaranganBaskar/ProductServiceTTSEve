package dev.sarangan.productservicettseve.services;

import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.repositories.ProductRepository;

import java.util.List;

public class SelfProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public Product addNewProduct(ProductDto product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }
}
