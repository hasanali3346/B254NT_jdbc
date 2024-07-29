package jdbc_day02;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {

        //!!! 2.ADIM : Hangi DB , Hangi kullanici ve sifre
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/B254JDBC_nt",
                "B254nt",
                "password");

        //!!! 3.ADIM: statement olusturma, yazacagimiz query'leri statement nesnesi ile DB ye gonderecegiz
        Statement st=con.createStatement();
        System.out.println("success");

        // !!! update islemi oncesi kayitlarin isim ve maas bilgilerini ekrana basalim
        System.out.println("------------UPDATE ONCESI-------------");
        ResultSet rs=st.executeQuery("select*from developers");
        while(rs.next()){
            System.out.println(rs.getString("name")+" "+rs.getString("salary"));
        }

         //!!!  ÖRNEK1:developers tablosunda maaşı, ortalama maaştan az olanların maaşını ortalama maaş ile güncelleyiniz
        //subquery ortalama maas;
        //subquerysi select avg(salary) FROM developers
        String sql1="Update developers set salary=(select avg(salary) FROM developers) where salary<(select avg(salary) FROM developers)";
        int updated=st.executeUpdate(sql1);
        System.out.println("Guncellenen kayit sayisi = " + updated);

        // !!! update islemi sonrasi kayitlarin isim ve maas bilgilerini ekrana basalim
        System.out.println("-------Update Sonrasi---------------");
        ResultSet rs2 =st.executeQuery("select * from developers");
        while (rs2.next()){
            System.out.println(rs2.getString("name")+" "+(rs2.getDouble("salary")));
        }

        st.close();
        con.close();
    }
}
