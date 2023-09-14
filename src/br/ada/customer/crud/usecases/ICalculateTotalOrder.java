package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Order;

import java.math.BigDecimal;

public interface ICalculateTotalOrder {
    BigDecimal calculateTotalOrder(Order order);
}
