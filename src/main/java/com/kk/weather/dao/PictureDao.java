package com.kk.weather.dao;

import com.kk.weather.entity.Picture;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 *
 * @author KGZ
 * @date 2018/11/26
 */
public interface PictureDao extends BasicDao<Picture>{
    //@Select("select * from picture where picture_type=#{pictureType} and mood=#{mood}")
    List<Picture> getPicByTypeAndMood(@Param("pictureType") String pictureType,@Param("mood")String mood);
    List<Picture> getPicByTypeAndCatalogue(@Param("pictureType") String pictureType,@Param("catalogue") String catalogue);
}
