package br.ada.customer.crud.examples.interfaces;

public class Celta extends CarroACombustao {

    @Override
    public void injectarCombustivel() {
        throw new RuntimeException("Nem uso combustível.....");
    }

}
