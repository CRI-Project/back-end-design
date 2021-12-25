package com.lzz.climate.exception;


import com.lzz.climate.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    public R allExceptionHandler(HttpServletRequest request, Exception e)
    {
        log.info("stack trace: {}" , (Object) e.getStackTrace());
        log.info("message: {}" , e.getMessage());
        return R.error(HttpStatus.SC_INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

        return  R.error(HttpStatus.SC_BAD_REQUEST,e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public R handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        return  R.error(HttpStatus.SC_BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(RRException.class)
    public R handlehandleRRException(RRException e){
        return  R.error(HttpStatus.SC_FORBIDDEN , e.getMsg());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public R handleAccessDeniedException(AccessDeniedException e){
        return R.error(HttpStatus.SC_FORBIDDEN , e.getMessage());
    }


}