package br.ada.customer.crud.view;

import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IProductUseCase;

import java.util.List;
import java.util.Scanner;

public class ProductView {

    private Scanner scanner = new Scanner(System.in);
    private IProductUseCase useCase;

    public ProductView(IProductUseCase useCase) {
        this.useCase = useCase;
    }

    public void showMenu() {
        System.out.println("Escolha uma opção abaixo:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Consultar por codigo de barra");
        System.out.println("4 - Consultar por descrição");
        System.out.println("5 - Atualizar");
        System.out.println("6 - Deletar");
        System.out.println("0 - Voltar");
        Integer option = scanner.nextInt();
        switch (option) {
            case 1:
                create();
                break;
            case 2:
                listAll();
                break;
            case 3:
                findByBarcode();
                break;
            case 4:
                findByDescription();
                break;
            case 5:
                update();
                break;
            case 6:
                delete();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção invalida");
                showMenu();
                break;
        }
    }

    public void list(List<Product> products) {
        showHeader();
        for (Product product : products) {
            showProduct(product);
        }
    }

    public void create() {
        Product product = inputData();
        useCase.create(product);
    }

    public void listAll() {
        List<Product> products = useCase.listAll();
        showHeader();
        list(products);
    }

    public void findByBarcode() {
        System.out.println("Informe o código de barra:");
        String document = scanner.nextLine();
        Product product = useCase.findByBarcode(document);
        showHeader();
        showProduct(product);
    }

    public void findByDescription() {
        System.out.println("Informe a descrição:");
        String description = scanner.nextLine();
        List<Product> products = useCase.findByDescription(description);
        showHeader();
        list(products);
    }

    public void update() {
        System.out.println("Esolha o produto a ser atualizado");
        listAll();
        System.out.println("Informe o id:");
        Long id = scanner.nextLong();
        Product product = inputData();
        product.setId(id);
        useCase.update(product);
    }

    public void delete() {
        System.out.println("Esolha o produto a ser excluído");
        listAll();
        System.out.println("Informe o id:");
        Long id = scanner.nextLong();
        Product deleted = useCase.delete(id);
        System.out.println("Produto apagado");
        showHeader();
        showProduct(deleted);
    }

    public Product inputData() {
        Product product = new Product();
        System.out.println("Informe a descrição:");
        String description = scanner.nextLine();
        product.setDescription(description);
        System.out.println("Informe código de barra:");
        String barcode = scanner.nextLine();
        product.setBarcode(barcode);
        return product;
    }

    public void showHeader() {
        System.out.print("| ");
        System.out.print(padRight("Id", 5));
        System.out.print("| ");
        System.out.print(padRight("Description", 40));
        System.out.print("| ");
        System.out.print(padRight("Código de barra", 40));
        System.out.println(" |");
    }

    public void showProduct(Product product) {
        System.out.print("| ");
        System.out.print(padRight(product.getId().toString(), 5));
        System.out.print("| ");
        System.out.print(padRight(product.getDescription(), 40));
        System.out.print("| ");
        System.out.print(padRight(product.getBarcode(), 40));
        System.out.print("| ");
        System.out.println();
    }

    public String padRight(String value, Integer size) {
        return String.format("%-" + value + "s", size);
    }

}
