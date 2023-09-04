package br.ada.customer.crud.controller.common;

public class SendEmail {

    public void send(String from, String to, String content) {
        System.out.println("Enviando email de: " + from + ", para: " + to);
        System.out.println("Conteúdo: " + content);
    }

}
