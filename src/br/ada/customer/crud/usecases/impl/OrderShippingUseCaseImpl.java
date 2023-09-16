package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.INotifierOrderUseCase;
import br.ada.customer.crud.usecases.IShippingOrderUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.usecases.IValidationStatusOrder;

public class OrderShippingUseCaseImpl implements IShippingOrderUseCase {

    private final OrderRepository repository;
    private final INotifierOrderUseCase emailNotifier;
    private final INotifierOrderUseCase smsNotifier;
    private final IValidationStatusOrder statusOrder;

    public OrderShippingUseCaseImpl(
            OrderRepository repository,
            INotifierOrderUseCase emailNotifier,
            INotifierOrderUseCase smsNotifier,
            IValidationStatusOrder statusOrder
    ) {
        this.repository = repository;
        this.emailNotifier = emailNotifier;
        this.smsNotifier = smsNotifier;
        this.statusOrder = statusOrder;
    }

    @Override
    public void shipping(Order order) {
        statusOrder.validateStatus(order, OrderStatus.PAID);
        order.setStatus(OrderStatus.FINISH);
        repository.save(order);
        emailNotifier.shipped(order);
        smsNotifier.shipped(order);
    }

}
