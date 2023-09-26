package dev.sarangan.productservicettseve.services;

import dev.sarangan.productservicettseve.dtos.productDto;
import org.springframework.web.bind.annotation.*;

public interface ProductService {

    String getAllProducts();

    String getSingleProduct(@PathVariable("productId") Long productId);

    String addNewProduct(@RequestBody productDto productDto);

    String updateProduct(@PathVariable("productId") Long productId);

    String deleteProduct(@PathVariable("productId") Long productId);
}
