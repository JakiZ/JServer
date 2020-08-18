package com.jaki.jserver.test;

import com.jaki.jserver.util.CommonUtil;
import com.jaki.jserver.util.VerifyCode;
import org.junit.Test;


public class CommonUtilTest {

    @Test
    public void testGetUUID(){
        String uuid = CommonUtil.getUUID();
        System.out.println(uuid);
    }


}
