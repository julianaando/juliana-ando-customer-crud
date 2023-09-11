package br.ada.customer.crud.view.order;

import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;

public class CreateOrderMenuView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "1";
    public static final Integer MENU_ORDER = 1;

    public CreateOrderMenuView() {
        super(MENU_CODE, MENU_ORDER);
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Criar um novo pedido");
    }

    @Override
    public void selected() {
        System.out.println("Criar um novo pedido foi selecionado.");
    }

}
