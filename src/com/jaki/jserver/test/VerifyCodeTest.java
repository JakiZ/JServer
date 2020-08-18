package com.jaki.jserver.test;

import com.jaki.jserver.util.VerifyCode;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VerifyCodeTest {

    @Test
    public void testGetVerifyCode(){
        VerifyCode verifyCode = VerifyCode.getInstance();
        String code = verifyCode.getVerifyCode("f:/a.png");
        System.out.println(code + "," + verifyCode.getImageType());
    }
    

}
