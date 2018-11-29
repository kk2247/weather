package com.kk.weather.controller;
/**
 * @Author: KGZ
 * @Date: 2018/11/29 0029 14:25
 * @Version 1.8
 */

import com.google.gson.Gson;
import com.kk.weather.entity.User;
import com.kk.weather.service.UserService;
import com.kk.weather.util.PasswordUtil;
import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: KGZ
 * @Date: 2018/11/29 0029 14:25
 * @Version 1.8
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 对账号密码进行加密化
     */
    private PasswordUtil passwordUtil=new PasswordUtil();

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        Map<String,Object> map=new HashMap<>();
        map.put("result","1234321");
        Gson gson = new Gson();
        return "result"+"("+gson.toJson(map)+")";
    }

    /**
     * 对用户传输过来的账号与数据库中数据进行认证
     * @param account 账号
     * @param password 加密前的密码
     * @param response
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("account") String account,@RequestParam("password") String password, HttpServletResponse response){
        Gson gson = new Gson();
        Map<String ,Object> map=new HashMap<>();
        String passwordMd5=passwordUtil.getMd5(password);
        int userId=userService.loginIn(account,passwordMd5);
        if(userId>0){
            Cookie cookie1=new Cookie("account",account);
            cookie1.setMaxAge(60*60*24*10);
            Cookie cookie2=new Cookie("password",passwordMd5);
            cookie2.setMaxAge(60*60*24*10);
            Cookie cookie3=new Cookie("userState","Online");
            cookie3.setMaxAge(60*60*24*10);
            Cookie cookie4=new Cookie("id",String.valueOf(userId));
            cookie4.setMaxAge(60*60*24*10);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.addCookie(cookie3);
            response.addCookie(cookie4);
            map.put("sucess","true");
            return "result"+"("+gson.toJson(map)+")";
        }else{
            map.put("sucess","false");
            return "("+gson.toJson(map)+")";
        }
    }

    /**
     * 对用户传输过来的账号信息进行注册
     * @param account
     * @param password
     * @param response
     * @return 返回一个Map显示结果并且将账号写入Cookie中
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String,Object> register(@RequestParam("account") String account, String password, HttpServletResponse response){
        Map<String ,Object>map=new HashMap<>();
        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        if(StringUtils.isEmpty(user.getAccount())||StringUtils.isEmpty(user.getPassword())){
            map.put("sucess","illegality");
            return map;
        }else{
            user.setPassword(passwordUtil.getMd5(user.getPassword()));
            int userId = userService.register(user);
            if(userId>0){
                map.put("sucess","treu");
            }else{
                map.put("sucess","false");
            }
            return map;
        }
    }

    /**
     * 对用户信息进行更新
     * @param account
     * @param nickName
     * @param password
     * @param constellation
     * @param email
     * @return
     */
    @RequestMapping(value = "/infomation",method = RequestMethod.POST)
    public String infomation(String account,@RequestParam(value = "nickName",required = false) String nickName
                             ,@RequestParam(value = "password",required = false) String password,
                             @RequestParam(value = "constellation",required = false)String constellation,
                             @RequestParam(value = "email",required = false)String email,
                             @RequestParam("file") MultipartFile file) {
        Gson gson=new Gson();
        Map<String ,Object> map=new HashMap<>();
        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setNickName(nickName);
        user.setEmail(email);
        user.setConstellation(constellation);
        boolean success=userService.fillInformation(user,file);
        if(success==false){
            map.put("sucess","failed");
        }else{
            map.put("sucess","true");
        }
        return "("+gson.toJson(map)+")";

    }


}
