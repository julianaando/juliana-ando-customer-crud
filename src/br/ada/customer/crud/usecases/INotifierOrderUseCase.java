package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Order;

public interface INotifierOrderUseCase {

    void shipped(Order order);

    void updatePayment(Order order);

    void pendingPayment(Order order);

}
