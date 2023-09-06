package br.ada.customer.crud.examples.interfaces;

public abstract class Carro implements VeiculoAutomotor, Movimento {

    @Override
    public void ligarMotores() {
        System.out.println("Motores ligados");
    }

    @Override
    public void desligarMotores() {
        System.out.println("Motores desligados");
    }

    @Override
    public void deslocar() {
        System.out.println("Olha mãe, estou andando....");
    }

}
