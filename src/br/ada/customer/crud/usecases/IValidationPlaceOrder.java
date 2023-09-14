package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Order;

public interface IValidationPlaceOrder {
    void validateCart(Order order);
    void validateTotal(Order order);
}
