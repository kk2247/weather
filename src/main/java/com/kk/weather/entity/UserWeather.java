package com.kk.weather.entity;

/**
 * @Author: KGZ
 * @Date: 2018/12/6 0006 15:38
 * @Version 1.8
 */
public class UserWeather {

    private int uwId;

    private int userId;

    private String city;

    public int getUwId() {
        return uwId;
    }

    public void setUwId(int uwId) {
        this.uwId = uwId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
