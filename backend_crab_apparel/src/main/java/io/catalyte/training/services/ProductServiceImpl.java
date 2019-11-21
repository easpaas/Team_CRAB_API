package io.catalyte.training.services;

import io.catalyte.training.domains.products.Product;
import io.catalyte.training.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(Product product) {
        Example<Product> productExample = Example.of(product);
        List<Product> productList = productRepository.findAll(productExample);
        for (Product p : productList) {
            p.setPrice(null);
        }
        return productList;
    }

    @Override
    public List<Product> getAllProductsWithAuth(Product product) {
        Example<Product> productExample = Example.of(product);
        return productRepository.findAll(productExample);
    }

    @Override
    public Page<Product> getAllProductsWithSort(Product product, String sortBy, int pages) {
        Example<Product> productExample = Example.of(product);
        Page<Product> productList = productRepository.findAll(productExample, PageRequest.of(0, pages, Sort.by(Sort.Direction.DESC, sortBy)));
        for (Product p : productList) {
            p.setPrice(null);
        }
        return productList;
    }

    @Override
    public Page<Product> getAllProductsWithSortWithAuth(Product product, String sortBy, int pages) {
        Example<Product> productExample = Example.of(product);
        return productRepository.findAll(productExample, PageRequest.of(0, pages, Sort.by(Sort.Direction.DESC, sortBy)));
    }

    @Override
    public List<Product> getAllProductsWithPromotionFlagTrue() {
        return productRepository.findByPromotionFlagTrue();
    }

    @Override
    public List<Product> getTop2ProductsOrderedByCreateDateDesc() {
        return productRepository.findTop2ByCreateDateNotNullOrderByCreateDateDesc();
    }

    @Override
    public List<Product> getTop4ProductsOrderedByViewCountDesc() {
        return productRepository.findTop4ByViewCountNotNullOrderByViewCountDesc();
    }

    @Override
    public Product getProduct(Long productId) {
        if(productRepository.existsById(productId)) {
            Product p = productRepository.findById(productId).orElse(null);
            p.setPrice(null);
            return p;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



    @Override
    public Product getProductWithAuth(Long productId) {
        if(productRepository.existsById(productId)) {
            return productRepository.findById(productId).orElse(null);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> addProductList(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product updateProductById(Long productId, Product product) {
        if(productRepository.existsById(productId)){
            product.setProductId(productId);
            return productRepository.save(product);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
        } else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
