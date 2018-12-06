package com.kk.weather.service.impl;

import com.kk.weather.dao.UserWeatherDao;
import com.kk.weather.entity.UserWeather;
import com.kk.weather.entity.Weather;
import com.kk.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: KGZ
 * @Date: 2018/12/6 0006 17:22
 * @Version 1.8
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private UserWeatherDao userWeatherDao;

    @Override
    public List<Weather> getWeatherByUserId(int userId) {
        return null;
    }

    @Override
    public List<Weather> getWeatherByCity(String cityName) {
        return null;
    }

    @Override
    public List<UserWeather> getCityByUserId(int userId) {
        return null;
    }

    @Override
    public boolean insertCity(UserWeather userWeather) {
        return false;
    }

    @Override
    public boolean updateCity(UserWeather userWeather) {
        return false;
    }

    @Override
    public boolean deleteCity(int uwId) {
        return false;
    }
}
