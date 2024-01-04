package dev.sarangan.productservicettseve.controllers;

import dev.sarangan.productservicettseve.clients.authenticationClient.AuthenticationClient;
import dev.sarangan.productservicettseve.clients.authenticationClient.dtos.ValidateTokenResponseDto;
import dev.sarangan.productservicettseve.clients.authenticationClient.models.Role;
import dev.sarangan.productservicettseve.clients.authenticationClient.models.SessionStatus;
import dev.sarangan.productservicettseve.dtos.GetProductsRequestDto;
import dev.sarangan.productservicettseve.dtos.ProductDto;
import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.services.ProductService;
import dev.sarangan.productservicettseve.services.Utilities;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
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

    private AuthenticationClient authenticationClient;

    public SelfProductController(ProductService productService, Utilities utilities, AuthenticationClient authenticationClient) {
        this.productService = productService;
        this.utilities = utilities;
        this.authenticationClient = authenticationClient;
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<Product>> getProducts(@RequestBody GetProductsRequestDto getProductsRequestDto) {
        return new ResponseEntity<>(
                productService.getProducts(
                        getProductsRequestDto.getNumberOfResults(),
                        getProductsRequestDto.getOffset()
                ),
                HttpStatus.OK);
    }

    @GetMapping("/paginated/title")
    public ResponseEntity<Page<Product>> getProductsByTitle(@RequestBody GetProductsRequestDto getProductsRequestDto) {
        return new ResponseEntity<>(
                productService.getProductsByTitle(
                        getProductsRequestDto.getTitleQuery(),
                        getProductsRequestDto.getNumberOfResults(),
                        getProductsRequestDto.getOffset()
                ),
                HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProducts(
            @Nullable @RequestHeader("AUTH_TOKEN") String token,
            @Nullable @RequestHeader("USER_ID") Long userId) {

        /*//Check If Token and User Id exists
        if (token == null || userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // Once token is available, Validate the Token
        ValidateTokenResponseDto responseDto = authenticationClient.validate(token, userId);
        if (responseDto.getStatus().equals(SessionStatus.INVALID)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        //Check If user has permissions
        boolean isUserAdmin = false;
        for(Role role: responseDto.getUserDto().getRoleSet()){
            if(role.getName().equals("ADMIN")){
                isUserAdmin= true;
            }
        }

        if(!isUserAdmin){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }*/


        List<Product> products = productService.getAllProducts();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product p : products) {
            productDtos.add(utilities.ConvertProductToProductDto(p));
        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductDto> addNewProduct(@RequestBody ProductDto productDto) {
        Product newProductToAdd = utilities.ConvertProductDtoToProduct(productDto);
        Product newlyAddedProduct = productService.addNewProduct(newProductToAdd);
        return new ResponseEntity<>(utilities.ConvertProductToProductDto(newlyAddedProduct), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getSingleProduct(@PathVariable("productId") Long productId) {
        //To Add response Headers
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-customToken", "noAccessTestToken");

        return new ResponseEntity<>(utilities.ConvertProductToProductDto(productService.getSingleProduct(productId)), headers, HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ProductDto replaceProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {
        Product productToReplace = utilities.ConvertProductDtoToProduct(productDto);
        return utilities.ConvertProductToProductDto(productService.updateProduct(productId, productToReplace));
    }

    @PatchMapping("/{productId}")
    public ProductDto updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {
        Product productToUpdate = utilities.ConvertProductDtoToProduct(productDto);
        return utilities.ConvertProductToProductDto(productService.updateProduct(productId, productToUpdate));
    }

    @DeleteMapping("/{productId}")
    public ProductDto deleteProduct(@PathVariable("productId") Long productId) {
        return utilities.ConvertProductToProductDto(productService.deleteProduct(productId));
    }
}
