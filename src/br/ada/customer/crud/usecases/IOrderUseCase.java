package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Customer;
import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.Product;

import java.math.BigDecimal;

public interface IOrderUseCase {

    /*
     * 1 - Inicia um novo pedido para o cliente
     * 2 - Pedido deve iniciar com status igual a OrderStatus.OPEN
     * 3 - Lembrar de atualizar o banco através do repository
     */
    Order create(Customer customer);

    /*
     * 1 - Pedido precisa estar com status == OrderStatus.OPEN
     * 2 - Lembrar de atualizar o banco através do repository
     */
    OrderItem addItem(Order order, Product product, BigDecimal price, Integer amount);

    /*
     * 1 - Pedido precisa estar com status == OrderStatus.OPEN
     * 2 - Trocar a quantidade que foi vendida desse produto
     * 3 - Lembrar de atualizar o banco através do repository
     */
    OrderItem changeAmount(Order order, Product product, Integer amount);

    /*
     * 1 - Pedido precisa estar com status == OrderStatus.OPEN
     * 2 - Lembrar de atualizar o banco através do repository
     */
    void removeItem(Order order, OrderItem item);

    /*
     * 1 - Pedido precisa estar com status == OrderStatus.OPEN
     * 2 - Pedido precisa ter no mínimo um item
     * 3 - Valor deve ser maior que zero
     * 4 - Notificar o cliente que esta aguardando o pagamento
     * 5 - Pedido deve passar a ter o status igual OrderStatus.PENDING_PAYMENT
     */
    void placeOrder(Order order);

    /*
     * 1 - Pedido precisa estar com status == OrderStatus.PENDING_PAYMENT
     * 2 - Pedido deve passar a ter o status igual a OrderStatus.PAID
     * 3 - Notificar o cliente sobre o pagamento com sucesso
     */
    void pay(Order order);

    /*
     * 1 - Entrega só pode acontecer depois do pedido ter sido pago (order.status == OrderStatus.PAID)
     * 2 - Pedido deve passar a ter o status igual a OrderStatus.FINISH
     * 3 - Notificar o cliente e agradecer pela compra
     */
    void shipping(Order order);

}
