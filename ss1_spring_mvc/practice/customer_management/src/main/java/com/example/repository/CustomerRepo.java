package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepo implements ICustomerRepo {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Thien oc cho", "thienoccho@gmail.com", "hue"));
        customerList.add(new Customer(2, "Nguyen", "nguyen@gmail.com", "quang binh"));
        customerList.add(new Customer(3, "Hai", "hai@gmail.com", "da nang"));
    }

    @Override
    public List<Customer> showList() {
        return customerList;
    }

    @Override
    public Customer findId(int id) {
        return customerList.get(id-1);
    }
}
