package io.catalyte.training.services;

import io.catalyte.training.domains.customers.Customer;
import io.catalyte.training.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @Mock
    CustomerRepository mockCustomerRepo;

    Customer customer;
    Customer customer1;
    Customer customer2;

    List<Customer> customerList;

    Page<Customer> customerPage;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Before
    public void before(){
        customer = new Customer();
        customerList = new ArrayList<>();

        customer1 = new Customer("CUSTOMER", "Andre", "Wilkins", "test@email.com", "password", "(903) 283-8342", "1782 Luspub Mill", "Jophubro", "NV", "14634", "USA", "378912708940614", "05/24", "404");
        customer2 = new Customer("CUSTOMER", "Allen", "Griffin", "bume@huin.it", "password", "(309) 566-2804", "841 Dutu Boulevard", "Evilofcaf", "ME", "71600", "USA", "343309350665775", "10/21", "430");

        customer1.setCustomerId(1L);
        customer2.setCustomerId(2L);


        customerList.add(customer1);
        customerList.add(customer2);

        mockCustomerRepo.save(customer1);
        mockCustomerRepo.save(customer2);

        when(mockCustomerRepo.findAll(Example.of(customer))).thenReturn(customerList);
        when(mockCustomerRepo.save(any(Customer.class))).thenReturn(customer1);
        when(mockCustomerRepo.existsById(anyLong())).thenReturn(true);

    }

    @Test
    public void getAllCustomers() {
        List<Customer> testList = customerService.getAllCustomers(customer);
        assertEquals(customerList, testList);
    }

    @Test
    public void getAllCustomersWithSort() {
        Page<Customer> pageTest = customerService.getAllCustomersWithSort(customer, "string", 1);
        assertEquals(customerPage, pageTest);

    }

    @Test
    public void getCustomer() {
        when(mockCustomerRepo.findById(anyLong())).thenReturn(Optional.ofNullable(customer1));
        Customer customerTest = customerService.getCustomer(1L);
        assertEquals(customer1, customerTest);
    }

    @Test(expected = ResponseStatusException.class)
    public void getCustomerIdDoesNotExist() {
        when(mockCustomerRepo.existsById(anyLong())).thenReturn(false);
        customerService.getCustomer(1L);
    }

    @Test
    public void getCustomerByEmail() {
        when(mockCustomerRepo.findByEmail(anyString())).thenReturn(customer1);
        Customer customerTest = customerService.getCustomerByEmail("test@email.com");
        assertEquals(customer1, customerTest);
    }

    @Test(expected = ResponseStatusException.class)
    public void getCustomerThrowsIdDoesNotExistException() {
        when(mockCustomerRepo.existsById(anyLong())).thenReturn(false);
        customerService.getCustomer(300L);
    }

    @Test
    public void addCustomer() {
        Customer customerTest = customerService.addCustomer(customer);
        assertEquals(customer1, customerTest);
    }

    @Test
    public void editCustomerById() {
        Customer customerTest = customerService.editCustomerById(1L, customer);
        assertEquals(customer1, customerTest);
    }

    @Test(expected = ResponseStatusException.class)
    public void editCustomerIdDoesNotExist() {
        when(mockCustomerRepo.existsById(anyLong())).thenReturn(false);
        customerService.editCustomerById(300L, customer);
    }

    @Test
    public void deleteCustomer() {
        customerService.deleteCustomer(customer1.getCustomerId());
        verify(mockCustomerRepo, times(1)).deleteById(1L);
    }

    @Test(expected = ResponseStatusException.class)
    public void deleteCustomerNoContent() {
        when(mockCustomerRepo.existsById(anyLong())).thenReturn(false);
        customerService.deleteCustomer(customer1.getCustomerId());
    }
}