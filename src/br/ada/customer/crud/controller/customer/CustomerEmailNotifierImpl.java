package br.ada.customer.crud.controller.customer;

import br.ada.customer.crud.controller.common.SendEmail;
import br.ada.customer.crud.model.Customer;

public class CustomerEmailNotifierImpl implements ICustomerNotifier {

    private SendEmail sendEmail;

    public CustomerEmailNotifierImpl(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

    @Override
    public void notifyRegister(Customer customer) {
        sendEmail.send("comunicado@ada.com.br", customer.getEmail(), "Bem vindo!!");
    }

}
