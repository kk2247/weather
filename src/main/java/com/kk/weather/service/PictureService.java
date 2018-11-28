package com.kk.weather.service;

import com.kk.weather.entity.Picture;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *
 * @author KGZ
 * @date 2018/11/26
 */
@Service
public interface PictureService {
    boolean insertPicture(MultipartFile file, Picture picture);
    boolean modifyPicture(MultipartFile file, Picture picture);
    boolean deletePicture(int pictureId);
    List<Picture> getList();
    Picture get(int id);
}
