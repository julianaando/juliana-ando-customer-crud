package br.ada.customer.crud.controller.customer;

import br.ada.customer.crud.controller.common.RepositoryException;
import br.ada.customer.crud.model.Customer;

import java.util.Scanner;

public class CustomerController {

    private CustomerRepository repository;//Dependência
    private ICustomerNotifier notifier;//Dependência

    public CustomerController(
            CustomerRepository repository,
            ICustomerNotifier notifier
    ) {
        this.repository = repository;
        this.notifier = notifier;
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
            notifier.notifyRegister(customer);
        } catch (RepositoryException exception) {
            System.out.println("Ocorreu um erro interno. Por favor, tente novamente.");
        }
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o document do cliente:");
        String document = scanner.nextLine();

        Customer customerRead = repository.findByDocument(document);
        System.out.println("Encontrado o cliente: " + customerRead.getName());
    }

    public void update() {

    }

    public void delete() {

    }

}
