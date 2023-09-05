package rikkei.academy.service;

import rikkei.academy.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
