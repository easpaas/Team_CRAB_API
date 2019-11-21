package io.catalyte.training.services;

import io.catalyte.training.domains.customers.Customer;
import io.catalyte.training.repositories.CustomerRepository;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers(Customer customer) {
        Example<Customer> customerExample = Example.of(customer);
        return customerRepository.findAll(customerExample);
    }

    @Override
    public Page<Customer> getAllCustomersWithSort(Customer customer, String sortBy, int pages) {
        Example<Customer> customerExample = Example.of(customer);
        return customerRepository.findAll(customerExample, PageRequest.of(0, pages, Sort.by(Sort.Direction.DESC, sortBy)));
    }

    @Override
    public Customer getCustomer(Long customerId) {
        if(customerRepository.existsById(customerId)) {
            return customerRepository.findById(customerId).orElse(null);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer editCustomerById(Long customerId, Customer customer) {
        if(customerRepository.existsById(customerId)){
            customer.setCustomerId(customerId);
            return customerRepository.save(customer);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteCustomer(Long customerId) {
        if(customerRepository.existsById(customerId)){
            customerRepository.deleteById(customerId);
        } else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
}
