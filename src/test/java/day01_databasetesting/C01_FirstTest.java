package day01_databasetesting;



public class C01_FirstTest {

    /*
    Software testing  :  Expected data ile actual datanin karsilastirilmasindan ibarettir
    Expected Data     :  Gereksinimlere gore beklenen data
    Actual Data       :  Database den gelen asil data
    */

    public static void main(String[] args) {

        String expectedData="selenium";
        String actualData="seleniuum";
        if (expectedData.equals(actualData)){
            System.out.println("Test 1 Passed");
        }else {
            System.out.println("Test 1 Failed");
        }

        int expectedNumber=7;
        int actualNumber=7;
        if (expectedNumber==actualNumber){
            System.out.println("Test 2 Passed");
        }else {
            System.out.println("Test 2 Failed");
        }


    }



}
