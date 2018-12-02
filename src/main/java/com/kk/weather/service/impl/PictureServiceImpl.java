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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertPicture(MultipartFile file, Picture picture){
        try{
            if(StringUtils.isNullOrEmpty(picture.getPictureType())){
                throw new Exception("没有添加文件信息");
            }
            int pictureId=pictureDao.insert(picture);
            String path=dir+"\\"+pictureId+".jpg";
            picture.setPath(path);
            pictureDao.modify(picture);
            String fileName=pictureId+".jpg";
            pictureUtil.modify(file,fileName,false);
            return true;
        }catch (Exception e){
            throw new RuntimeException("无法插入图片");
        }
    }

    /**
     * 管理员从管理员界面对展示图片进行插入
     * @param file
     * @param picture
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean modifyPicture(MultipartFile file, Picture picture) {
        try{
            if(picture.getPictureId()<=0||StringUtils.isNullOrEmpty(picture.getPath())){
                return false;
            }else{

            }
        }catch (Exception e){
            throw new RuntimeException("目前无法更改用户信息");
        }
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
        List<Picture> pictures=pictureDao.getList();
        if(pictures.size()==0){
            return null;
        }else{
            return pictures;
        }
    }

    @Override
    public Picture get(int id) {
        return null;
    }
}
