package br.ada.customer.crud.usecases;

public interface INotifier<T> {

    void registered(T object);

    void updated(T object);

    void deleted(T object);
}
