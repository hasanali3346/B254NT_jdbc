package day01_databasetesting;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class C03_CityTest {

    /*
connect to the database
get city names from the 'cities' table
verify that there are at least 10 city names in the city_name column
close the connection
    */

    @Test
    public void cityTest() throws SQLException {
        //database e baglan
        String url="jdbc:postgresql://localhost:5432/myDatabase";
        String user="tester";
        String password="tester";
        Connection con=DriverManager.getConnection(url,user,password);
        Statement statament=con.createStatement();

        //cities tablosundan sehir isimlerini al
        String sql="select city_name from cities";
        ResultSet resultSet=statament.executeQuery(sql);

        //city_name sutununda en az 10 city name oldugunu doğrula
        int counter=0;
        while(resultSet.next()){
            counter++;
        }
        Assert.assertTrue(counter>9);

        //baglantiyi kapat
        con.close();
        statament.close();

    }

    @Test
    public void cityTest2() throws SQLException {

        //database e baglan
        String url="jdbc:postgresql://localhost:5432/myDatabase";
        String user="tester";
        String password="tester";
        Connection connection =DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();


        //cities tablosundan sehir isimlerini al
        String sql ="select count(city_name) from cities";
        ResultSet resultSet = statement.executeQuery(sql);

        //city_name sutununda en az 10 city name oldugunu doğrula
        resultSet.next();
        int actualResult = resultSet.getInt("count");
        Assert.assertTrue(actualResult>9);

        //baglantiyi kapat
        statement.close();
        connection.close();
    }





}
