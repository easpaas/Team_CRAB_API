package io.catalyte.training.controllers;

import io.catalyte.training.domains.products.Product;
import io.catalyte.training.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

/**
 * The Product Controller
 * All product CRUD functions processed through here to the service layer
 */

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Finds all Product objects in the ProductRepository with prices set to null
     * and can accept multiple query params to narrow down the results
     * @param product
     * @return List<Product>
     */
    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(Product product) {
        return new ResponseEntity<>(productService.getAllProducts(product), HttpStatus.OK);
    }

    /**
     * Finds all Product objects in the ProductRepository
     * and can accept multiple query params to narrow down the results
     * @param product
     * @return List<Product>
     */
    @GetMapping("/auth")
    public ResponseEntity<List<Product>> findAllProductsWithAuth(Product product) {
        return new ResponseEntity<>(productService.getAllProductsWithAuth(product), HttpStatus.OK);
    }

     /**
     * Searches the whole product Data Base and returns a page object with a arrayList of products with prices set to null,
     * the arrayList is sorted with a Sort by variable which returns the the list in ASCENDING order based on the variable which matches a product variable,
     * and it limits the total results of the arrayList with a num variable
     * @param product is an exampleMatcher variable that takes in valid query params to limit the results to products that match the supplied params
     * @param sortBy is a string that matches a Product variable that orders the list in ASCENDING based on the provided variable
     * @param num is a int that limits the number of the results returned by the list
     * @return
     */
    @GetMapping("/sort/{sortBy}/{num}")
    public ResponseEntity<Page<Product>> findAllProductsWithSort(Product product, @PathVariable String sortBy, @PathVariable int num) {
        return new ResponseEntity<>(productService.getAllProductsWithSort(product, sortBy, num), HttpStatus.OK);
    }

    /**
     * Searches the whole product Data Base and returns a page object with a arrayList of products,
     * the arrayList is sorted with a Sort by variable which returns the the list in ASCENDING order based on the variable which matches a product variable,
     * and it limits the total results of the arrayList with a num variable
     * @param product is an exampleMatcher variable that takes in valid query params to limit the results to products that match the supplied params
     * @param sortBy is a string that matches a Product variable that orders the list in ASCENDING based on the provided variable
     * @param num is a int that limits the number of the results returned by the list
     * @return
     */
    @GetMapping("/auth/sort/{sortBy}/{num}")
    public ResponseEntity<Page<Product>> findAllProductsWithSortWithAuth(Product product, @PathVariable String sortBy, @PathVariable int num) {
        return new ResponseEntity<>(productService.getAllProductsWithSortWithAuth(product, sortBy, num), HttpStatus.OK);
    }
}
