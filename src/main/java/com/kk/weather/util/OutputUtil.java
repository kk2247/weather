package com.kk.weather.util;

import com.kk.weather.entity.Weather;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author KGZ
 * @date 2018/11/26
 */
public class OutputUtil {
    WeatherUtils weatherUtils=new WeatherUtils();

    /**
     * 通过城市名字获得三天以内的天气信息
     * @param cityName 城市名字，国内城市用中文 例：广州，上海
     * @return
     */
    public List<Weather>  getOutput(String cityName){
        List<Weather> weatherList=new ArrayList<>();
        String output=weatherUtils.getWeather(cityName);
        String[] separated = output.split("\n");
        String[] today=separated[0].split("#");

        String[] dateTime=today[3].split(" ");
        String[] tem=today[4].split("；");
        String wind=tem[1].split("：")[1];
        String humidity=tem[2].split("：")[1];
        String[] ultravioletAir=today[5].split("。");
        String ultraviolet=ultravioletAir[0].split("：")[1];
        String air=ultravioletAir[1].split("：")[1];
        String skin = today[6].split("，")[2];
        String cloth=separated[2].split("：")[1];
        String weather=separated[5].split("#")[1].split(" ")[1];
        String highlow=separated[5].split("#")[2];
        String highest=highlow.split("/")[1];
        String lowest=highlow.split("/")[0];
        String date=dateTime[0];
        String time=dateTime[1];
        String nowTem=tem[0].split("：")[2];
        Weather weather1=new Weather(cityName,date,time,nowTem,highest,lowest,wind,humidity,ultraviolet,air,
                skin,cloth,weather);

        String[] tomorrow=separated[5].split("#");
        String[] wea=tomorrow[6].split(" ");
        date=wea[0];
        weather=wea[1];
        highest=tomorrow[7].split("/")[1];
        lowest=tomorrow[7].split("/")[0];
        wind = tomorrow[8];
        Weather weather2=new Weather(cityName,date,highest,lowest,wind,weather);

        wea=tomorrow[11].split(" ");
        date=wea[0];
        weather=wea[1];
        highest=tomorrow[12].split("/")[1];
        lowest=tomorrow[12].split("/")[0];
        wind = tomorrow[13];
        Weather weather3=new Weather(cityName,date,highest,lowest,wind,weather);

        wea=tomorrow[16].split(" ");
        date=wea[0];
        weather=wea[1];
        highest=tomorrow[17].split("/")[1];
        lowest=tomorrow[17].split("/")[0];
        wind = tomorrow[18];
        Weather weather4=new Weather(cityName,date,highest,lowest,wind,weather);

        wea=tomorrow[21].split(" ");
        date=wea[0];
        weather=wea[1];
        highest=tomorrow[22].split("/")[1];
        lowest=tomorrow[22].split("/")[0];
        wind = tomorrow[23];
        Weather weather5=new Weather(cityName,date,highest,lowest,wind,weather);

        weatherList.add(weather1);
        weatherList.add(weather2);
        weatherList.add(weather3);
        weatherList.add(weather4);
        weatherList.add(weather5);
        return weatherList;
    }
}