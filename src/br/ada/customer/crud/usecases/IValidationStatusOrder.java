package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;

public interface IValidationStatusOrder {
    void validateStatus(Order order, OrderStatus status);
}
