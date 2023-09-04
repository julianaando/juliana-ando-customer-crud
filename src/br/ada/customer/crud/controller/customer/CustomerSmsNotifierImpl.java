package br.ada.customer.crud.controller.customer;

import br.ada.customer.crud.controller.common.SendSms;
import br.ada.customer.crud.model.Customer;

public class CustomerSmsNotifierImpl implements ICustomerNotifier {

    private SendSms sendSms;

    public CustomerSmsNotifierImpl(SendSms sendSms) {
        this.sendSms = sendSms;
    }

    @Override
    public void notifyRegister(Customer customer) {
        sendSms.send("151641651658", customer.getTelephone(), "Bem vindo!!");
    }

}
