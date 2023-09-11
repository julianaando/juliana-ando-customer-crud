package br.ada.customer.crud.view.order;

import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;

public class AddItemMenuView extends AbstractMenuOptionView implements MenuOptionView {

    public AddItemMenuView() {
        super("2", 2);
    }

    @Override
    public void render() {
        System.out.println("2 - Adicionar item");
    }

    @Override
    public void selected() {
        System.out.println("Foi selecionado a opção de adicionar um item ao pedido");
    }

}
