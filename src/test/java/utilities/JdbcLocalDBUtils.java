package utilities;

import java.sql.*;

public class JdbcLocalDBUtils {

    private static Connection connection;
    private static Statement statement;

    /**
     * Bu method belirtilen parametreleri kullanarak database e baglanti kurar
     * @return connection
     */

    public static Connection connnectToDatabase(){
        String url="jdbc:postgresql://localhost:5432/myDatabase";
        String user="tester";
        String password="tester";
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;

    }

    /**
     * Bu method daha once olusturulan connection uzerinden bir statement olusturur
     * @return statement
     */

    public static Statement createStatement(){
        try {
            statement = connnectToDatabase().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    /**
     * Bu method parametre olarak veriler SQL sorgusunu calistirir ve sonuclari bir resultset olarak return eder
     * @param sql
     * @return resultset
     */

    public static ResultSet executeQuery(String sql){

        try {
            return createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //baglantiyi kapat
    public static void closeConnection(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
