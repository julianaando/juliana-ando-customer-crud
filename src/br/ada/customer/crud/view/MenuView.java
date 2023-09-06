package br.ada.customer.crud.view;

import br.ada.customer.crud.factory.CustomerFactory;
import br.ada.customer.crud.factory.ProductFactory;

import java.util.Scanner;

public class MenuView {

    private Scanner scanner = new Scanner(System.in);

    public void show() {
        Integer option = 0;
        do {
            System.out.println("Escolha uma opção abaixo:");
            System.out.println("1 - Cliente");
            System.out.println("2 - Produto");
            System.out.println("3 - Pedido");
            System.out.println("0 - Sair");
            option = scanner.nextInt();
            if (option == 1) {
                customer();
            } else if (option == 2) {
                product();
            } else if (option == 3) {
                System.out.println("Opção ainda não disponível");
            } else if (option > 3 || option < 0) {
                System.out.println("Opção invalida.");
            }
        } while (option > 0);
    }

    public void customer() {
        CustomerView presentation = new CustomerView(
                CustomerFactory.createUseCase()
        );
        presentation.showMenu();
    }

    public void product() {
        ProductView presentation = new ProductView(
                ProductFactory.createUseCase()
        );
        presentation.showMenu();
    }

    public void order() {

    }

}
