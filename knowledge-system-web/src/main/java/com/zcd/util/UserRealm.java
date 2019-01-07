package com.zcd.util;

import com.zcd.entity.User;
import com.zcd.interfaces.IUserInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-24 17:53
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class UserRealm extends AuthorizingRealm {

    private  RetryLimitHashedCredentialsMatcher credentialsMatcher;

    @Autowired
    private IUserInterface userInterface ;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName=(String)token.getPrincipal();

        User user=userInterface.selectUserByName(userName);
        if(user==null){
            //抛出用户不存在
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getAccount(),user.getPassword(),
                ByteSource.Util.bytes(user.getAccount()),getName());

        return authenticationInfo;
    }
}
