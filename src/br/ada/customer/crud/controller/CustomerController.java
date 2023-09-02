package br.ada.customer.crud.controller;

import br.ada.customer.crud.model.Customer;

import java.util.Scanner;

public class CustomerController {

    private CustomerRepository repository;//Dependência

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do cliente:");
        String name = scanner.nextLine();
        System.out.println("Informe o cpf do cliente:");
        String document = scanner.nextLine();

        Customer customer = new Customer();
        customer.setId(1l);
        customer.setName(name);
        customer.setDocument(document);

        try {
            repository.save(customer);
        } catch(CustomerRepositoryException exception) {
            System.out.println("Ocorreu um erro interno. Por favor, tente novamente.");
        }
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o document do cliente:");
        String document = scanner.nextLine();

        Customer customerRead = repository.readByDocument(document);
        System.out.println("Encontrado o cliente: "+ customerRead.getName());
    }

    public void update() {

    }

    public void delete() {

    }

}
