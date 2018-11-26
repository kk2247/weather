package com.kk.weather.dao;

import com.kk.weather.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends BasicDao<User> {
    User getUserByAccountAndPassword(@Param("account") String account, @Param("password") String password);
    User getUserByAccountAndEmail(@Param("account") String account,@Param("email") String email);
    int getIdByEmail(@Param("email")String email);
}
