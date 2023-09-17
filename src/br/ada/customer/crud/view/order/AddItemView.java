package br.ada.customer.crud.view.order;

import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;

public class AddItemView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "2";
    public static final Integer MENU_ORDER = 2;

    public AddItemView() {
        super(MENU_CODE, MENU_ORDER);
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Adicionar item");
    }

    @Override
    public void selected() {

    }

}
