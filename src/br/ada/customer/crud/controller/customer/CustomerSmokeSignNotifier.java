package br.ada.customer.crud.controller.customer;

import br.ada.customer.crud.model.Customer;

//Sinal de fumaça
public class CustomerSmokeSignNotifier implements ICustomerNotifier {

    @Override
    public void notifyRegister(Customer customer) {
        System.out.println("Acendendo o fogo....");
    }

}
