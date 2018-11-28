package com.kk.weather.service.impl;

import com.kk.weather.dao.PictureDao;
import com.kk.weather.dao.UserDao;
import com.kk.weather.entity.Picture;
import com.kk.weather.service.PictureService;
import com.kk.weather.util.PictureUtil;
import com.mysql.cj.util.StringUtils;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author KGZ
 * @date 2018/11/28 10:15
 */

/**
 *@Transactional
 */

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Autowired
    private UserDao userDao;

    /**
     * pictureUtil :通过实现Util类对文件进行控制
     */
    private PictureUtil pictureUtil=new PictureUtil();

    /**
     *  dir :获得文件存储路径
     */
    private String dir=pictureUtil.dir;

    @Override
    public boolean insertPicture(MultipartFile file, Picture picture){
        try{
            if(StringUtils.isNullOrEmpty(picture.getPictureType())){
                throw new Exception("没有添加文件信息");
            }
            int pictureId=pictureDao.insert(picture);
            String fileName=pictureId+".jpg";
            boolean success=pictureUtil.modify(file,fileName,false);
            if(success==false){
                throw new Exception("文件加入失败");
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modifyPicture(MultipartFile file, Picture picture) {
        return false;
    }

    @Override
    public boolean deletePicture(int pictureId) {
        try{
            String fileName=pictureId+".jpg";
            int success=pictureDao.delete(pictureId);
            if(success<=0){
                throw new Exception("不存在该文件");
            }
            boolean su=pictureUtil.delete(fileName,false);
            if(su==false){
                throw new Exception("无法删除该文件");

            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Picture> getList() {
        return null;
    }

    @Override
    public Picture get(int id) {
        return null;
    }
}
