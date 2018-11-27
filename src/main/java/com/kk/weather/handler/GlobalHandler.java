package com.kk.weather.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author KGZ
 * @date 2018/11/26
 */
@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest req, Exception e){
        Map<String ,Object> modelMap=new HashMap<String ,Object>();
        modelMap.put("sucess",false);
        modelMap.put("errMsg",e.getMessage());
        return modelMap;
    }
}
