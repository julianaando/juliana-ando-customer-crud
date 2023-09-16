package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderAddItemUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

import java.math.BigDecimal;

public class OrderAddItemUseCaseImpl implements IOrderAddItemUseCase {

    private final OrderRepository repository;

    public OrderAddItemUseCaseImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem addItem(Order order, Product product, BigDecimal price, Integer amount) {
        OrderItem newItem = newOrderItem(product, price, amount);
        order.getItems().add(newItem);
        repository.save(order);
        return newItem;
    }

    private OrderItem newOrderItem(Product product, BigDecimal price, Integer amount) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setSaleValue(price);
        orderItem.setAmount(amount);
        return orderItem;
    }

}
