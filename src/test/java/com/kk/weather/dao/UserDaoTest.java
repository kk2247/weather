package com.kk.weather.dao;

import com.kk.weather.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insert(){
        User user=new User();
        user.setAccount("2122");
        user.setNickName("1211");
        user.setEmail("1awa");
        user.setPassword("eqweq");
        userDao.insert(user);
    }

    @Test
    public void getUserByAccountAndPassword() {
        System.out.println(userDao.getUserByAccountAndPassword("2122","eqweq").getEmail());
    }

    @Test
    public void getUserByAccountAndEmail() {
        System.out.println(userDao.getUserByAccountAndEmail("2122","1awa").getNickName());
    }

    @Test
    public void getList(){
        System.out.println(userDao.getList().size());
    }

    @Test
    public void get(){
        System.out.println(userDao.get(1).getNickName());
    }

    @Test
    public void modify(){
        User user=new User();
        user.setAccount("1234");
        user.setNickName("4321");
        user.setEmail("1323");
        user.setPassword("313");
        user.setUserId(1);
        userDao.modify(user);
    }

    @Test
    public void delete(){
        userDao.delete(1);
    }

    @Test
    public void getIdByEmail(){
        System.out.println(userDao.getIdByEmail("1awa"));
    }


}