package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.Product;

public interface IOrderChangeItemUseCase {

    /*
     * 1 - Pedido precisa estar com status == OrderStatus.OPEN
     * 2 - Trocar a quantidade que foi vendida desse produto
     * 3 - Lembrar de atualizar o banco através do repository
     */
    void changeAmount(Order order, Product product, Integer amount);
}
