package br.btg.customer.crud.controller;

import br.btg.customer.crud.model.Customer;

public interface CustomerRepository {

    void save(Customer customer) throws CustomerRepositoryException;

    Customer read();

    Customer readByDocument(String document);

    void update(Customer customer);

    void delete(Customer customer);

}
