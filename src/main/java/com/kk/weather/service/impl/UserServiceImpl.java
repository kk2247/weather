package com.kk.weather.service.impl;

import com.kk.weather.dao.UserDao;
import com.kk.weather.entity.User;
import com.kk.weather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean loginIn(String account, String password) {
        User user=userDao.getUserByAccountAndPassword(account,password);
        if(user!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean loginOut() {
        return false;
    }

    @Override
    public int register(User user) {
        return 0;
    }

    @Override
    public boolean fillInformation(User user, String icon) {
        return false;
    }
}
