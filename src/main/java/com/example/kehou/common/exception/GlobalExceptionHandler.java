package com.example.kehou.common.exception;

import com.example.kehou.common.constant.HttpStatus;
import com.example.kehou.common.exception.job.ServiceException;
import com.example.kehou.common.exception.job.TokenException;
import com.example.kehou.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ShuangLian
 * @date 2021/11/24 14:16
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
//
//    /**
//     * token错误
//     */
//    @ExceptionHandler(TokenException.class)
//    public Result handleTokenException(TokenException e, HttpServletRequest request){
//        String requestURI = request.getRequestURI();
//        log.error("请求地址{}，{}",requestURI,e.getMessage());
//        return Result.error(HttpStatus.ERROR,e.getMessage());
//
//    }
//    /**
//     * 业务异常
//     */
//    @ExceptionHandler(ServiceException.class)
//    public Result handleServiceException(TokenException e, HttpServletRequest request){
//        System.out.println("捕获异常");
//        String requestURI = request.getRequestURI();
//        log.error("请求地址{}，{}",requestURI,e.getMessage());
//        return Result.error(HttpStatus.ERROR,e.getMessage());
//
//    }
//
//    /**
//     * 请求方式不支持
//     */
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public Result handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
//                                                          HttpServletRequest request)
//    {
//        String requestURI = request.getRequestURI();
//        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
//        return  Result.error(e.getMessage());
//    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return Result.error(e.getMessage());
    }

}
