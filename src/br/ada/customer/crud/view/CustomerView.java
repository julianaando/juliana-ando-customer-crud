package br.ada.customer.crud.view;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.usecases.ICustomerUseCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomerView {

    private Scanner scanner = new Scanner(System.in);
    private String datePattern = "dd/MM/yyyy";
    private ICustomerUseCase useCase;

    public CustomerView(ICustomerUseCase customerUseCase) {
        this.useCase = customerUseCase;
    }

    public void showMenu() {
        System.out.println("Escolha uma opção abaixo:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Consultar por documento");
        System.out.println("4 - Atualizar");
        System.out.println("5 - Deletar");
        System.out.println("0 - Voltar");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                create();
                break;
            case "2":
                listAll();
                break;
            case "3":
                findByDocument();
                break;
            case "4":
                update();
                break;
            case "5":
                delete();
                break;
            case "0":
                break;
            default:
                System.out.println("Opção invalida");
                showMenu();
                break;
        }
    }

    public void list(List<Customer> customers) {
        showHeader();
        for (Customer customer : customers) {
            showCustomer(customer);
        }
    }

    public void create() {
        Customer customer = inputData();
        useCase.create(customer);
    }

    public void listAll() {
        List<Customer> customers = useCase.list();
        list(customers);
    }

    public void findByDocument() {
        System.out.println("Informe o documento:");
        String document = scanner.nextLine();
        Customer customer = useCase.findByDocument(document);
        showHeader();
        showCustomer(customer);
    }

    public void update() {
        System.out.println("Esolha o cliente a ser atualizado");
        listAll();
        System.out.println("Informe o id:");
        Long id = scanner.nextLong();
        Customer customer = inputData();
        customer.setId(id);
        useCase.update(customer);
    }

    public void delete() {
        System.out.println("Esolha o cliente a ser excluído");
        listAll();
        System.out.println("Informe o id:");
        Long id = scanner.nextLong();
        Customer deleted = useCase.delete(id);
        System.out.println("Cliente apagado");
        showHeader();
        showCustomer(deleted);
    }

    public Customer inputData() {
        Customer customer = new Customer();
        System.out.println("Informe o nome:");
        String name = scanner.nextLine();
        customer.setName(name);
        System.out.println("Informe o documento:");
        String document = scanner.nextLine();
        customer.setDocument(document);
        System.out.println("Informe o email(separe com virgula):");
        String email = scanner.nextLine();
        String[] emails = email.split(",");
        customer.setEmail(Arrays.asList(emails));
        System.out.println("Informe o telefone(separe com virgula):");
        String telephone = scanner.nextLine();
        String[] telephones = telephone.split(",");
        customer.setTelephone(Arrays.asList(telephones));
        System.out.println("Informe a data de nascimento(dd/mm/aaaa):");
        String date = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(datePattern));
        customer.setBirthDate(birthDate);
        return customer;
    }

    public void showHeader() {
        System.out.println("Id | Nome | Document | Email | Telefone | Data de nascimento");
    }

    public void showCustomer(Customer customer) {
        System.out.print(customer.getId());
        System.out.print(" | ");
        System.out.print(customer.getName());
        System.out.print(" | ");
        System.out.print(customer.getDocument());
        System.out.print(" | ");
        System.out.print(customer.getEmail());
        System.out.print(" | ");
        System.out.print(customer.getTelephone());
        System.out.print(" | ");
        System.out.print(customer.getBirthDate());
        System.out.print(" | ");
        System.out.println();
    }
}
