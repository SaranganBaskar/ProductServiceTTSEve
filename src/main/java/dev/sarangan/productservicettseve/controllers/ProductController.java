package dev.sarangan.productservicettseve.controllers;

import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){

        //To Add response Headers
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-customToken", "noAccessTestToken");

        return new ResponseEntity<>(productService.getSingleProduct(productId), headers, HttpStatus.OK);
        //GetSingleProductResponseDto responseDto = new GetSingleProductResponseDto();
        //responseDto.setProduct(productService.getSingleProduct(productId));
        //return responseDto;
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product){
        Product newProduct = productService.addNewProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }


    @PatchMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return productService.updateProduct(productId, product);
    }

    @PutMapping("/{productId}")
    public Product replaceProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return productService.replaceProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public Product deleteProduct(@PathVariable("productId") Long productId){

        return productService.deleteProduct(productId);
    }
}
