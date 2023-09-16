package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.INotifierOrderUseCase;
import br.ada.customer.crud.usecases.IPayOrderUseCase;
import br.ada.customer.crud.usecases.IValidationStatusOrder;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class PayOrderUseCaseImpl implements IPayOrderUseCase {

    private final OrderRepository repository;
    private final INotifierOrderUseCase emailNotifier;
    private final INotifierOrderUseCase smsNotifier;
    private final IValidationStatusOrder statusOrder;

    public PayOrderUseCaseImpl(
            OrderRepository repository,
            INotifierOrderUseCase emailNotifier,
            INotifierOrderUseCase smsNotifier,
            IValidationStatusOrder statusOrder) {
        this.repository = repository;
        this.emailNotifier = emailNotifier;
        this.smsNotifier = smsNotifier;
        this.statusOrder = statusOrder;
    }

    @Override
    public void pay(Order order) {
        statusOrder.validatePayment(order);
        order.setStatus(OrderStatus.PAID);
        repository.save(order);
        emailNotifier.updatePayment(order);
        smsNotifier.updatePayment(order);
    }
}
