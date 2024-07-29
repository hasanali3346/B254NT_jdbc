package jdbc_day01;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {

        //!!! 2.ADIM : Hangi DB , Hangi kullanici ve sifre
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/B254JDBC_nt","B254nt","password");

        //!!! 3.ADIM: statement olusturma, yazacagimiz query'leri statement nesnesi ile DB ye gonderecegiz
        Statement st=con.createStatement();
        System.out.println("success");

        //!!! 4.ADIM:sorgulari olusturma
        //st.execute("CREATE TABLE countries( id SERIAL PRIMARY KEY, country_name VARCHAR(100) )");

        //!!!   ÖRNEK 1:id'si 5 ile 10 arasında olan ülkelerin "country_name" bilgisini listeleyiniz.
        String query1="SELECT country_name FROM countries WHERE id between 5 and 10";
        boolean sql1=st.execute("SELECT country_name FROM countries WHERE id between 5 and 10");
        System.out.println("sql1 = " + sql1);

        //Verileri almak istersem
        ResultSet rs=st.executeQuery(query1);
        while (rs.next()) {
            System.out.println("Ulke Adı : " + rs.getString("country_name"));

        }
        //!!! 5.ADIM KAYNAKLARI KAPATIYORUZ
        st.close();
        con.close();


    }
}
