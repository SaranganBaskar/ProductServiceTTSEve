package dev.sarangan.productservicettseve.controllers;

import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.services.ProductService;
import dev.sarangan.productservicettseve.services.Utilities;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/SelfProducts")
public class SelfProductController {
    private final ProductService productService;

    private final Utilities utilities;

    public SelfProductController(ProductService productService, Utilities utilities){
        this.productService = productService;
        this.utilities = utilities;
    }

    @GetMapping()
    public List<ProductDto> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product p: products){
            productDtos.add(utilities.ConvertProductToProductDto(p));
        }
        return productDtos;
    }

    @PostMapping()
    public ResponseEntity<ProductDto> addNewProduct(@RequestBody ProductDto productDto){
        Product newProductToAdd = utilities.ConvertProductDtoToProduct(productDto);
        Product newlyAddedProduct = productService.addNewProduct(newProductToAdd);
        return new ResponseEntity<>(utilities.ConvertProductToProductDto(newlyAddedProduct), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getSingleProduct(@PathVariable("productId") Long productId){
        //To Add response Headers
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-customToken", "noAccessTestToken");

        return new ResponseEntity<>(utilities.ConvertProductToProductDto(productService.getSingleProduct(productId)), headers, HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ProductDto replaceProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto){
        Product productToReplace = utilities.ConvertProductDtoToProduct(productDto);
        return utilities.ConvertProductToProductDto(productService.updateProduct(productId, productToReplace));
    }

    @PatchMapping("/{productId}")
    public ProductDto updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto){
        Product productToUpdate = utilities.ConvertProductDtoToProduct(productDto);
        return utilities.ConvertProductToProductDto(productService.updateProduct(productId, productToUpdate));
    }

    @DeleteMapping("/{productId}")
    public ProductDto deleteProduct(@PathVariable("productId") Long productId){
        return utilities.ConvertProductToProductDto(productService.deleteProduct(productId));
    }
}
