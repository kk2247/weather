package com.kk.weather.dao;

import com.kk.weather.entity.Picture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureDaoTest {

    @Autowired
    private PictureDao pictureDao;

    @Test
    public void insert(){
        Picture pic=new Picture();
        pic.setMood("1");
        pic.setPictureType("2");
        pic.setCatalogue("3");
        pictureDao.insert(pic);
    }

    @Test
    public void getPicByTypeAndMood() {
        List<Picture> pic=pictureDao.getPicByTypeAndMood("2","1");
        System.out.println(pic.size());
    }

    @Test
    public void getPicByTypeAndCatalogue() {
        List<Picture> pic = pictureDao.getPicByTypeAndCatalogue("2","3");
        System.out.println(pic.size());
    }

    @Test
    public void getList(){
        System.out.println(pictureDao.getList().size());
    }

    @Test
    public void get(){
        System.out.println(pictureDao.get(2).getCatalogue());
    }

    @Test
    public void modify(){
        Picture pic=new Picture();
        pic.setMood("5");
        pic.setPictureType("2");
        pic.setCatalogue("2");
        pic.setPictureId(2);
        pictureDao.modify(pic);
    }

    @Test
    public void delete(){
        pictureDao.delete(2);
    }
}