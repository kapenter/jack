package com.zcd.util;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-24 17:40
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class RetryLimitHashedCredentialsMatcher  extends HashedCredentialsMatcher {

    public RetryLimitHashedCredentialsMatcher() {
    }


    public RetryLimitHashedCredentialsMatcher(EhCacheManager ehCacheManager) {
        this.ehCacheManager = ehCacheManager;
    }

    private EhCacheManager ehCacheManager ;

    private  String hashAlgorithmName ;


    private  int  hashIterations ;


    private  boolean  storedCredentialsHexEncoded ;

}
