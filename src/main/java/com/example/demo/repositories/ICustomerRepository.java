package com.example.demo.repositories;

import com.example.demo.models.CustomerDTO;

import java.util.List;

public interface ICustomerRepository {

    // CRUD operations

    public void create(CustomerDTO customer);

    public CustomerDTO read(int cusId);

    public List<CustomerDTO> readAll();

    public void edit(CustomerDTO customer);

    public void delete(int id);

}