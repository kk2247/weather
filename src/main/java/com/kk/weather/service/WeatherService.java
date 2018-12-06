package com.kk.weather.service;

import com.kk.weather.entity.UserWeather;
import com.kk.weather.entity.Weather;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: KGZ
 * @Date: 2018/12/6 0006 17:13
 * @Version 1.8
 */
@Service
public interface WeatherService {
    List<Weather> getWeatherByUserId(int userId);
    List<Weather> getWeatherByCity(String cityName);
    List<UserWeather> getCityByUserId(int userId);
    boolean insertCity(UserWeather userWeather);
    boolean updateCity(UserWeather userWeather);
    boolean deleteCity(int uwId);
}
