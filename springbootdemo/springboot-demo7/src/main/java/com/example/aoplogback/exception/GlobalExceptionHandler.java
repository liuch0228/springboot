package com.example.aoplogback.exception;

import com.example.aoplogback.pojo.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    public GlobalExceptionHandler() {
    }

    /**
     * 处理CustomException异常之外的所有异常
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public  Object handleGloabalException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }

    /**
     * 处理CustomException
     * /test/customerexception 会走这个异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = CustomException.class)
    public @ResponseBody Object handleException(CustomException e){
        return new BaseResponse(e.getCode(), e.getMsg(), null);
    }

}
