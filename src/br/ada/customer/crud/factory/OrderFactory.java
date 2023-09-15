package br.ada.customer.crud.factory;

import br.ada.customer.crud.integration.database.MemoryDatabase;
import br.ada.customer.crud.integration.email.OrderEmailNotifierImpl;
import br.ada.customer.crud.integration.memoryrepository.OrderEntityMerge;
import br.ada.customer.crud.integration.memoryrepository.OrderMemoryRepositoryImpl;
import br.ada.customer.crud.integration.sms.OrderSmsNotifierImpl;
import br.ada.customer.crud.integration.sms.SendSms;
import br.ada.customer.crud.usecases.*;
import br.ada.customer.crud.usecases.impl.*;
import br.ada.customer.crud.usecases.repository.OrderRepository;
import br.ada.customer.crud.integration.email.SendEmail;
import br.ada.customer.crud.usecases.impl.ValidationStatusOrderImpl;
import br.ada.customer.crud.usecases.impl.ValidationPlaceOrderImpl;

public class OrderFactory {

    public static ICreateOrderUseCase createUseCase() {
        return new CreateOrderUseCaseImpl(
                createRepository(),
                CustomerFactory.createRepository()
        );
    }

    public static IOrderItemUseCase orderItemUseCase() {
        return new OrderItemUseCaseImpl(
                createRepository()
        );
    }

    public static IPlaceOrderUseCase placeOrderUseCase() {
        return new PlaceOrderUseCaseImpl(
                createRepository(),
                new ValidationStatusOrderImpl(),
                new ValidationPlaceOrderImpl(),
                new OrderEmailNotifierImpl(new SendEmail()),
                new OrderSmsNotifierImpl(new SendSms()));
    }

    public static IPayOrderUseCase payOrderUseCase() {
        return new PayOrderUseCaseImpl(
                createRepository(),
                new OrderEmailNotifierImpl(new SendEmail()),
                new OrderSmsNotifierImpl(new SendSms())

        );
    }

    public static IShippingOrderUseCase shippingUseCase() {
        return new OrderShippingUseCaseImpl(
                createRepository(),
                new OrderEmailNotifierImpl(new SendEmail()),
                new OrderSmsNotifierImpl(new SendSms())
        );
    }

    public static OrderRepository createRepository() {
        return new OrderMemoryRepositoryImpl(
                MemoryDatabase.getInstance(),
                new OrderEntityMerge(MemoryDatabase.getInstance())
        );
    }
}
