package br.ada.customer.crud.controller.customer;

import br.ada.customer.crud.model.Customer;

public interface ICustomerNotifier {

    void notifyRegister(Customer customer);

}
