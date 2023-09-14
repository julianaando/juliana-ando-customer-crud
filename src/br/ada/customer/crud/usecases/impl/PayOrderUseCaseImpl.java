package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.INotifierOrderUseCase;
import br.ada.customer.crud.usecases.IPayOrderUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class PayOrderUseCaseImpl implements IPayOrderUseCase {

    private final OrderRepository repository;
    private final INotifierOrderUseCase emailNotifier;
    private final INotifierOrderUseCase smsNotifier;

    private ValidationStatusOrderImpl statusOrder;

    public PayOrderUseCaseImpl(OrderRepository repository, INotifierOrderUseCase emailNotifier, INotifierOrderUseCase smsNotifier) {
        this.repository = repository;
        this.emailNotifier = emailNotifier;
        this.smsNotifier = smsNotifier;
    }

    @Override
    public void pay(Order order) {
        statusOrder.validateStatus(order, OrderStatus.PENDING_PAYMENT);
        order.setStatus(OrderStatus.PAID);
        repository.save(order);
        emailNotifier.updatePayment(order);
        smsNotifier.updatePayment(order);
    }
}
