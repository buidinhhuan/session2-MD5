package rikkei.academy.repository;

import rikkei.academy.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);

}
