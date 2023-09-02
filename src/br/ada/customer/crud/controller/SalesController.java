package br.ada.customer.crud.controller;

import br.ada.customer.crud.model.Customer;

public class SalesController {

    private CustomerRepository customerRepository;//Dependência

    public void vender() {
        System.out.println("Informe o CPF do cliente:");
        //Ler
        Customer customer = customerRepository.read();
    }

}
