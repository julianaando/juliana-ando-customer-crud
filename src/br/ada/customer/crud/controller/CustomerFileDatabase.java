package br.ada.customer.crud.controller;

import br.ada.customer.crud.model.Customer;

import java.io.*;

public class CustomerFileDatabase implements CustomerRepository {

    @Override
    public void save(Customer customer) throws CustomerRepositoryException {
        File file = new File("./customers/customer_one.dat");
        try {
            FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(output);
            objOut.writeObject(customer);
            objOut.close();
            output.close();
        } catch (FileNotFoundException exception) {
            try {
                file.createNewFile();
                save(customer);
            } catch(IOException exception1) {
                throw new CustomerRepositoryException();
            }
        } catch(IOException exception) {
            throw new CustomerRepositoryException();
        }
    }

    @Override
    public Customer read() {
        return null;
    }

    @Override
    public Customer readByDocument(String document) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

}
