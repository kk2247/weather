package com.kk.weather.util;/**
 * @Author: KGZ
 * @Date: 2018/11/29 0029 14:35
 * @Version 1.8
 */

import org.springframework.util.DigestUtils;

/**
 * @Author: KGZ
 * @Date: 2018/11/29 0029 14:35
 * @Version 1.8
 */
public class PasswordUtil {

    private final String slat="sdafafaasfafafwsvzdbsd23e#$%";

    public String getMd5(String password){
        String base=password+"/"+slat;
        //特定生成md5方法
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
