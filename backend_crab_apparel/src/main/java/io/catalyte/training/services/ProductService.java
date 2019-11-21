package io.catalyte.training.services;

import io.catalyte.training.domains.products.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(Product product);

    List<Product> getAllProductsWithAuth(Product product);

    Page<Product> getAllProductsWithSort(Product product, String sortBy, int pages);

    Page<Product> getAllProductsWithSortWithAuth(Product product, String sortBy, int pages);

    List<Product> getAllProductsWithPromotionFlagTrue();

    List<Product> getTop2ProductsOrderedByCreateDateDesc();

    List<Product> getTop4ProductsOrderedByViewCountDesc();

    Product getProduct(Long productId);

    Product getProductWithAuth(Long productId);

    Product addProduct(Product product);

    List<Product> addProductList(List<Product> products);

    Product updateProductById(Long productId, Product product);

    void deleteProduct(Long productId);

}
