package com.xu.studyspringboot.handler;

import com.xu.studyspringboot.utils.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 标记这个是一个异常处理类
 */
@RestControllerAdvice
public class CustomExtHandler {

    @ExceptionHandler(value = Exception.class)
    Object handlerException(Exception e, HttpServletRequest request) {
        return JsonData.buildError("Server Error 服务器开小差了", -2);
    }

}
