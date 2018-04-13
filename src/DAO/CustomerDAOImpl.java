package DAO;

import Entities.Category;
import Entities.Customer;
import INFO233.Oblig3.SQLConnector.SQLConnectorFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl {

    private static SQLConnectorFactory connector = new SQLConnectorFactory();


    public Customer accessCustomer(int id) {

        Connection con = connector.connect();
        Customer customer = new Customer();

        try{
            Statement stmnt = con.createStatement();
            ResultSet custResults = stmnt.executeQuery("SELECT * FROM customer " +
                    "WHERE " + id +";");
            if (custResults.next()){
                customer.setCustomerId(custResults.getInt("customer_id"));
                customer.setCustomerName(custResults.getString("customer_name"));
                customer.setAddress(custResults.getInt("address"));
                customer.setPhoneNumber(custResults.getString("phone_number"));
                customer.setBillingAccount(custResults.getString("billing_account"));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            connector.disconnect();
        }
        return customer;
    }

    public void deleteCustomer(int id){

        Connection conn = connector.connect();

        try{
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(20);
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM customer WHERE customer_id = " + id +";");
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connector.disconnect();
        }
    }

    public void addCustomer(Customer customer){

        Connection conn = connector.connect();

        try{
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(20);

            PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO customer (customer_id, customer_name, address, phone_number, billing_account) " +
                    "VALUES (?,?,?,?,?);");
            prepStatement.setInt(1, customer.getCustomerId());
            prepStatement.setString(2, customer.getCustomerName());
            prepStatement.setInt(3, customer.getAddress());
            prepStatement.setString(4, customer.getPhoneNumber());
            prepStatement.setString(5, customer.getBillingAccount());
            prepStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connector.disconnect();
        }
    }

    private List<Customer> getAllAddresses(){
        Customer customer = new Customer();
        Connection conn = connector.connect();
        List<Customer> all = new ArrayList<>();

        String query = "SELECT * FROM customer;";

        try{
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setAddress(resultSet.getInt("address"));
                customer.setPhoneNumber(resultSet.getString("phone_number"));
                customer.setBillingAccount(resultSet.getString("billing_account"));
                all.add(customer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connector.disconnect();
        }
        return all;
    }




}
