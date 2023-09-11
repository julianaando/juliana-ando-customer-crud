package br.ada.customer.crud.view.order;

import br.ada.customer.crud.view.component.View;
import br.ada.customer.crud.view.component.menu.AbstractMenuOptionView;
import br.ada.customer.crud.view.component.menu.MenuOptionView;
import br.ada.customer.crud.view.component.menu.impl.GoBackOptionView;
import br.ada.customer.crud.view.component.menu.impl.SubMenuView;

import java.util.Arrays;

public class OrderMenuView extends AbstractMenuOptionView implements MenuOptionView {

    public static final String MENU_CODE = "3";
    public static final Integer MENU_ORDER = 3;

    private View comeFrom;

    public OrderMenuView(View comeFrom) {
        super(MENU_CODE, MENU_ORDER);
        this.comeFrom = comeFrom;
    }

    @Override
    public void render() {
        System.out.println(MENU_CODE + " - Pedido");
    }

    @Override
    public void selected() {
        SubMenuView subMenuView = new SubMenuView(
                Arrays.asList(
                        new CreateOrderMenuView(),
                        new AddItemMenuView(),
                        new GoBackOptionView(comeFrom)
                )
        );
        subMenuView.render();
    }

}
