package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IFindItem;
import br.ada.customer.crud.usecases.IOrderRemoveItemUseCase;
import br.ada.customer.crud.usecases.IValidationStatusOrder;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.model.OrderStatus;

public class OrderRemoveItemUseCaseImpl implements IOrderRemoveItemUseCase, IFindItem {
    private final OrderRepository repository;
    private final IValidationStatusOrder statusOrder;

    public OrderRemoveItemUseCaseImpl(OrderRepository repository, IValidationStatusOrder statusOrder) {
        this.repository = repository;
        this.statusOrder = statusOrder;
    }

    @Override
    public void removeItem(Order order, Product product) {
        statusOrder.validateStatus(order, OrderStatus.OPEN);
        OrderItem itemToRemove = findItem(order, product.getId());
        if(itemToRemove != null) {
            order.getItems().remove(itemToRemove);
            repository.update(order);
        }
    }
}
