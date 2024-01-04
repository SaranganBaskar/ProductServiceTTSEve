package dev.sarangan.productservicettseve;

import dev.sarangan.productservicettseve.models.Category;
import dev.sarangan.productservicettseve.models.Product;
import dev.sarangan.productservicettseve.repositories.CategoryRepository;
import dev.sarangan.productservicettseve.repositories.ProductRepository;
import dev.sarangan.productservicettseve.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

//@SpringBootTest
public class ProductTest {

//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    private CategoryService categoryService;
//    @Autowired
//    private ProductRepository productRepository;
//
//    //region Product Module
//    @Test
//    void CreateProductInDbTest(){
//        /*Category category = categoryRepository.getCategoryById(52L);
//        Product product = new Product();
//        product.setTitle("Samsung F41 Pro");
//        product.setPrice(16000);
//        product.setDescription("This is my Samsung Mobile gadget");
//        product.setImageUrl("https://ThisisMySmsungF41ProImage/");
//        product.setCategory(category);
//        productRepository.save(product);*/
//
//        Product product = new Product();
//        product.setTitle("Honda Shine");
//        product.setPrice(110000);
//        product.setDescription("This is my Honda shine vehicle");
//        product.setImageUrl("https://ThisisMyHondaShineVehicleImage/");
//
//        Optional<Category> category = Optional.ofNullable(categoryRepository.getCategoryByName("Electronics"));
//        if(category.isPresent()){
//            product.setCategory(category.get());
//        }else{
//            Category newCategory = new Category();
//            newCategory.setName("Electric vehicle");
//            newCategory.setDescription("This is my Electric Vehicle Category");
//        }
//
//        productRepository.save(product);
//    }
//
//    @Test
//    void getAllProductInDbTest(){
//        List<Product> productListTest = productRepository.findAll();
//        for (Product p: productListTest){
//            System.out.println("The current Product is: " + p.getTitle());
//        }
//    }
//
//    @Test
//    void findProductByIdInDbTest(){
//        Optional<Product> productTest = Optional.ofNullable(productRepository.findProductById(51L));
//
//        if(productTest.isPresent()){
//            System.out.println(productTest.get().getTitle());
//        }else{
//            System.out.println("Oops! It seems the product is not available. Please try again with different product Id!!");
//        }
//    }
//
//    @Test
//    //@Transactional
//    void softDeleteProductByIdInDbTest(){
//        Optional<Product> deleteProductTest = Optional.ofNullable(productRepository.findProductById(2L));
//        if(deleteProductTest.isPresent()){
//            deleteProductTest.get().setDeleted(true);
//            Product deletedProductTest = productRepository.save(deleteProductTest.get());
//            //productRepository.deleteProductById(2L);
//            System.out.println("The Product " + deletedProductTest.getTitle() + "is marked for deletion");
//        }else{
//            System.out.println("Oops! It seems the product is not available for deletion. Please try again with different product Id!!");
//        }
//    }
//    //endregion
}
