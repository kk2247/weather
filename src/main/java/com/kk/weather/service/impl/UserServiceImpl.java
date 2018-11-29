package com.kk.weather.service.impl;

import com.kk.weather.dao.IconDao;
import com.kk.weather.dao.PictureDao;
import com.kk.weather.dao.UserDao;
import com.kk.weather.entity.User;
import com.kk.weather.service.UserService;
import com.kk.weather.util.PictureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 *
 * @author KGZ
 * @date 2018/11/27
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PictureDao pictureDao;

    @Autowired
    private IconDao iconDao;

    private PictureUtil pictureUtil=new PictureUtil();

    @Override
    public int loginIn(String account, String password) {
        User user=userDao.getUserByAccountAndPassword(account,password);
        if(user!=null){
            return user.getUserId();
        }
        return -1;
    }

    @Override
    public int register(User user) {
        if(StringUtils.isEmpty(user.getAccount())==false && StringUtils.isEmpty(user.getPassword())==false){
            int userId;
            try{
                user.setNickName(user.getAccount());
                userId=userDao.insert(user);
            }catch (Exception e){
                throw new RuntimeException("已经存在该用户");
            }
            userId=user.getUserId();
            String path=pictureUtil.dir+"\\icon\\"+userId+".jpg";
            File file=new File("D:\\workspace\\weather\\img\\00.jpg");
            File img=new File(path);

            try {
                int bytesum = 0;
                int byteread = 0;
                if (file.exists()) {
                    InputStream inStream = new FileInputStream(file);
                    FileOutputStream fs = new FileOutputStream(img);
                    byte[] buffer = new byte[1444];
                    int length;
                    while ( (byteread = inStream.read(buffer)) != -1) {
                        bytesum += byteread;
                        fs.write(buffer, 0, byteread);
                    }
                    inStream.close();
                }
            }
            catch (Exception e) {
                System.out.println("复制单个文件操作出错");
                e.printStackTrace();

            }
            return userId;
        }
        return -1;
    }

    @Override
    public boolean fillInformation(User user, MultipartFile file) {
        if(user.getUserId()<=0){
            user.setUserId(userDao.getUserByAccount(user.getAccount()).getUserId());
        }
        int userId=user.getUserId();
        userDao.modify(user);
        try{
            boolean insertIcon=pictureUtil.modify(file,userId+".jpg",true);
            if(insertIcon==true){
                return true;
            }else{
                throw new RuntimeException("无法正常插入图片");
            }
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public boolean modifyIcon(User user, MultipartFile file) {
        if(user.getUserId()<=0){
            user.setUserId(userDao.getUserByAccount(user.getAccount()).getUserId());
        }
        int userId=user.getUserId();
        try{
            boolean insertIcon=pictureUtil.modify(file,userId+".jpg",true);
            if(insertIcon==true){
                return true;
            }else{
                 throw new RuntimeException("无法正常插入图片");
            }
        }catch (Exception e){
            throw e;
        }
    }
}
