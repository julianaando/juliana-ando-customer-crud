package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.IValidationStatusOrder;

public class ValidationStatusOrderImpl implements IValidationStatusOrder {
    @Override
    public void validateStatus(Order order, OrderStatus status) {
        OrderStatus currentStatus = order.getStatus();

        if (order.getStatus() != currentStatus) {
            throw new IllegalStateException("O status " + currentStatus + " do pedido não permite essa operação!");
        }
    }

    @Override
    public void validatePayment(Order order) {
        if (order.getStatus() != OrderStatus.PENDING_PAYMENT) {
            throw new IllegalStateException("Efetue o pagamento do pedido para concluir a compra!");
        }
    }
}
