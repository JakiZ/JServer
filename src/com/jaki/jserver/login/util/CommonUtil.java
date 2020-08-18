package com.jaki.jserver.login.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class CommonUtil {

    /**
     * 判断字符串str是否为null 或 为空
     * @param str 要判断的字符串
     * @return true str是否为null 或 为空
     */
    public static boolean isStringEmpty(String str){
        if (str == null || str.isEmpty()){
            return true;
        }
        return false;
    }

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


}
