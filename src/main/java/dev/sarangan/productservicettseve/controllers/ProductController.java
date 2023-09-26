package dev.sarangan.productservicettseve.controllers;

import dev.sarangan.productservicettseve.dtos.productDto;
import dev.sarangan.productservicettseve.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping()
    public String getAllProducts(){
        return "Getting All Products";
    }

    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId){
        return "Returning Single Product with id" + productId;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody productDto productDto){
        return "Adding New Product with " + productDto;
    }


    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId){
        return "Updating Product";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting a product";
    }
}
