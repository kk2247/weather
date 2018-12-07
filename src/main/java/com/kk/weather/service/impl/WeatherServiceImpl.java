package com.kk.weather.service.impl;

import com.kk.weather.dao.UserWeatherDao;
import com.kk.weather.entity.UserWeather;
import com.kk.weather.entity.Weather;
import com.kk.weather.service.UserService;
import com.kk.weather.service.WeatherService;
import com.kk.weather.util.OutputUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    private OutputUtil outputUtil;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<List<Weather>> getWeatherByUserId(int userId) {
        try{
            List<UserWeather> userWeathers=userWeatherDao.getWeatherByUserId(userId);
            List<List<Weather>> weatherList=new ArrayList<>();
            for(UserWeather userWeather:userWeathers){
                weatherList.add(outputUtil.getOutput(userWeather.getCity()));
            }
            return weatherList;
        }catch (Exception e){
            throw new RuntimeException("无法进行天气查询");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Weather> getWeatherByCity(String cityName) {
        try{
            List<Weather> weathers=outputUtil.getOutput(cityName);
            return weathers;
        }catch(Exception e){
            throw new RuntimeException("无法正确获得天气状况");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<UserWeather> getCityByUserId(int userId) {
        try{
            List<UserWeather> userWeathers=userWeatherDao.getWeatherByUserId(userId);
            return userWeathers;
        }catch (Exception e){
            throw new RuntimeException("没有绑定城市");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertCity(UserWeather userWeather) {
        try{
            int ueId=userWeatherDao.insert(userWeather);
        }

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
