package br.ada.customer.crud.controller.customer;

import br.ada.customer.crud.controller.common.CrudRepository;
import br.ada.customer.crud.controller.common.RepositoryException;
import br.ada.customer.crud.model.Customer;

import java.io.*;
import java.util.List;

public class CustomerFileDatabase implements CustomerRepository, CrudRepository<Customer, Long> {

    @Override
    public void save(Customer customer) throws RepositoryException {
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
            } catch (IOException exception1) {
                throw new RepositoryException("Falha ao gravar cliente", exception);
            }
        } catch (IOException exception) {
            throw new RepositoryException("Falha ao gravar cliente", exception);
        }
    }

    @Override
    public Customer findById(Long aLong) throws RepositoryException {
        return null;
    }

    @Override
    public List<Customer> listAll() {
        return null;
    }

    @Override
    public Customer findByDocument(String document) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

}
