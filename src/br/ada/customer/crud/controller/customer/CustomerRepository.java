package br.ada.customer.crud.controller.customer;

import br.ada.customer.crud.controller.common.CrudRepository;
import br.ada.customer.crud.model.Customer;

public interface CustomerRepository
        extends CrudRepository<Customer, Long> {

    Customer findByDocument(String document);


}
