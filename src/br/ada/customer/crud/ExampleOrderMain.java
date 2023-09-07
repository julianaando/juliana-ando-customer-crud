package br.ada.customer.crud;

import br.ada.customer.crud.factory.CustomerFactory;
import br.ada.customer.crud.factory.OrderFactory;
import br.ada.customer.crud.factory.ProductFactory;
import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.ICustomerUseCase;
import br.ada.customer.crud.usecases.IOrderUseCase;
import br.ada.customer.crud.usecases.IProductUseCase;

import java.math.BigDecimal;

public class ExampleOrderMain {

    public static void main(String[] args) {
        IProductUseCase productUseCase = ProductFactory.createUseCase();
        ICustomerUseCase customerUseCase = CustomerFactory.createUseCase();
        IOrderUseCase orderUseCase = OrderFactory.createUseCase();

        Customer customer = new Customer();
        customer.setName("William");
        customerUseCase.create(customer);

        Product productOne = new Product();
        productOne.setDescription("023");
        productUseCase.create(productOne);

        Product productTwo = new Product();
        productTwo.setDescription("1546");
        productUseCase.create(productTwo);

        Product productThree = new Product();
        productThree.setDescription("516");
        productUseCase.create(productThree);

        Order order = orderUseCase.create(customer);
        orderUseCase.addItem(order, productOne, BigDecimal.TEN, 1);
        orderUseCase.addItem(order, productTwo, BigDecimal.TEN, 2);
        orderUseCase.changeAmount(order, productTwo, 5);
        orderUseCase.removeItem(order, productOne);
        orderUseCase.placeOrder(order);
        orderUseCase.pay(order);
        orderUseCase.shipping(order);
    }

}
