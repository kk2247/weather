package com.kk.weather.service;

import com.kk.weather.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author KGZ
 * @date 2018/11/26
 */
@Service
public interface UserService {
    int loginIn(String account , String password);
    //boolean loginOut();
    int register(User user);
    boolean fillInformation(User user, MultipartFile file);
    boolean modifyIcon(User user, MultipartFile file);
}
