package DAO;

import Entities.Address;
import Entities.Category;
import INFO233.Oblig3.SQLConnector.SQLConnectorFactory;


import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl {

    private static SQLConnectorFactory connector = new SQLConnectorFactory();

    public Category accessCategory(int id){
        Connection conn = connector.connect();
        Category category = new Category();

        try{
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM category " +
                    "WHERE category_id = " + id + ";");

            category.setCategoryId(result.getInt("category_id"));
            category.setCategoryName(result.getString("category_name"));

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connector.disconnect();
        }
        return category;
    }

    public void addCategory(Category category){
        Connection con = connector.connect();
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(20);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO category (category_id, category_name)" +
                            "values (?, ?);"
            );
            preparedStatement.setInt(1, category.getCategoryId());
            preparedStatement.setString(2, category.getCategoryName());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connector.disconnect();
        }
    }

    public void deleteCategory(int id){
        Connection con = connector.connect();
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(20);
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM category WHERE id = " + id + ";");
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connector.disconnect();
        }
    }

    private List<Category> getAllAddresses(){
        Category category = new Category();
        Connection conn = connector.connect();
        List<Category> all = new ArrayList<>();

        String query = "SELECT * FROM category;";

        try{
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setCategoryName(resultSet.getString("category_name"));
                all.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connector.disconnect();
        }
        return all;
    }
}
