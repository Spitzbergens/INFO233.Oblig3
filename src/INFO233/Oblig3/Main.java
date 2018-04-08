package INFO233.Oblig3;

import javax.sql.rowset.CachedRowSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;



public class Main{

    private static Connection con;

    public static void connectDatabase() throws SQLException, FileNotFoundException {

        String url = "jdbc:sqlite:oblig3v1_database.db";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
            if (con != null){
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("Navn på driver: " + meta.getDriverName());
                System.out.println("Database opprettet");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        File schema = new File("oblig3v1_database.sql");
        InputStream input = new FileInputStream(schema);
        importSQL(con, input);

    }

    public static void disconnectDatabase() throws SQLException{
        if (con != null && !con.isClosed()){
            try{
                con.close();
            }catch(SQLException e){
                throw e;
            }
        }
    }

    public static void importSQL(Connection conn, InputStream input) throws SQLException{
        Scanner s = new Scanner(input);
        s.useDelimiter("(;(\r)?\n)|(--\n)");
        Statement statement = null;
        try{
            statement = conn.createStatement();
            while(s.hasNext()){
                String line = s.next();
                if(line.startsWith("/*!") && line.endsWith("*/")){
                    int i = line.indexOf(' ');
                    line.substring(i + 1, line.length() - "*/".length());
                }
                if (line.trim().length() > 0){
                    statement.execute(line);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (statement != null){
                statement.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException, FileNotFoundException {

        String filename = "oblig3v1_database.db";
        File f = new File(filename);


        if (f.isFile()){
            System.out.println("File already exists");
        }else {
            connectDatabase();
        }
    }

    public Connection getConnection(){
        return con;
    }

    public void queryInvoice() throws SQLException{

    String invoiceQuery =
            "SELECT customer_name, billing_account, street_number, street_name, postal_code, postal_town, dato, product_name, description, price " +
            "FROM customer, address, category, invoice, invoice_items, product;";

    Statement getStatement = con.createStatement();
    ResultSet rs = getStatement.executeQuery(invoiceQuery);
    while(rs.next()){
        System.out.println(rs.getString(1));
    }
    }

    public static ResultSet execQuery(String query) throws SQLException{
        Statement stmnt = null;
        ResultSet rs = null;
        CachedRowSet s = null;


        return null;

    }






}
