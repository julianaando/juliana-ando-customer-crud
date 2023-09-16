package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderChangeItemUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderChangeItemUseCaseImpl implements IOrderChangeItemUseCase {
    private final OrderRepository repository;

    public OrderChangeItemUseCaseImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem changeAmount(Order order, Product product, Integer amount) {
        OrderItem orderItem = order.getItems().stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst()
                .orElse(null);

        if (orderItem != null) {
            orderItem.setAmount(amount);
            repository.update(order);
        }
        return orderItem;
    }
}
