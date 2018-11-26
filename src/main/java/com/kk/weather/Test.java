package com.kk.weather;

import com.kk.weather.util.OutputUtil;
import jdk.internal.dynalink.linker.LinkerServices;

import java.util.List;

public class Test {
    public static void main(String[] args){
        OutputUtil outputUtil=new OutputUtil();
        List<String> strings=outputUtil.getOutput("广州");
        //System.out.println(strings.toString());
    }
}
