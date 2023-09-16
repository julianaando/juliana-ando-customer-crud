package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;

import java.util.List;

public interface IFindItem {
    default OrderItem findItem(Order order, Long productId) {
        List<OrderItem> items = order.getItems();
        OrderItem itemToFind = null;

        for (OrderItem item : items) {
            if (item.getProduct().getId().equals(productId)) {
                itemToFind = item;
                break;
            }
        }
        return itemToFind;
    }
}
