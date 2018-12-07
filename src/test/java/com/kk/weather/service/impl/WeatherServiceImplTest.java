package com.kk.weather.service.impl;

import com.kk.weather.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: KGZ
 * @Date: 2018/12/7 0007 10:52
 * @Version 1.8
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void getWeatherByUserId() {
    }

    @Test
    public void getWeatherByCity() {
    }

    @Test
    public void getCityByUserId() {
    }

    @Test
    public void insertCity() {
    }

    @Test
    public void updateCity() {
    }

    @Test
    public void deleteCity() {
    }
}