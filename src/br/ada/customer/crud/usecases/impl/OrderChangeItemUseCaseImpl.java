package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IFindItem;
import br.ada.customer.crud.usecases.IOrderChangeItemUseCase;
import br.ada.customer.crud.usecases.IValidationStatusOrder;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderChangeItemUseCaseImpl implements IOrderChangeItemUseCase, IFindItem {
    private final OrderRepository repository;
    private final IValidationStatusOrder statusOrder;


    public OrderChangeItemUseCaseImpl(OrderRepository repository, IValidationStatusOrder statusOrder) {
        this.repository = repository;
        this.statusOrder = statusOrder;
    }

    @Override
    public void changeAmount(Order order, Product product, Integer amount) {
        statusOrder.validateStatus(order, OrderStatus.OPEN);
        OrderItem itemToChange = findItem(order, product.getId());
        if(itemToChange != null) {
            itemToChange.setAmount(amount);
            repository.update(order);
        }
    }

}
