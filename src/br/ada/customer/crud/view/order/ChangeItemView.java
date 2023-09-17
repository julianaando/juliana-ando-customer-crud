package br.ada.customer.crud.view.order;

import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;

public class ChangeItemView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "3";
    public static final Integer MENU_ORDER = 3;

    public ChangeItemView() {
        super(MENU_CODE, MENU_ORDER);
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Alterar item do carrinho");
    }

    @Override
    public void selected() {
        System.out.println("Foi selecionada a opção de alterar um item no carrinho");
    }
}
