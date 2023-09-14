package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.IValidationStatusOrder;

public class ValidationStatusOrderImpl implements IValidationStatusOrder {
    @Override
    public void validateStatus(Order order, OrderStatus status) {
        OrderStatus currentStatus = order.getStatus();

        if (order.getStatus() != currentStatus) {
            throw new IllegalStateException("Pedido inválido! Consulte o pagamento e tente novamente");
        }
    }
}
