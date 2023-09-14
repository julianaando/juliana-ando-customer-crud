package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.INotifierOrderUseCase;
import br.ada.customer.crud.usecases.IShippingOrderUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderShippingUseCaseImpl implements IShippingOrderUseCase {

    private final OrderRepository repository;
    private final INotifierOrderUseCase emailNotifier;
    private final INotifierOrderUseCase smsNotifier;
    private ValidationStatusOrderImpl statusOrder;



    public OrderShippingUseCaseImpl(
            OrderRepository repository,
            INotifierOrderUseCase emailNotifier,
            INotifierOrderUseCase smsNotifier
    ) {
        this.repository = repository;
        this.emailNotifier = emailNotifier;
        this.smsNotifier = smsNotifier;
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
