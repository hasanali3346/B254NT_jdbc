package day01_databasetesting;

import org.junit.Assert;
import org.junit.Test;

public class C02_JunitFirstTest {


    @Test
    public void test01(){
        // assertEquals() :  parantez icinde belirtilen iki degerin birbirine esit olup olmadigini kontrol eder
        // esitse test passed (gecer) degilse failed (kalir) olur

        String expectedData="selenium";
        String actualData="seleniumm";

        Assert.assertEquals(expectedData,actualData);
    }

    @Test
    public void test02(){
        //assertTrue(boolean); parantez icindeki deger true ise test gecer(passed) degilse test kalir(failed).

        Assert.assertTrue("selenium".contains("e"));
        System.out.println("Consolda bu metin gorulebilir cunku yukaridaki test gecti");
        Assert.assertTrue(false);  //Test FAILED
        System.out.println("Consolda bu metni gormeyecegiz cunku yukaridaki test kaldi");

    }

    @Test
    public void test03(){
        /*
        //assertTrue(boolean); parantez icindeki deger FALSE ise test gecer degilse kalir
        */

        Assert.assertFalse("JAVA".contains("a"));//Test Passed
        Assert.assertFalse("JAVA".contains("A"));//Test Failed
    }

    @Test
    public void test04(){

        //assertTrue(boolean); parantez icindeki deger FALSE ise test kalir degilse gecer

        String expectedData="selenium";
        String actualData="seleniumm";
        Assert.assertNotEquals(expectedData,actualData);//Test PASSED
    }



}
