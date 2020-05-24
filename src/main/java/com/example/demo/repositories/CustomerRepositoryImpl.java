package com.example.demo.repositories;

import com.example.demo.models.CustomerDTO;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private Connection conn;
    private static final String CREATE_CUSTOMER_SQL = "INSERT INTO customer" + "(cus_id, cus_first_name, cus_last_name, cus_phone, cus_address, cus_zip, cus_city, cus_drivers_license_number, cus_email) VALUES" + "(?,?,?,?,?,?,?,?,?);";
    private static final String EDIT_CUSTOMER_SQL = "UPDATE customer SET cus_first_name =?, cus_last_name =?, cus_phone =?, cus_address =?, cus_zip =?, cus_city =?, cus_drivers_license_number =?, cus_email =? WHERE cus_id=?;";
    private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customer WHERE cus_id =?";


    public CustomerRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    /*
    +----------------------------------+
    |         Create customer          |
    +----------------------------------+
    */

    @Override
    public void create(CustomerDTO customer) {
        try {

            PreparedStatement prep = conn.prepareStatement(CREATE_CUSTOMER_SQL);
            {
                prep.setInt(1, customer.getCusId());
                prep.setString(2, customer.getCusFirstName());
                prep.setString(3, customer.getCusLastName());
                prep.setInt(4, customer.getCusPhone());
                prep.setString(5, customer.getCusAddress());
                prep.setInt(6, customer.getCusZip());
                prep.setString(7, customer.getCusCity());
                prep.setInt(8, customer.getCusDriversLicense());
                prep.setString(9, customer.getCusEmail());

                prep.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
    +---------------------------------+
    |          Find customer          |
    +---------------------------------+
    */

    @Override
    public CustomerDTO read(int cusId) {
        CustomerDTO customerToReturn = new CustomerDTO();
        try {
            PreparedStatement getSingleCustomer = conn.prepareStatement("SELECT * FROM customer WHERE cus_id=?");
            getSingleCustomer.setInt(1, cusId);
            ResultSet rs = getSingleCustomer.executeQuery();
            while (rs.next()) {
                customerToReturn = new CustomerDTO();
                customerToReturn.setCusId(rs.getInt("cus_id"));
                customerToReturn.setCusFirstName(rs.getString(2));
                customerToReturn.setCusLastName(rs.getString(3));
                customerToReturn.setCusPhone(rs.getInt(4));
                customerToReturn.setCusAddress(rs.getString(5));
                customerToReturn.setCusZip(rs.getInt(6));
                customerToReturn.setCusCity(rs.getString(7));
                customerToReturn.setCusDriversLicense(rs.getInt(8));
                customerToReturn.setCusEmail(rs.getString(9));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return customerToReturn;
    }

    /*
    +----------------------------------+
    |          See all customers       |
    +----------------------------------+
    */

    @Override
    public List<CustomerDTO> readAll() {
        List<CustomerDTO> allCustomers = new ArrayList<CustomerDTO>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerDTO tempCustomer = new CustomerDTO();

                tempCustomer.setCusId(rs.getInt("cus_id"));
                tempCustomer.setCusFirstName(rs.getString(2));
                tempCustomer.setCusLastName(rs.getString(3));
                // tempCustomer.setCusPhone(String.valueOf(rs.getInt(4)));
                tempCustomer.setCusPhone(rs.getInt(4));
                tempCustomer.setCusAddress(rs.getString(5));
                // tempCustomer.setCusZip(String.valueOf(rs.getInt(6)));
                tempCustomer.setCusZip(rs.getInt(6));
                tempCustomer.setCusCity(rs.getString(7));
                //tempCustomer.setCusDriversLicense(String.valueOf(rs.getInt(8)));
                tempCustomer.setCusDriversLicense(rs.getInt(8));
                tempCustomer.setCusEmail(rs.getString(9));

                allCustomers.add(tempCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }

        /*
    +----------------------------------+
    |          Edit customer          |
    +----------------------------------+
    */

    @Override
    public void edit(CustomerDTO customerDTO) {
        try {

            PreparedStatement prep = conn.prepareStatement(EDIT_CUSTOMER_SQL);

            prep.setString(1, customerDTO.getCusFirstName());
            prep.setString(2, customerDTO.getCusLastName());
            prep.setInt(3, customerDTO.getCusPhone());
            prep.setString(4, customerDTO.getCusAddress());
            prep.setInt(5, customerDTO.getCusZip());
            prep.setString(6, customerDTO.getCusCity());
            prep.setInt(7, customerDTO.getCusDriversLicense());
            prep.setString(8, customerDTO.getCusEmail());
            prep.setInt(9, customerDTO.getCusId());
            prep.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void delete(int cusId) {

        try {
            PreparedStatement prep = conn.prepareStatement(DELETE_CUSTOMER_SQL);

            prep.setInt(1, cusId);
            prep.executeUpdate();




            {


            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}