package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import  org.testng.asserts.SoftAssert;



public class SoftAsserts {

    SoftAsserts softAsserts = new SoftAsserts();

    @Test
    public  void  test(){
        System.out.println("=========");
        softAsserts.assertTrue(false);
        System.out.println("+++++++++++++++++++++");
        softAsserts.assertEquals(1,1);




    }
}
