package com.kk.weather.service.impl;

import com.kk.weather.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.apache.http.entity.ContentType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author: KGZ
 * @Date: 2018/11/27 0027 20:19
 * @Version 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void loginIn() {
        System.out.println(userService.loginIn("2122","eqweq"));
    }

    @Test
    public void register() {
        User user=new User();
        user.setAccount("1234");
        user.setPassword("4321");
        userService.register(user);
    }

    @Test
    public void fillInformation() throws IOException {
        File pdfFile = new File("D:\\图片\\艾拉\\12.jpg");
        FileInputStream fileInputStream = new FileInputStream(pdfFile);
        MultipartFile multipartFile = new MockMultipartFile(pdfFile.getName(), pdfFile.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        User user=new User();
        user.setUserId(9);
        user.setAccount("1234");
        user.setPassword("4321");
        user.setEmail("2222");
        user.setNickName("kk");
        userService.fillInformation(user,multipartFile);

    }

    @Test
    public void modifyIcon() throws IOException {
        File pdfFile = new File("D:\\图片\\艾米莉娅\\363d3f15b58e11a9efea315d5ebd1df3.jpeg");
        FileInputStream fileInputStream = new FileInputStream(pdfFile);
        MultipartFile multipartFile = new MockMultipartFile(pdfFile.getName(), pdfFile.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        User user=new User();
        user.setAccount("1234");
        user.setPassword("4321");
        userService.modifyIcon(user,multipartFile);
    }
}