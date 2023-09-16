package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.usecases.ICalculateTotalOrder;
import br.ada.customer.crud.usecases.IValidationPlaceOrder;

import java.math.BigDecimal;

public class ValidationPlaceOrderImpl implements IValidationPlaceOrder, ICalculateTotalOrder {
    @Override
    public void validateCart(Order order) {
        if (order.getItems().isEmpty() || order.getItems() == null) {
            throw new IllegalStateException("O carrinho está vazio!");
        }
    }

    @Override
    public void validateTotal(Order order) {
        if (calculateTotalOrder(order).compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("O valor total do pedido deve ser maior que zero!");
        }
    }

    @Override
    public BigDecimal calculateTotalOrder(Order order) {
        BigDecimal totalOrder = BigDecimal.ZERO;

        for (OrderItem item : order.getItems()) {
            totalOrder = totalOrder.add(item.getSaleValue());
        }

        return totalOrder;
    }

    @Override
    public void validateHasItem(Order order) {
        if (order.getItems().isEmpty()) {
            throw new IllegalStateException("Adicione itens ao carrinho para concluir a compra!");
        }
    }
}
