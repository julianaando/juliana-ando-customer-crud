package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderRemoveItemUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderRemoveItemUseCaseImpl implements IOrderRemoveItemUseCase {
    private final OrderRepository repository;

    public OrderRemoveItemUseCaseImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void removeItem(Order order, Product product) {
        OrderItem orderItem = order.getItems().stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst()
                .orElse(null);

        if (orderItem != null) {
            order.getItems().remove(orderItem);
            repository.update(order);
        }
    }
}
