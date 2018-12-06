package com.kk.weather.dao;

import com.kk.weather.entity.UserWeather;

import java.util.List;

/**
 * @Author: KGZ
 * @Date: 2018/12/6 0006 15:40
 * @Version 1.8
 */
public interface UserWeatherDao extends BasicDao<UserWeather> {
    List<UserWeather> getWeatherByUserId(int userId);
}
