package com.kk.weather.service;

import com.kk.weather.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean loginIn(String account ,String password);
    boolean loginOut();
    int register(User user);
    boolean fillInformation(User user,String icon);

}
