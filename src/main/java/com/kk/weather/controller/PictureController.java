package com.kk.weather.controller;

import com.kk.weather.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: KGZ
 * @Date: 2018/12/2 0002 13:58
 * @Version 1.8
 */
@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;


}
