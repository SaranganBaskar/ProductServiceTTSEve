package dev.sarangan.productservicettseve.services;

import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.repositories.CategoryRepository;
import dev.sarangan.productservicettseve.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public SelfProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return productRepository.findProductById(productId);
    }

    @Override
    public Product addNewProduct(Product product) {
        Product newSavedProduct = productRepository.save(product);
        return newSavedProduct;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Optional<Product> productTobReplaced = Optional.ofNullable(productRepository.findProductById(productId));
        if(productTobReplaced.isPresent()){
            return productRepository.save(product);
        }
        return product;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        Optional<Product> productTobReplaced = Optional.ofNullable(productRepository.findProductById(productId));
        if(productTobReplaced.isPresent()){
            return productRepository.save(product);
        }
        return product;
    }

    @Override
    public Product deleteProduct(Long productId) {
        Optional<Product> softDeleteProduct = Optional.ofNullable(productRepository.findProductById(productId));
        if(softDeleteProduct.isPresent()){
            softDeleteProduct.get().setDeleted(true);
            return productRepository.save(softDeleteProduct.get());
        }
        return softDeleteProduct.get();
    }
}
