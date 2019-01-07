package com.zcd.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-07 10:13
 **/
@Slf4j
public class AESUtil {

     final  static String  ENCODE_RULES="zhou";
     final static  String  AES="AES";


    public  static  String  aesEncode(String  content ){
        try {
            //1.构造秘钥生成器,指定AES算法啊,不区分大小写
            KeyGenerator keyGen=KeyGenerator.getInstance(AES);
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(ENCODE_RULES.getBytes());
            keyGen.init(128,secureRandom);

           //3.产生对称原始对称秘钥
            SecretKey originKey=keyGen.generateKey();

            //4.获取原始对称秘钥的字节数组
            byte[] originByte=originKey.getEncoded();

            //5.根据字节数组生成AES秘钥
            SecretKey key =new SecretKeySpec(originByte,AES);

            //6.根据指定算法AES自称密码器
            Cipher cipher=Cipher.getInstance(AES);

            //7.初始化密码器
            cipher.init(cipher.ENCRYPT_MODE,key);

            //8.获取加密内容的字节数组
            byte[]  encodeContentByte=content.getBytes();
            //9.根据密码器Cipher的初始化方式--加密:将数据加密
            byte[] byteAES=cipher.doFinal(encodeContentByte);

            //10.将机密后的byte转换成字符串
            return Base64Utils.encodeToString(byteAES);

        } catch (GeneralSecurityException e) {
            log.info("加解密异常",e);
        } catch (Exception e) {
            log.info("数据异常",e);
        }

        //出现错误返回null
        return  null;
    }



}
