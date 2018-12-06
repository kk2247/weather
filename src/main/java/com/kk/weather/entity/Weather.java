package com.kk.weather.entity;

import java.util.Date;

/**
 * @Author: KGZ
 * @Date: 2018/12/6 0006 15:41
 * @Version 1.8
 */
public class Weather {
    private String location;

    private String  date;

    private String time;

    private String nowTem;

    private String highest;

    private String lowest;

    private String wind;

    private String humidity;

    private String ultraviolet;

    private String air;

    private String skin;

    private String cloth;

    private String weather;

    public Weather() {
    }

    public Weather(String location, String date, String time, String nowTem, String highest, String lowest, String wind, String humidity, String ultraviolet, String air, String skin, String cloth, String weather) {
        this.location = location;
        this.date = date;
        this.time = time;
        this.nowTem = nowTem;
        this.highest = highest;
        this.lowest = lowest;
        this.wind = wind;
        this.humidity = humidity;
        this.ultraviolet = ultraviolet;
        this.air = air;
        this.skin = skin;
        this.cloth = cloth;
        this.weather = weather;
    }

    public Weather(String location, String date, String highest, String lowest, String wind, String weather) {
        this.location = location;
        this.date = date;
        this.highest = highest;
        this.lowest = lowest;
        this.wind = wind;
        this.weather = weather;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNowTem() {
        return nowTem;
    }

    public void setNowTem(String nowTem) {
        this.nowTem = nowTem;
    }

    public String getHighest() {
        return highest;
    }

    public void setHighest(String highest) {
        this.highest = highest;
    }

    public String getLowest() {
        return lowest;
    }

    public void setLowest(String lowest) {
        this.lowest = lowest;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(String ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getCloth() {
        return cloth;
    }

    public void setCloth(String cloth) {
        this.cloth = cloth;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
