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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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

    /**
     * 测试ajax用例
     * @return
     */
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
            map.put("result","true");
            return "("+gson.toJson(map)+")";
        }else{
            map.put("result","false");
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
            map.put("result","illegality");
            return map;
        }else{
            user.setPassword(passwordUtil.getMd5(user.getPassword()));
            int userId = userService.register(user);
            if(userId>0){

                map.put("result","true");
            }else{
                map.put("result","false");
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
    @RequestMapping(value = "/information",method = RequestMethod.POST)
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
            map.put("result","false");
        }else{
            map.put("result","true");
        }
        return "("+gson.toJson(map)+")";

    }

    /**
     * 用户改变头像
     * @param userId
     * @param file
     * @return
     */
    @RequestMapping(value = "/icon",method = RequestMethod.POST)
    public String icon(@RequestParam(value = "account",required = false) String account,
                       @RequestParam(value = "userId",required = false) int userId,MultipartFile file){
        Map<String ,Object> map=new HashMap<>();
        User user=new User();
        Gson gson=new Gson();
        if(userId<=0){
            if(StringUtils.isEmpty(account)==false){
                user.setAccount(account);
            }else{
                map.put("result","illegality");
                return "("+gson.toJson(map)+")";
            }
        }else{
            user.setUserId(userId);
        }
        boolean success=userService.modifyIcon(user,file);
        if(success==false){
            map.put("result","false");
        }else{
            map.put("result","true");
        }
        return "("+gson.toJson(map)+")";
    }


    /**
     * 对用户进行登出操作，清除cookies
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/out",method = RequestMethod.GET)
    public String out(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap<>();
        Gson gson =new Gson();
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie==============");
            map.put("result","false");
        } else {
            map.put("result","true");
        }
        return "("+gson.toJson(map)+")";
    }


}
