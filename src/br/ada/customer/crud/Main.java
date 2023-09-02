package br.ada.customer.crud;

import br.ada.customer.crud.controller.CustomerFileDatabase;
import br.ada.customer.crud.controller.CustomerController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao cadastro.");
        CustomerController controller = new CustomerController(
                new CustomerFileDatabase()
        );

        do {
            System.out.println("Escolha a opção desejada:");
            System.out.println("1 - Criar cliente");
            System.out.println("2 - Buscar cliente");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Excluir cliente");
            Scanner scanner = new Scanner(System.in);
            Integer option = scanner.nextInt();

            switch (option) {
                case 1:
                    controller.create();
                    break;
                case 2:
                    controller.read();
                    break;
                case 3:
                    controller.update();
                    break;
                case 4:
                    controller.delete();
                    break;
            }
        } while (1 != 2);
    }
}
