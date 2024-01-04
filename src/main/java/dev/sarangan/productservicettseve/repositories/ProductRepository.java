package dev.sarangan.productservicettseve.repositories;

import dev.sarangan.productservicettseve.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    List<Product> findAll();

    Product findProductById(Long productId);

    //Product deleteProductById(Long productId);

    List<Product> findProductsByCategoryId(Long categoryId);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByTitleContaining(String query, Pageable pageable);
}
