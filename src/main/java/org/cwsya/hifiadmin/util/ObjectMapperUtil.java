package org.cwsya.hifiadmin.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author cws
 * 序列化工具类(单例)
 */
public class ObjectMapperUtil {

    private static ObjectMapper intstance;

    public static ObjectMapper getIntstance() {
        if (null==intstance){
            synchronized (ObjectMapper.class){
                if (null==intstance){
                    intstance=new ObjectMapper();
                }
            }
        }
        return intstance;
    }

    private ObjectMapperUtil() {
    }

}
