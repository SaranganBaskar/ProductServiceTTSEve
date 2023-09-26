package dev.sarangan.productservicettseve.services;

import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

    Product addNewProduct(ProductDto product);

    Product updateProduct(Long productId, Product product);

    Boolean deleteProduct(Long productId);
}
