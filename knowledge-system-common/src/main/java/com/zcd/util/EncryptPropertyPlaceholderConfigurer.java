package com.zcd.util;


import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-06 17:56
 **/
public class EncryptPropertyPlaceholderConfigurer  extends PropertyPlaceholderConfigurer{

    private final String [] password ={ "master.password" ,"slave.password" };


    /**
     * 解密密码
     * @param propertyName
     * @param propertyValue
     * @return
     */
    @Override
    protected String convertProperty(String propertyName ,String propertyValue) {
        for (String pd: password){
            if(pd.equals(propertyName)){
                return  AESUtil.aesEncode(propertyValue);
            }
        }
        return super.convertProperty(propertyName,propertyValue);
    }
}
