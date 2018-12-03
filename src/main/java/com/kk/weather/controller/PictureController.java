package com.kk.weather.controller;

import com.google.gson.Gson;
import com.kk.weather.entity.Picture;
import com.kk.weather.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: KGZ
 * @Date: 2018/12/2 0002 13:58
 * @Version 1.8
 */
@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;

    private Gson gson;

    @RequestMapping(value = "/mood",method = RequestMethod.POST)
    public String insertMood(@RequestParam("mood")String mood, @RequestParam("file")MultipartFile file){
        Map<String,Object> map=new HashMap<>();
        Picture picture=new Picture();
        picture.setPictureType("mood");
        picture.setMood(mood);
        boolean success=pictureService.insertPicture(file,picture);
        if(success==true){
            map.put("sucess","true");
        }else{
            map.put("sucess","false");
        }
        return "("+gson.toJson(map)+")";
    }
}
