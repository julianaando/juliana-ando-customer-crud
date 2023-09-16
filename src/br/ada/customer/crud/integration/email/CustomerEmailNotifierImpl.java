package br.ada.customer.crud.integration.email;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.INotifierUseCase;

public class CustomerEmailNotifierImpl implements INotifierUseCase<Customer> {

    private final SendEmail sendEmail;

    public CustomerEmailNotifierImpl(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

    @Override
    public void registered(Customer customer) {
        sendEmail.send("comunicado@ada.com.br", customer.getEmail(), "Bem vindo. Fique à vontade para realizar sua compra.");
        System.out.println();
    }

    @Override
    public void updated(Customer customer) {
        sendEmail.send("comunicado@ada.com.br", customer.getEmail(), "Suas informações foram atualizadas.");
        System.out.println();
    }

    @Override
    public void deleted(Customer customer) {
        sendEmail.send("comunicado@ada.com.br", customer.getEmail(), "Sentiremos sua falta e esperamos seu retorno logo.");
        System.out.println();
    }

}
