package br.ada.customer.crud.controller;

import br.ada.customer.crud.model.Customer;

public class CustomerMemoryDatabase implements CustomerRepository {

    private Customer customer;

    @Override
    public void save(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Customer read() {
        return this.customer;
    }

    @Override
    public Customer readByDocument(String document) {
        return this.customer;
    }

    @Override
    public void update(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void delete(Customer customer) {
        this.customer = null;
    }

}
