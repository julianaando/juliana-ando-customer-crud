package br.ada.customer.crud.controller.common;

public class SendSms {

    public void send(String from, String to, String content) {
        System.out.println("Enviando sms de: " + from + ", para: " + to);
        System.out.println("Conteúdo: " + content);
    }

}
