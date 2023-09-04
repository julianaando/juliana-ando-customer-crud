package br.ada.customer.crud.controller.customer;

import br.ada.customer.crud.controller.common.RepositoryException;
import br.ada.customer.crud.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerMemoryDatabase implements CustomerRepository {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public List<Customer> listAll() {
        return Collections.unmodifiableList(this.customers);
    }

    @Override
    public Customer findById(Long id) throws RepositoryException {
        return null;
    }

    @Override
    public Customer findByDocument(String document) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

}
