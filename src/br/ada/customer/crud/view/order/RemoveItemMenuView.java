package br.ada.customer.crud.view.order;

import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;

public class RemoveItemMenuView extends AbstractMenuOptionView implements MenuOptionView {
    public static final String MENU_CODE = "4";
    public static final Integer MENU_ORDER = 4;

    public RemoveItemMenuView() {
        super(MENU_CODE, MENU_ORDER);
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Remover item do carrinho");
    }

    @Override
    public void selected() {
        System.out.println("Foi selecionada a opção de remover um item no carrinho");
    }
}
