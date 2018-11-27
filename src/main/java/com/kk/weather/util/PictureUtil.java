package com.kk.weather.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
/**
 *
 * @author KGZ
 * @date 2018/11/27
 */
public class PictureUtil {
    public String dir="D:\\workspace\\weather\\img";

    public PictureUtil() {
        File dir1=new File(dir);
        if(!dir1.isDirectory()){
            dir1.mkdir();
        }
        dir1=new File(dir+"\\icon");
        if(!dir1.isDirectory()){
            dir1.mkdir();
        }
    }

    public boolean modify(MultipartFile file, String fileName, boolean isIcon){
        if(file.isEmpty()){
            return false;
        }
        String path;
        if(isIcon==true){
            path=dir+"\\icon\\"+fileName;
        }else{
            path=dir+"\\"+fileName;
        }
        File img=new File(path);
        if(img.exists()){
            img.delete();
        }
        OutputStream writer= null;
        try {
            writer = new FileOutputStream(img);
            byte[] bytes = file.getBytes();
            writer.write(bytes);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String fileName,boolean isIcon){
        String path;
        if(isIcon==true){
            path=dir+"\\icon\\"+fileName;
        }else{
            path=dir+"\\"+fileName;
        }
        File file=new File(path);
        if(!file.exists()){
            return false;
        }else{
            file.delete();
            return true;
        }
    }
}
