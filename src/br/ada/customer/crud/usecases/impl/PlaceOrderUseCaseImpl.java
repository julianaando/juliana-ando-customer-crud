package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.IPlaceOrderUseCase;
import br.ada.customer.crud.usecases.IValidationPlaceOrder;
import br.ada.customer.crud.usecases.IValidationStatusOrder;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class PlaceOrderUseCaseImpl implements IPlaceOrderUseCase {
    private final OrderRepository repository;
    private final IValidationStatusOrder statusOrder;
    private final IValidationPlaceOrder placeOrder;

    public PlaceOrderUseCaseImpl(
            OrderRepository repository,
            IValidationStatusOrder statusOrder,
            IValidationPlaceOrder placeOrder
    ) {
        this.repository = repository;
        this.statusOrder = statusOrder;
        this.placeOrder = placeOrder;
    }

    @Override
    public void placeOrder(Order order) {
        statusOrder.validateStatus(order);
        order.setStatus(OrderStatus.PENDING_PAYMENT);
        repository.update(order);
    }

}
