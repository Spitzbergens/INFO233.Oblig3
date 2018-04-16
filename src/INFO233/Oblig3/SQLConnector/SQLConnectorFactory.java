package INFO233.Oblig3.SQLConnector;



import java.io.File;
import java.sql.*;

public class SQLConnectorFactory {

    private static File schema = new File("oblig3v1_database.sql");
    private static Connection connection = null;

    public Connection connect(){


        String url = "jdbc:sqlite:oblig3v1_database.db";

        if (SQLSchemaReader.fileExists()) {
            System.out.println("Connecting..");
            try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else {
            try {
                System.out.println("File didn't exists. Creating it from schema.");
                connection = DriverManager.getConnection(url);
                SQLSchemaReader.intitializeDB(connection, schema);
            } catch (SQLException b) {
                b.printStackTrace();
            }
        }
        return connection;
    }



    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected(){
        return connection != null;
    }


    }





