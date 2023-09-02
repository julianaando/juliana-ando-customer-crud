package br.ada.customer.crud.controller;

import br.ada.customer.crud.model.Customer;

public interface CustomerRepository {

    void save(Customer customer) throws CustomerRepositoryException;

    Customer read();

    Customer readByDocument(String document);

    void update(Customer customer);

    void delete(Customer customer);

}
