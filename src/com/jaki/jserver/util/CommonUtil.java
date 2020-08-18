package com.jaki.jserver.util;

import org.apache.commons.beanutils.BeanUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

public class CommonUtil {

    /**
     * 判断集合是否位空
     *
     * @param collection
     * @return true 空或null；false，非空
     */
    public static boolean isCollectionEmpty(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 生成32位大写的随机字符串
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }


    /**
     * map -> Bean
     * @param map 存放bean属性的map集合
     * @param clazz 指定的bean类
     * @param <T> 指定bean类型
     * @return 指定bean实例
     */
    public static <T> T toBean(Map map, Class<T> clazz) {
        T instance = null;
        try {
            if (map == null || clazz == null) {
                return instance;
            }
            instance = clazz.newInstance();
            BeanUtils.populate(instance, map);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 下载文件时，处理文件名乱码
     * @param filename 原来的文件名
     * @param request 请求封装
     * @return 编码后的文件名，作为content-disposition的值的filename的值
     * @throws UnsupportedEncodingException
     */
    public static String downloadFileName(String filename, HttpServletRequest request) throws UnsupportedEncodingException {
        String agent = request.getHeader("User-Agent");
        if (agent.contains("Firefox")){
            BASE64Encoder encoder = new BASE64Encoder();
            filename = "=?utf-8?B?"
                    +encoder.encode(filename.getBytes("utf-8"))
                    +"?=";
        }else {
            filename = URLEncoder.encode(filename,"utf-8");
        }
        return filename;
    }



    /**
     * 判断address是否为邮箱地址
     * @param address 需要判断的地址
     * @return true：是邮箱地址；否则不是
     */
    public static boolean isEmailAddress(String address){
        if (address == null || address.isEmpty()){
            return false;
        }
        String pattern = "^[A-Za-z0-9]+@([A-Za-z0-9]+\\.){1,2}[A-Za-z0-9]+$";
        return Pattern.matches(pattern, address);
    }

}
