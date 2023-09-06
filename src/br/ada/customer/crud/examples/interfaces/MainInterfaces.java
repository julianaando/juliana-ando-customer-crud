package br.ada.customer.crud.examples.interfaces;

public class MainInterfaces {

    public static void main(String[] args) {
        andarComCarro(new Celta());
    }

    public static void andarComCarro(CarroACombustao carro) {
        carro.injectarCombustivel();
        carro.ligarMotores();
        carro.deslocar();
        carro.desligarMotores();
    }

    public static void voar(Voavel voavel) {
        voavel.decolar();
        voavel.voar();
        voavel.pousar();
    }

}
