package br.ada.customer.crud.controller.product;

import br.ada.customer.crud.controller.common.CrudRepository;

import java.util.List;

public interface ProductRepository
        extends CrudRepository<Product, String> {

    List<Product> findByDescription(String description);

}
