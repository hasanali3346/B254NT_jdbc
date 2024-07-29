package jdbc_day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //!!!1.ADIM : Driveri ekleme
        Class.forName("org.postgresql.Driver");//JDK 7 ile birlikte otomatik hale geldi yani 1.adimi artik kullanmak zorunda degiliz

        //!!! 2.ADIM : Hangi DB , Hangi kullanici ve sifre
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/B254JDBC_nt","B254nt","password");

        //!!! 3.ADIM: statement olusturma, yazacagimiz query'leri statement nesnesi ile DB ye gonderecegiz

        Statement st=con.createStatement();
        System.out.println("success");

        //!!! 4.ADIM:sorgulari olusturma
        //ÖRNEK 1:"workers" adında bir tablo oluşturup "worker_id,worker_name,salary" sütunlarını ekleyiniz.
        //boolean sql1=st.execute("create table workers(worker_id int,worker_name varchar(30),salary real)");
        //System.out.println("sql1 = " + sql1);
          /*
            execute:tüm sorguları çalıştırmak için kullanılır
             sorgunun sonucunda ResultSet alınıyorsa TRUE döndürür, aksi halde FALSE döndürür.
             1-DDL (Data Definition Language) -->FALSE ( Create gibi sorgular )
             2-DQL (Data Query Language) -->TRUE (Select gibi sorgular )
             2-DML (Data Manipulation Language) --> FALSE ( update, insert gibi sorgular )
            genellikle DDL için kullanılır.
         */
        // ORNEK2: "workers" tablosuna VARCHAR(20) tipinde "city" sutununu ekleyelim
        //boolean sql2=st.execute("ALTER table workers add column city varchar(20)");
        //System.out.println("sql2 = " + sql2); //false
        boolean sql3=st.execute("DROP table workers");

        //!!!5.ADIM : Kaynaklari kapatiyoruz
        st.close();
        con.close();

    }
}
