package dev.sarangan.productservicettseve.services;

import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

    Product addNewProduct(Product product);

    Product updateProduct(Long productId, Product product);

    Product replaceProduct(Long productId, Product product);

    Product deleteProduct(Long productId);

    Page<Product> getProducts(int numberOfProducts, int offset);

    Page<Product> getProductsByTitle(String query, int numberOfProducts, int offset);
}
