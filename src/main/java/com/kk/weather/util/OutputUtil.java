package com.kk.weather.util;

import java.util.ArrayList;
import java.util.List;

public class OutputUtil {
    WeatherUtils weatherUtils=new WeatherUtils();

    /**
     * 通过城市名字获得三天以内的天气信息
     * @param cityName 城市名字，国内城市用中文 例：广州，上海
     * @return
     */
    public List<String>  getOutput(String cityName){
        List<String> result=new ArrayList<>();
        String output=weatherUtils.getWeather(cityName);
        String[] separated = output.split("\n");
        String[] today=separated[0].split("#");
        result.add("地理信息："+today[0]);
        result.add(today[1]);
        result.add("时间："+today[3]);
        result.add(today[4]);
        result.add(today[5]);
        result.add(today[6]);
        for(int i=1;i<5&&i!=3;i++){
            result.add(separated[i]);
        }
        String[] tomorrow=separated[5].split("#");
        String[] wea=tomorrow[1].split(" ");
        result.add("时间："+wea[0]);
        result.add("天气："+wea[1]);
        result.add("温度："+tomorrow[2]);
        result.add("风向："+tomorrow[3]);
        wea=tomorrow[11].split(" ");
        result.add("时间："+wea[0]);
        result.add("天气："+wea[1]);
        result.add("温度："+tomorrow[12]);
        result.add("风向："+tomorrow[13]);
        wea=tomorrow[16].split(" ");
        result.add("时间："+wea[0]);
        result.add("天气："+wea[1]);
        result.add("温度："+tomorrow[17]);
        result.add("风向："+tomorrow[18]);
        wea=tomorrow[21].split(" ");
        result.add("时间："+wea[0]);
        result.add("天气："+wea[1]);
        result.add("温度："+tomorrow[22]);
        result.add("风向："+tomorrow[23]);
        return result;
    }
}