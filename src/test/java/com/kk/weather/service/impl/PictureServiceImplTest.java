package com.kk.weather.service.impl;

import com.kk.weather.entity.Picture;
import com.kk.weather.service.PictureService;
import org.apache.http.entity.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author: KGZ
 * @Date: 2018/12/2 0002 15:00
 * @Version 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureServiceImplTest {

    @Autowired
    private PictureService pictureService;

    @Test
    public void insertPicture() throws IOException {
        File file = new File("D:\\图片\\艾拉\\12.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        Picture picture=new Picture();
        picture.setPictureType("aa");
        pictureService.insertPicture(multipartFile,picture);
    }

    @Test
    public void modifyPicture() {
    }

    @Test
    public void deletePicture() {
    }

    @Test
    public void getList() {
    }

    @Test
    public void get() {
    }
}