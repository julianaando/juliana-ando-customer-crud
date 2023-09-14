package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderItemUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

import java.math.BigDecimal;

public class OrderItemUseCaseImpl implements IOrderItemUseCase {

    private final OrderRepository repository;

    public OrderItemUseCaseImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem addItem(Order order, Product product, BigDecimal price, Integer amount) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setSaleValue(price);
        orderItem.setAmount(amount);
        order.getItems().add(orderItem);
        repository.update(order);
        return orderItem;
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
