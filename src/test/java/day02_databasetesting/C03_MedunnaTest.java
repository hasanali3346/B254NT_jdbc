package day02_databasetesting;

import org.junit.Assert;
import org.junit.Test;
import utilities.JdbcMedunnaDBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class C03_MedunnaTest {
    @Test
    public void test01() throws SQLException {
        //    Kullanıcı veritabanına bağlanır
        //    (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6)
        //    Kullanıcı, oluşturulan odayı getirmek için room_number ile sorgu gönderir
        //    Kullanıcı, oda bilgilerinin doğru kaydedildiğini doğrular
        //    Kullanıcı, bağlantıyı kapatır

        //1)Expected datalar düzenlenir
        String expectedRoomType="TWIN";
        boolean expectedStatus=true;
        String expectedDescription="Batch 254 Database testi icin olusturuldu";

        //2)Database den gerekli query ile datalar cekilir
        ResultSet resultSet = JdbcMedunnaDBUtils.executeQuery("select * from room where room_number = 313131312");
        resultSet.next();

        //3)Actual datalar düzenlenir
        String actualRoomType = resultSet.getString("room_type");
        boolean actualStatus = resultSet.getBoolean("status");
        String actualDescription = resultSet.getString("description");

        //4)Assertionlar yapilir
        Assert.assertEquals(expectedRoomType,actualRoomType);
        Assert.assertEquals(expectedStatus,actualStatus);
        Assert.assertEquals(expectedDescription,actualDescription);

        JdbcMedunnaDBUtils.closeConnection();
    }

    @Test
    public void test02() throws SQLException {
        ResultSet resultSet = JdbcMedunnaDBUtils.executeQuery("select * from room where room_number = 313131312");
        resultSet.next();
        Assert.assertEquals("TWIN",resultSet.getString("room_type"));
        Assert.assertTrue(resultSet.getBoolean("status"));
        Assert.assertEquals("Batch 254 Database testi icin olusturuldu",resultSet.getString("description"));
        JdbcMedunnaDBUtils.closeConnection();
    }




}