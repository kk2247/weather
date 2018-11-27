package com.kk.weather.dao;

import java.util.List;
/**
 *
 * @author KGZ
 * @date 2018/11/26
 */
public interface BasicDao<T> {
    int insert(T t);
    int modify(T t);
    int delete(int id);
    List<T> getList();
    T get(int id);
}
