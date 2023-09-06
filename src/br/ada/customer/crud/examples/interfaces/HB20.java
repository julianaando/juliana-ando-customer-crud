package br.ada.customer.crud.examples.interfaces;

public class HB20 extends CarroACombustao{

    @Override
    public void injectarCombustivel() {
        //Aquecimento do etanol se a temperatura estiver abaixo de 20
        super.injectarCombustivel();
    }
}
