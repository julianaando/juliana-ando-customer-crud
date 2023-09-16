package br.ada.customer.crud;

import br.ada.customer.crud.factory.CustomerFactory;
import br.ada.customer.crud.factory.OrderFactory;
import br.ada.customer.crud.factory.ProductFactory;
import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

public class ExampleOrderMain {

    public static void main(String[] args) {
        IProductUseCase productUseCase = ProductFactory.createUseCase();
        ICustomerUseCase customerUseCase = CustomerFactory.createUseCase();
        ICreateOrderUseCase orderUseCase = OrderFactory.createUseCase();
        IOrderAddItemUseCase orderAddItemUseCase = OrderFactory.orderAddItemUseCase();
        IOrderChangeItemUseCase orderChangeItemUseCase = OrderFactory.orderChangeItemUseCase();
        IOrderRemoveItemUseCase orderRemoveItemUseCase = OrderFactory.orderRemoveItemUseCase();
        IPlaceOrderUseCase orderPlaceUseCase = OrderFactory.placeOrderUseCase();
        IPayOrderUseCase orderPayUseCase = OrderFactory.payOrderUseCase();
        IShippingOrderUseCase orderShipping = OrderFactory.shippingUseCase();

        Customer customer = new Customer();
        customer.setName("Juliana");
        customer.setDocument("12345678901");
        customer.setTelephone(Collections.singletonList("40028922"));
        customer.setEmail(Collections.singletonList("juandocezare@gmail.com"));
        customer.setBirthDate(LocalDate.ofEpochDay(8/29/1996));
        customerUseCase.create(customer);

        Product productOne = new Product();
        productOne.setDescription("Coca-cola");
        productUseCase.create(productOne);

        Product productTwo = new Product();
        productTwo.setDescription("Pizza");
        productUseCase.create(productTwo);

        Order order = orderUseCase.create(customer);
        orderAddItemUseCase.addItem(order, productOne, BigDecimal.TEN, 1);
        orderAddItemUseCase.addItem(order, productTwo, BigDecimal.TEN, 2);
        orderChangeItemUseCase.changeAmount(order, productTwo, 5);
        orderRemoveItemUseCase.removeItem(order, productOne);
        orderPlaceUseCase.placeOrder(order);
        orderPayUseCase.pay(order);
        orderShipping.shipping(order);
    }

}
