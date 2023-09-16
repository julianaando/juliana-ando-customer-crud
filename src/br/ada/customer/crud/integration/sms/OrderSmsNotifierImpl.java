package br.ada.customer.crud.integration.sms;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.usecases.INotifierOrderUseCase;

public class OrderSmsNotifierImpl implements INotifierOrderUseCase {
    private final SendSms sendSms;

    public OrderSmsNotifierImpl(SendSms sendSms) {
        this.sendSms = sendSms;
    }

    @Override
    public void shipped(Order order) {
        sendSms.send("12345", order.getCustomer().getTelephone(), "Seu pedido foi enviado com sucesso. Obrigada por comprar conosco!");
        System.out.println();
    }

    @Override
    public void updatePayment(Order order) {
        sendSms.send("12345", order.getCustomer().getTelephone(), "Seu pagamento foi aprovado e o pedido já está sendo preparado para envio.");
        System.out.println();
    }

    @Override
    public void pendingPayment(Order order) {
        sendSms.send("12345", order.getCustomer().getTelephone(), "Seu pagamento está pendente. Realize uma nova tentativa para concluir sua compra.");
        System.out.println();
    }

}
