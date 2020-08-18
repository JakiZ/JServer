package com.jaki.jserver.test;

import com.jaki.jserver.bean.Student;
import com.jaki.jserver.util.CommonUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanUtilsTest {
    @Test
    public void map2Bean(){

        try {
            Map<String,Object> map = new HashMap();
            map.put("id",1);
            map.put("name","jaki");
            map.put("gender",true);

            Student student = new Student();
            BeanUtils.populate(student,map);
            System.out.println(student);


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToBean(){
        Map<String,Object> map = new HashMap();
        map.put("id",1);
        map.put("name","jaki");
        map.put("gender",true);

        Student student = CommonUtil.toBean(map, Student.class);
        System.out.println(student);
    }
}
