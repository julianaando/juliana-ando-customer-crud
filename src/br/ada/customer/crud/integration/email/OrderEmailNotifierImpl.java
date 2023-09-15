package br.ada.customer.crud.integration.email;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.usecases.INotifierOrderUseCase;

public class OrderEmailNotifierImpl implements INotifierOrderUseCase {

    private final SendEmail sendEmail;

    public OrderEmailNotifierImpl(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

    @Override
    public void shipped(Order order) {
        sendEmail.send("financeiro@juliana.com", order.getCustomer().getEmail(), "Seu pedido foi enviado com sucesso. Obrigada por comprar conosco!");
    }

    @Override
    public void updatePayment(Order order) {
        sendEmail.send("financeiro@juliana.com", order.getCustomer().getEmail(), "Seu pagamento foi aprovado e o pedido já está sendo preparado para envio.");
    }

    @Override
    public void pendingPayment(Order order) {
        sendEmail.send("financeiro@juliana.com", order.getCustomer().getEmail(), "Seu pagamento está pendente. Realize uma nova tentativa para concluir sua compra.");
    }
}
