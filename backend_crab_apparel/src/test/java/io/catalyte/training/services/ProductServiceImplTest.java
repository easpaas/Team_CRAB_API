package io.catalyte.training.services;

import io.catalyte.training.domains.products.Product;
import io.catalyte.training.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    ProductRepository mockProductRepo;

    Product product;

    List<Product> productList;

    Page<Product> productPage;

    Product product1;
    Product product2;

    @InjectMocks
    ProductServiceImpl productService;

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    @Before
    public void before() {
        product = new Product();
        productList = new ArrayList<>();
        product1 = new Product(parseDate("2019-03-11"), 77, "kids", "basketball", "pants", false, 36.67, "pants grey", "Kids basket ball pants in grey", 63, 1);
        product2 = new Product(parseDate("2019-08-15"), 75, "mens", "basketball", "pants", false, 58.68, "pants black", "Mens basket ball pants in black", 27, 2);


        product1.setProductId(1L);
        product2.setProductId(2L);

        mockProductRepo.save(product1);
        mockProductRepo.save(product2);

        productList.add(product1);
        productList.add(product2);

        mockProductRepo.saveAll(productList);

        when(mockProductRepo.findAll(Example.of(product))).thenReturn(productList);
//        when(mockProductRepo.findAll(Example.of(product), eq(any(PageRequest.class)))).thenReturn(productPage);
        when(mockProductRepo.save(any(Product.class))).thenReturn(product1);
        when(mockProductRepo.saveAll(anyList())).thenReturn(productList);
        when(mockProductRepo.existsById(anyLong())).thenReturn(true);
        when(mockProductRepo.findByPromotionFlagTrue()).thenReturn(productList);
        when(mockProductRepo.findTop2ByCreateDateNotNullOrderByCreateDateDesc()).thenReturn(productList);
        when(mockProductRepo.findTop4ByViewCountNotNullOrderByViewCountDesc()).thenReturn(productList);
    }

    @Test
    public void getAllProducts() {
        List<Product> testList = productService.getAllProducts(product);
        assertEquals(productList, testList);
    }

    @Test
    public void getAllProductsWithAuth() {
        List<Product> testList = productService.getAllProductsWithAuth(product);
        assertEquals(productList, testList);
    }

//    @Test
//    public void getAllProductsWithSort() {
//        when(mockProductRepo.findAll()).thenReturn(productList);
//        Page<Product> pageTest = productService.getAllProductsWithSort(product1, "string", 1);
//        assertEquals(productPage, pageTest);
//
//    }

        @Test
    public void getAllProductsWithSortWithAuth() {
        Page<Product> pageTest = productService.getAllProductsWithSortWithAuth(product, "string", 2);
        assertEquals(productPage, pageTest);

    }

    @Test
    public void findTop2ByCreateDateNotNullOrderByCreateDateDesc() {
        List<Product> testList = productService.getTop2ProductsOrderedByCreateDateDesc();
        assertEquals(productList, testList);
    }

    @Test
    public void getAllProductsWithPromotionFlagTrue() {
        List<Product> testList = productService.getAllProductsWithPromotionFlagTrue();
        assertEquals(productList, testList);
    }

    @Test
    public void getTop4ProductsOrderedByViewCountDesc() {
        List<Product> testList = productService.getTop4ProductsOrderedByViewCountDesc();
        assertEquals(productList, testList);
    }

    @Test
    public void getProduct() {
        when(mockProductRepo.findById(anyLong())).thenReturn(Optional.ofNullable(product1));
        Product productTest = productService.getProduct(1L);
        assertEquals(product1, productTest);
    }

    @Test(expected = ResponseStatusException.class)
    public void getProductThrowsIdDoesNotExistException() {
        when(mockProductRepo.existsById(anyLong())).thenReturn(false);
        productService.getProduct(300L);
    }

    @Test
    public void getProductWithAuth() {
        when(mockProductRepo.findById(anyLong())).thenReturn(Optional.ofNullable(product1));
        Product productTest = productService.getProductWithAuth(1L);
        assertEquals(product1, productTest);
    }

    @Test(expected = ResponseStatusException.class)
    public void getProductWithAuthThrowsIdDoesNotExistException() {
        when(mockProductRepo.existsById(anyLong())).thenReturn(false);
        productService.getProductWithAuth(300L);
    }

    @Test
    public void addProduct() {
        Product testProduct = productService.addProduct(product);
        assertEquals(product1, testProduct);
    }

    @Test
    public void addProducts() {
        List<Product> testProductList = productService.addProductList(productList);
        assertEquals(productList , testProductList);
    }

    @Test
    public void updateProduct() {
        Product testProduct = productService.updateProductById(1L, product1);
        assertEquals(product1, testProduct);
    }

    @Test(expected = ResponseStatusException.class)
    public void updateProductThrowsIdDoesNotExistException() {
        when(mockProductRepo.existsById(anyLong())).thenReturn(false);
        productService.updateProductById(300L, product);
    }


    @Test
    public void deleteProduct() {
        productService.deleteProduct(product1.getProductId());
        verify(mockProductRepo, times(1)).deleteById(1L);
    }

    @Test(expected = ResponseStatusException.class)
    public void deleteProductNoContent() {
        when(mockProductRepo.existsById(anyLong())).thenReturn(false);
        productService.deleteProduct(product1.getProductId());
    }





}