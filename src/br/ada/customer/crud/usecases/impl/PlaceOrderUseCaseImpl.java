package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.INotifierOrderUseCase;
import br.ada.customer.crud.usecases.IPlaceOrderUseCase;
import br.ada.customer.crud.usecases.IValidationPlaceOrder;
import br.ada.customer.crud.usecases.IValidationStatusOrder;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class PlaceOrderUseCaseImpl implements IPlaceOrderUseCase {
    private final OrderRepository repository;
    private final IValidationStatusOrder statusOrder;
    private final IValidationPlaceOrder placeOrder;
    private final INotifierOrderUseCase emailNotifier;
    private final INotifierOrderUseCase smsNotifier;

    public PlaceOrderUseCaseImpl(
            OrderRepository repository,
            IValidationStatusOrder statusOrder,
            IValidationPlaceOrder placeOrder,
            INotifierOrderUseCase emailNotifier,
            INotifierOrderUseCase smsNotifier) {
        this.repository = repository;
        this.statusOrder = statusOrder;
        this.placeOrder = placeOrder;
        this.emailNotifier = emailNotifier;
        this.smsNotifier = smsNotifier;
    }

    @Override
    public void placeOrder(Order order) {
        placeOrder.validateHasItem(order);
        statusOrder.validateStatus(order, OrderStatus.OPEN);
        placeOrder.validateCart(order);
        placeOrder.validateTotal(order);
        order.setStatus(OrderStatus.PENDING_PAYMENT);
        repository.save(order);
        emailNotifier.pendingPayment(order);
        smsNotifier.pendingPayment(order);
    }

}
