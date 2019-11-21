package io.catalyte.training.services;

import io.catalyte.training.domains.customers.Customer;
import io.catalyte.training.domains.products.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers(Customer customer);

    Page<Customer> getAllCustomersWithSort(Customer customer, String sortBy, int pages);

    Customer getCustomer(Long customerId);

    Customer getCustomerByEmail(String email);

    Customer addCustomer(Customer customer);

    Customer editCustomerById(Long customerId, Customer customer);

    void deleteCustomer(Long customerId);

}
