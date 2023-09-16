package br.ada.customer.crud.view.order;

import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;

public class PlaceOrderMenuView extends AbstractMenuOptionView implements MenuOptionView {
    public static final String MENU_CODE = "5";
    public static final Integer MENU_ORDER = 5;

    public PlaceOrderMenuView() {
        super(MENU_CODE, MENU_ORDER);
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Fechar pedido");
    }

    @Override
    public void selected() {
        System.out.println("Foi selecionada a opção de fechar o pedido");
    }
}
